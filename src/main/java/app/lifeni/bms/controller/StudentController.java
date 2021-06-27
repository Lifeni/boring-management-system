package app.lifeni.bms.controller;

import app.lifeni.bms.entity.api.request.EditStudentRequest;
import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.entity.message.DataMessage;
import app.lifeni.bms.entity.model.Student;
import app.lifeni.bms.service.StudentService;
import app.lifeni.bms.utils.CookiesUtils;
import app.lifeni.bms.utils.ErrorUtils;
import app.lifeni.bms.utils.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @PostMapping("/")
    public JsonNode addStudent(@RequestBody Student payload, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = studentService.addStudent(payload);
            if (result) {
                var message = new BaseMessage("添加学生成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }


    @PutMapping("/{userId}")
    public JsonNode editStudent(@PathVariable("userId") long userId, @RequestBody EditStudentRequest payload, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = studentService.editStudent(userId, payload);
            if (result) {
                var message = new BaseMessage("修改学生信息成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @DeleteMapping("/{userId}")
    public JsonNode deleteStudent(@PathVariable("userId") long userId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = studentService.deleteStudent(userId);
            if (result) {
                var message = new BaseMessage("删除学生成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }
}