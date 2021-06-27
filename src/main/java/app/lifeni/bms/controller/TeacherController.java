package app.lifeni.bms.controller;

import app.lifeni.bms.entity.api.request.EditTeacherRequest;
import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.entity.message.DataMessage;
import app.lifeni.bms.entity.model.Teacher;
import app.lifeni.bms.service.TeacherService;
import app.lifeni.bms.utils.CookiesUtils;
import app.lifeni.bms.utils.ErrorUtils;
import app.lifeni.bms.utils.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public JsonNode getAll(HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var teachers = teacherService.queryAllTeachers();
            var message = new DataMessage("获取所有教师信息", teachers);
            response.setStatus(200);
            return JSON.t(message);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @PostMapping("/")
    public JsonNode addTeacher(@RequestBody Teacher payload, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = teacherService.addTeacher(payload);
            if (result) {
                var message = new BaseMessage("添加教师成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }


    @PutMapping("/{userId}")
    public JsonNode editTeacher(@PathVariable("userId") long userId, @RequestBody EditTeacherRequest payload, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = teacherService.editTeacher(userId, payload);
            if (result) {
                var message = new BaseMessage("修改教师信息成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @DeleteMapping("/{userId}")
    public JsonNode deleteTeacher(@PathVariable("userId") long userId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = teacherService.deleteTeacher(userId);
            if (result) {
                var message = new BaseMessage("删除教师成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }
}