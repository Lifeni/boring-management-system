package app.lifeni.bms.controller;

import app.lifeni.bms.entity.api.request.EditCourseRequest;
import app.lifeni.bms.entity.api.request.MarkCourseRequest;
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

    @GetMapping("/students/{userId}")
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

    @GetMapping("/teachers/{userId}")
    public JsonNode getTeacherCourse(@PathVariable("userId") long userId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        var id = CookiesUtils.verifyReturnId(request);
        if (role == 1 && id == userId) {
            var courses = courseService.queryTeacherCourse(userId);
            var message = new DataMessage("获取教师所教的课程", courses);
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
                var message = new BaseMessage("添加课程成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @GetMapping("/{courseId}/students")
    public JsonNode getCourseStudentList(@PathVariable("courseId") long courseId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 1) {
            var students = courseService.getCourseStudentList(courseId);
            var message = new DataMessage("获取课程选课学生列表", students);
            response.setStatus(200);
            return JSON.t(message);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @PutMapping("/{courseId}")
    public JsonNode editCourse(@PathVariable("courseId") long courseId, @RequestBody EditCourseRequest payload, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = courseService.editCourse(courseId, payload);
            if (result) {
                var message = new BaseMessage("修改课程信息成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @PatchMapping("/{courseId}/students/{studentId}/mark")
    public JsonNode markCourse(@PathVariable("courseId") long courseId, @PathVariable("studentId") long studentId, @RequestBody MarkCourseRequest payload, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 1) {
            var result = courseService.markCourse(courseId, studentId, payload);
            if (result) {
                var message = new BaseMessage("打分成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @PutMapping("/{courseId}/students/{userId}")
    public JsonNode selectCourse(@PathVariable("courseId") long courseId, @PathVariable("userId") long userId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        var id = CookiesUtils.verifyReturnId(request);
        if (role == 2 && id == userId) {
            var result = courseService.selectCourse(courseId, userId);
            if (result) {
                var message = new BaseMessage("选课成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @DeleteMapping("/{courseId}")
    public JsonNode removeCourse(@PathVariable("courseId") long courseId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        if (role == 0) {
            var result = courseService.removeCourse(courseId);
            if (result > 0) {
                var message = new BaseMessage("删除课程成功");
                response.setStatus(200);
                return JSON.t(message);
            } else if (result == -1) {
                var message = new BaseMessage("课程已有学生选课，不允许删除");
                response.setStatus(250);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }

    @DeleteMapping("/{courseId}/students/{userId}")
    public JsonNode unselectCourse(@PathVariable("courseId") long courseId, @PathVariable("userId") long userId, HttpServletRequest request, HttpServletResponse response) {
        var role = CookiesUtils.verifyReturnRole(request);
        var id = CookiesUtils.verifyReturnId(request);
        if (role == 2 && id == userId) {
            var result = courseService.unselectCourse(courseId, userId);
            if (result) {
                var message = new BaseMessage("取消选课成功");
                response.setStatus(200);
                return JSON.t(message);
            }
            return ErrorUtils.dbErrorHandler(response);
        }
        return ErrorUtils.authErrorHandler(response, role);
    }
}
