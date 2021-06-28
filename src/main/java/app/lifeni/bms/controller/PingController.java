package app.lifeni.bms.controller;

import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.utils.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/ping")
public class PingController {
    @GetMapping("/")
    public JsonNode ping(HttpServletResponse response) {
        var message = new BaseMessage("Pong");
        response.setStatus(401);
        return JSON.t(message);
    }
}
