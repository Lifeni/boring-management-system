package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.CollegeDao;
import app.lifeni.bms.dao.CourseDao;
import app.lifeni.bms.dao.TeacherDao;
import app.lifeni.bms.entity.api.request.EditCourseRequest;
import app.lifeni.bms.entity.api.response.CourseInfoResponse;
import app.lifeni.bms.entity.model.Course;
import app.lifeni.bms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    CollegeDao collegeDao;

    @Override
    public List<CourseInfoResponse> queryAllCourses() {
        var colleges = collegeDao.queryAllColleges();
        var courses = courseDao.queryAllCourses();
        var teachers = teacherDao.queryAllTeachers();

        return courses.stream().map(course -> {
            var college = colleges.stream()
                    .filter(c -> c.getCollegeId() == course.getCollegeId())
                    .findFirst();

            var teacher = teachers.stream()
                    .filter(t -> t.getUserId() == course.getTeacherId())
                    .findFirst();

            var collegeName = "";
            var teacherName = "";

            if (college.isPresent()) {
                collegeName = college.get().getCollegeName();
            }

            if (teacher.isPresent()) {
                teacherName = teacher.get().getUserName();
            }

            return new CourseInfoResponse(course.getCourseId(), course.getCourseName(),
                    course.getTeacherId(), teacherName, course.getCourseTime(),
                    course.getClassRoom(), course.getCourseWeek(), course.getCourseType(),
                    course.getCollegeId(), collegeName, course.getScore());
        }).toList();
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
        // TODO: 不能删除已选课的课程
        var result = courseDao.removeCourse(courseId);
        return result > 0;
    }
}
