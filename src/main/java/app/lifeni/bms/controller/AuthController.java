package app.lifeni.bms.controller;

import app.lifeni.bms.entity.api.request.LoginRequest;
import app.lifeni.bms.entity.api.request.ResetPasswordRequest;
import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.entity.message.DataMessage;
import app.lifeni.bms.service.AuthService;
import app.lifeni.bms.utils.JWTUtil;
import app.lifeni.bms.utils.ToJSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/")
    public JsonNode hello(HttpServletRequest request, HttpServletResponse response) {
        var id = verify(request);
        if (id != -1) {
            try {
                var result = authService.authQueryUser(id);
                var message = new DataMessage("认证通过", result);

                response.setStatus(200);
                return new ToJSON().t(message);
            } catch (Exception exception) {
                var message = new BaseMessage("服务器出错");

                response.setStatus(500);
                return new ToJSON().t(message);
            }
        } else {
            var message = new BaseMessage("登录失效");

            response.setStatus(403);
            return new ToJSON().t(message);
        }
    }

    @PostMapping("/login")
    public JsonNode login(@RequestBody LoginRequest payload, HttpServletResponse response) {
        var result = authService.authLogin(payload);
        if (result != null) {
            var message = new DataMessage("登录成功", result);

            var map = new HashMap<String, Object>();
            map.put("id", result.getUserId());

            var token = JWTUtil.createToken(map);

            var cookie = new Cookie("token", token);
            cookie.setMaxAge(10 * 60);
            cookie.setHttpOnly(true);

            response.addCookie(cookie);
            response.setStatus(200);

            return new ToJSON().t(message);
        }

        var message = new BaseMessage("登录失败");
        response.setStatus(401);
        return new ToJSON().t(message);
    }

    @PostMapping("/logout")
    public void logout(HttpServletResponse response) {
        var cookie = new Cookie("token", null);
        cookie.setMaxAge(0);

        response.setStatus(205);
        response.addCookie(cookie);
    }

    @PostMapping("/reset-password")
    public JsonNode resetPassword(@RequestBody ResetPasswordRequest payload, HttpServletResponse response) {
        var result = authService.authResetPassword(payload);
        if (result) {
            var message = new BaseMessage("重置密码成功");
            response.setStatus(200);
            return new ToJSON().t(message);
        }

        var message = new BaseMessage("重置密码失败");
        response.setStatus(401);
        return new ToJSON().t(message);
    }

    private long verify(HttpServletRequest request) {
        var cookies = request.getCookies();

        if (cookies != null) {
            var token = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals("token")).findFirst();
            if (token.isPresent()) {
                var jwt = JWTUtil.verifyToken(token.get().getValue());
                if (jwt != null) {
                    return jwt.getClaim("id").asLong();
                }
            }
        }
        return -1;
    }
}
