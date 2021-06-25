package app.lifeni.bms.controller;

import app.lifeni.bms.entity.api.request.ResetPasswordByAdminRequest;
import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.entity.message.DataMessage;
import app.lifeni.bms.service.UserService;
import app.lifeni.bms.utils.JWTUtil;
import app.lifeni.bms.utils.ToJSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public JsonNode getAll(HttpServletRequest request, HttpServletResponse response) {
        var role = verify(request);
        if (role == 0) {
            var users = userService.queryAllUsers();
            var message = new DataMessage("获取所有用户", users);
            response.setStatus(200);
            return new ToJSON().t(message);

        } else if (role == -1) {
            var message = new BaseMessage("身份认证失效");
            response.setStatus(401);
            return new ToJSON().t(message);
        }

        var message = new BaseMessage("身份验证失败");
        response.setStatus(403);
        return new ToJSON().t(message);
    }

    @PostMapping("/{userId}/reset-password")
    public JsonNode resetPassword(@PathVariable("userId") long userId, @RequestBody ResetPasswordByAdminRequest payload, HttpServletRequest request, HttpServletResponse response) {
        var role = verify(request);
        if (role == 0) {
            var result = userService.resetPasswordByAdmin(userId, payload);
            if (result) {
                var message = new BaseMessage("重置密码成功");
                response.setStatus(200);
                return new ToJSON().t(message);
            }

            var message = new BaseMessage("服务器出错");
            response.setStatus(500);
            return new ToJSON().t(message);

        } else if (role == -1) {
            var message = new BaseMessage("身份认证失效");
            response.setStatus(401);
            return new ToJSON().t(message);
        }

        var message = new BaseMessage("身份验证失败");
        response.setStatus(403);
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
                    return jwt.getClaim("role").asLong();
                }
            }
        }
        return -1;
    }
}
