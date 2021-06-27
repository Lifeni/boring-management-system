package app.lifeni.bms.controller;

import app.lifeni.bms.entity.api.request.LoginRequest;
import app.lifeni.bms.entity.api.request.ResetPasswordRequest;
import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.entity.message.DataMessage;
import app.lifeni.bms.service.AuthService;
import app.lifeni.bms.utils.Constants;
import app.lifeni.bms.utils.CookiesUtils;
import app.lifeni.bms.utils.JSON;
import app.lifeni.bms.utils.JWTUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/")
    public JsonNode hello(HttpServletRequest request, HttpServletResponse response) {
        var id = CookiesUtils.verifyReturnId(request);
        if (id != -1) {
            try {
                var result = authService.authQueryUser(id);
                var message = new DataMessage("认证通过", result);

                response.setStatus(200);
                return JSON.t(message);
            } catch (Exception exception) {
                var message = new BaseMessage("服务器出错");

                response.setStatus(500);
                return JSON.t(message);
            }
        } else {
            var message = new BaseMessage("登录失效");

            response.setStatus(401);
            return JSON.t(message);
        }
    }

    @PostMapping("/login")
    public JsonNode login(@RequestBody LoginRequest payload, HttpServletResponse response) {
        var result = authService.authLogin(payload);
        if (result != null) {
            var message = new DataMessage("登录成功", result);

            var map = new HashMap<String, Object>();
            map.put("name", result.getUserName());
            map.put("id", result.getUserId());
            map.put("role", result.getRoleId());

            var token = JWTUtils.createToken(map);

            var cookie = new Cookie("token", token);
            cookie.setMaxAge(Constants.EXPIRES);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            response.addCookie(cookie);
            response.setStatus(200);

            return JSON.t(message);
        }

        var message = new BaseMessage("登录失败");
        response.setStatus(401);
        return JSON.t(message);
    }

    @PostMapping("/logout")
    public void logout(HttpServletResponse response) {
        var cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");

        response.addCookie(cookie);
        response.setStatus(205);
    }

    @PostMapping("/reset-password")
    public JsonNode resetPassword(@RequestBody ResetPasswordRequest payload, HttpServletResponse response) {
        var result = authService.authResetPassword(payload);
        if (result) {
            var message = new BaseMessage("重置密码成功");
            response.setStatus(200);
            return JSON.t(message);
        }

        var message = new BaseMessage("重置密码失败");
        response.setStatus(401);
        return JSON.t(message);
    }
}
