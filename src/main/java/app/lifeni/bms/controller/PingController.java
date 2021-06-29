package app.lifeni.bms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/ping")
public class PingController {
    @GetMapping("/")
    public String ping(HttpServletResponse response) {
        response.setStatus(200);
        return "Pong";
    }
}
