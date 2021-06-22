package app.lifeni.bms.controller;

import app.lifeni.bms.mapper.FriendMapper;
import app.lifeni.bms.po.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/")
public class FriendController {

    @Autowired
    FriendMapper friendMapper;

    @GetMapping("/test")
    public List<Friend> getFriend(HttpServletRequest request) {
        return friendMapper.getFriend();
    }
}
