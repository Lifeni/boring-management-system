package app.lifeni.bms.controller;

import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.entity.message.DataMessage;
import app.lifeni.bms.service.StudentService;
import app.lifeni.bms.utils.CookiesUtils;
import app.lifeni.bms.utils.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public JsonNode getAll(HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var students = studentService.queryAllStudents();
            var message = new DataMessage("获取所有学生信息", students);
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
}