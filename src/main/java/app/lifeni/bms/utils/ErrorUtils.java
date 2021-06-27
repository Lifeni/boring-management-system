package app.lifeni.bms.utils;

import app.lifeni.bms.entity.message.BaseMessage;
import com.fasterxml.jackson.databind.JsonNode;

import javax.servlet.http.HttpServletResponse;

public class ErrorUtils {
    public static JsonNode dbErrorHandler(HttpServletResponse response) {
        var message = new BaseMessage("服务器出错");
        response.setStatus(500);
        return JSON.t(message);
    }

    public static JsonNode authErrorHandler(HttpServletResponse response, long role) {
        if (role == -1) {
            var message = new BaseMessage("身份认证失效");
            response.setStatus(401);
            return JSON.t(message);
        }

        var message = new BaseMessage("身份验证失败");
        response.setStatus(403);
        return JSON.t(message);
    }
}
