package app.lifeni.bms.controller;

import app.lifeni.bms.entity.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public Message login(HttpServletRequest request) {
        System.out.println(request);

        var message = new Message();
        message.setMessage("登录成功");
        return message;
    }
}
