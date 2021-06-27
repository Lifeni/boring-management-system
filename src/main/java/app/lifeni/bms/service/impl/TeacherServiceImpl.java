package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.CollegeDao;
import app.lifeni.bms.dao.TeacherDao;
import app.lifeni.bms.dao.UserDao;
import app.lifeni.bms.entity.api.request.EditTeacherRequest;
import app.lifeni.bms.entity.api.response.TeacherInfoResponse;
import app.lifeni.bms.entity.model.Teacher;
import app.lifeni.bms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Autowired
    UserDao userDao;

    @Autowired
    CollegeDao collegeDao;

    @Override
    public List<TeacherInfoResponse> queryAllTeachers() {
        var colleges = collegeDao.queryAllColleges();
        var teachers = teacherDao.queryAllTeachers();

        return teachers.stream().map(teacher -> {
            var collegeName = colleges.stream()
                    .filter(college -> college.getCollegeId() == teacher.getCollegeId())
                    .findFirst();

            var name = "";
            if (collegeName.isPresent()) {
                name = collegeName.get().getCollegeName();
            }

            return new TeacherInfoResponse(teacher.getUserId(),
                    teacher.getUserName(), teacher.getSex(), teacher.getBirthYear(),
                    teacher.getDegree(), teacher.getTitle(), teacher.getGrade(),
                    teacher.getCollegeId(), name);
        }).toList();
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        var teacherResult = teacherDao.addTeacher(teacher);
        var userResult = userDao.addUser(Long.toString(teacher.getUserId()), 1);
        return teacherResult > 0 && userResult > 0;
    }


    @Override
    public boolean editTeacher(long userId, EditTeacherRequest payload) {
        var result = teacherDao.editTeacher(userId, payload);
        return result > 0;
    }

    @Override
    public boolean removeTeacher(long userId) {
        var result = teacherDao.removeTeacher(userId);
        return result > 0;
    }


}
