package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.request.EditCourseRequest;
import app.lifeni.bms.entity.api.response.CourseInfoResponse;
import app.lifeni.bms.entity.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseInfoResponse> queryAllCourses();

    String queryCourseById(long courseId);

    boolean addCourse(Course course);

    boolean editCourse(long userId, EditCourseRequest payload);

    boolean removeCourse(long userId);
}
