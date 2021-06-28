package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.CourseDao;
import app.lifeni.bms.entity.api.request.EditCourseRequest;
import app.lifeni.bms.entity.model.Course;
import app.lifeni.bms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> queryAllCourses() {
        return courseDao.queryAllCourses();
    }

    @Override
    public String queryCourseById(long courseId) {
        return courseDao.queryCourseById(courseId).getCourseName();
    }

    @Override
    public boolean addCourse(Course course) {
        var result = courseDao.addCourse(course);
        return result > 0;
    }


    @Override
    public boolean editCourse(long courseId, EditCourseRequest payload) {
        var result = courseDao.editCourse(courseId, payload);
        return result > 0;
    }

    @Override
    public boolean removeCourse(long courseId) {
        var result = courseDao.removeCourse(courseId);
        return result > 0;
    }
}
