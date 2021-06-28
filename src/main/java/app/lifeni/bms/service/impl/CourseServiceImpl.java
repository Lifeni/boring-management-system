package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.*;
import app.lifeni.bms.entity.api.request.EditCourseRequest;
import app.lifeni.bms.entity.api.request.MarkCourseRequest;
import app.lifeni.bms.entity.api.response.CourseInfoResponse;
import app.lifeni.bms.entity.api.response.CourseStudentListResponse;
import app.lifeni.bms.entity.api.response.StudentCourseResponse;
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

    @Autowired
    SelectedCourseDao selectedCourseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    StudentDao studentDao;

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
    public List<StudentCourseResponse> queryStudentCourse(long userId) {
        var userName = Long.parseLong(userDao.queryUser(userId).getUserName());
        var preCourses = queryAllCourses();
        var selectedCourses = selectedCourseDao.querySelectedCourseByStudent(userName);

        return preCourses.stream().map(course -> {
            var isSelected = false;
            var isFinished = false;
            var mark = 0L;
            var selected = selectedCourses.stream()
                    .filter(c -> c.getCourseId() == course.getCourseId())
                    .findFirst();
            if (selected.isPresent()) {
                isSelected = true;
                var sc = selected.get();
                if (sc.getMark() != 0) {
                    isFinished = true;
                    mark = sc.getMark();
                }
            }

            return new StudentCourseResponse(course.getCourseId(), course.getCourseName(),
                    course.getTeacherId(), course.getTeacherName(), course.getCourseTime(),
                    course.getClassRoom(), course.getCourseWeek(), course.getCourseType(),
                    course.getCollegeId(), course.getCollegeName(), course.getScore(),
                    isSelected, isFinished, mark);
        }).toList();
    }

    @Override
    public List<CourseInfoResponse> queryTeacherCourse(long userId) {
        var userName = Long.parseLong(userDao.queryUser(userId).getUserName());
        var preCourses = queryAllCourses();

        return preCourses.stream().filter(course -> course.getTeacherId() == userName).map(course -> new CourseInfoResponse(course.getCourseId(), course.getCourseName(),
                course.getTeacherId(), course.getTeacherName(), course.getCourseTime(),
                course.getClassRoom(), course.getCourseWeek(), course.getCourseType(),
                course.getCollegeId(), course.getCollegeName(), course.getScore()
        )).toList();
    }

    @Override
    public String queryCourseById(long courseId) {
        return courseDao.queryCourseById(courseId).getCourseName();
    }

    @Override
    public List<CourseStudentListResponse> getCourseStudentList(long courseId) {
        var courses = selectedCourseDao.querySelectedCourseById(courseId);

        return courses.stream().map(course -> {
            var student = studentDao.queryStudent(course.getStudentId());
            var isMarked = course.getMark();
            return new CourseStudentListResponse(student.getUserId(),
                    student.getUserName(), course.getMark(), isMarked != 0);
        }).toList();
    }

    @Override
    public boolean addCourse(Course course) {
        var result = courseDao.addCourse(course);
        return result > 0;
    }

    @Override
    public boolean markCourse(long courseId, long studentId, MarkCourseRequest payload) {
        var mark = payload.getMark();
        var result = selectedCourseDao.markCourse(courseId, studentId, mark);
        return result > 0;
    }

    @Override
    public boolean selectCourse(long courseId, long userId) {
        var userName = Long.parseLong(userDao.queryUser(userId).getUserName());
        var result = selectedCourseDao.selectCourse(courseId, userName);
        return result > 0;
    }

    @Override
    public boolean unselectCourse(long courseId, long userId) {
        var userName = Long.parseLong(userDao.queryUser(userId).getUserName());
        var mark = selectedCourseDao.queryCourseMark(courseId, userId);
        if (mark != null) {
            return false;
        }

        var result = selectedCourseDao.unselectCourse(courseId, userName);
        return result > 0;
    }

    @Override
    public boolean editCourse(long courseId, EditCourseRequest payload) {
        var result = courseDao.editCourse(courseId, payload);
        return result > 0;
    }

    @Override
    public int removeCourse(long courseId) {
        var courses = selectedCourseDao.querySelectedCourseById(courseId);
        if (!courses.isEmpty()) {
            return -1;
        }
        return courseDao.removeCourse(courseId);
    }

}
