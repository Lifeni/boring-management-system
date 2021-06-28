package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.request.EditCourseRequest;
import app.lifeni.bms.entity.api.request.MarkCourseRequest;
import app.lifeni.bms.entity.api.response.CourseInfoResponse;
import app.lifeni.bms.entity.api.response.CourseStudentListResponse;
import app.lifeni.bms.entity.api.response.StudentCourseResponse;
import app.lifeni.bms.entity.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseInfoResponse> queryAllCourses();

    List<StudentCourseResponse> queryStudentCourse(long userId);

    List<CourseInfoResponse> queryTeacherCourse(long userId);

    String queryCourseById(long courseId);

    boolean addCourse(Course course);

    boolean markCourse(long courseId, long studentId, MarkCourseRequest payload);

    boolean selectCourse(long courseId, long userId);

    boolean unselectCourse(long courseId, long userId);

    boolean editCourse(long courseId, EditCourseRequest payload);

    int removeCourse(long courseId);

    List<CourseStudentListResponse> getCourseStudentList(long courseId);
}
