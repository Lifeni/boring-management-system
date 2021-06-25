package app.lifeni.bms.controller;

import app.lifeni.bms.entity.api.request.ResetPasswordByAdminRequest;
import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.entity.message.DataMessage;
import app.lifeni.bms.service.UserService;
import app.lifeni.bms.utils.CookiesUtils;
import app.lifeni.bms.utils.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public JsonNode getAll(HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var users = userService.queryAllUsers();
            var message = new DataMessage("获取所有用户", users);
            response.setStatus(200);
            return JSON.t(message);

        } else if (role == -1) {
            var message = new BaseMessage("身份认证失效");
            response.setStatus(401);
            return JSON.t(message);
        }

        var message = new BaseMessage("身份验证失败");
        response.setStatus(403);
        return JSON.t(message);
    }

    @PostMapping("/{userId}/reset-password")
    public JsonNode resetUserPassword(@PathVariable("userId") long userId, @RequestBody ResetPasswordByAdminRequest payload, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = userService.resetPasswordByAdmin(userId, payload);
            if (result) {
                var message = new BaseMessage("重置密码成功");
                response.setStatus(200);
                return JSON.t(message);
            }

            var message = new BaseMessage("服务器出错");
            response.setStatus(500);
            return JSON.t(message);

        } else if (role == -1) {
            var message = new BaseMessage("身份认证失效");
            response.setStatus(401);
            return JSON.t(message);
        }

        var message = new BaseMessage("身份验证失败");
        response.setStatus(403);
        return JSON.t(message);
    }

    @DeleteMapping("/{userId}")
    public JsonNode deleteUser(@PathVariable("userId") long userId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = userService.deleteUser(userId);
            if (result) {
                var message = new BaseMessage("删除用户成功");
                response.setStatus(200);
                return JSON.t(message);
            }

            var message = new BaseMessage("服务器出错");
            response.setStatus(500);
            return JSON.t(message);

        } else if (role == -1) {
            var message = new BaseMessage("身份认证失效");
            response.setStatus(401);
            return JSON.t(message);
        }

        var message = new BaseMessage("身份验证失败");
        response.setStatus(403);
        return JSON.t(message);
    }
}
