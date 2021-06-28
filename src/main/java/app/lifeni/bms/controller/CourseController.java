package app.lifeni.bms.controller;

import app.lifeni.bms.entity.api.request.EditCourseRequest;
import app.lifeni.bms.entity.message.BaseMessage;
import app.lifeni.bms.entity.message.DataMessage;
import app.lifeni.bms.entity.model.Course;
import app.lifeni.bms.service.CourseService;
import app.lifeni.bms.utils.CookiesUtils;
import app.lifeni.bms.utils.ErrorUtils;
import app.lifeni.bms.utils.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public JsonNode getAll(HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0 || role == 1 || role == 2) {
            var courses = courseService.queryAllCourses();
            var message = new DataMessage("获取全部课程列表", courses);
            response.setStatus(200);
            return JSON.t(message);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @GetMapping("/student/{userId}")
    public JsonNode getStudentCourse(@PathVariable("userId") long userId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        var id = CookiesUtils.verifyReturnId(request);
        if (role == 2 && id == userId) {
            var courses = courseService.queryStudentCourse(userId);
            var message = new DataMessage("获取学生课程及成绩列表", courses);
            response.setStatus(200);
            return JSON.t(message);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @PostMapping("/")
    public JsonNode addCourse(@RequestBody Course payload, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = courseService.addCourse(payload);
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
    public JsonNode editCourse(@PathVariable("userId") long userId, @RequestBody EditCourseRequest payload, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = courseService.editCourse(userId, payload);
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
    public JsonNode removeCourse(@PathVariable("userId") long userId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = courseService.removeCourse(userId);
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
