package app.lifeni.bms.controller;

import app.lifeni.bms.entity.api.request.LoginRequest;
import app.lifeni.bms.entity.api.request.ResetPasswordRequest;
import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.entity.message.DataMessage;
import app.lifeni.bms.service.AuthService;
import app.lifeni.bms.utils.ToJSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public JsonNode login(@RequestBody LoginRequest payload, HttpServletRequest request, HttpServletResponse response) {
        // TODO: 登录逻辑

        var result = authService.authLogin(payload);
        if (result != null) {
            var message = new DataMessage("登录成功", result);
            response.setStatus(200);
            return new ToJSON().t(message);
        }

        var message = new BaseMessage("登录失败");
        response.setStatus(401);
        return new ToJSON().t(message);
    }

    @PostMapping("/logout")
    public JsonNode logout(HttpServletRequest request, HttpServletResponse response) {
        // TODO: 注销逻辑

        var message = new BaseMessage("注销成功");
        response.setStatus(205);
        return new ToJSON().t(message);
    }

    @PostMapping("/reset-password")
    public JsonNode resetPassword(@RequestBody ResetPasswordRequest payload, HttpServletRequest request, HttpServletResponse response) {
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
}
