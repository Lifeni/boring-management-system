package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.CollegeDao;
import app.lifeni.bms.dao.StudentDao;
import app.lifeni.bms.dao.UserDao;
import app.lifeni.bms.entity.api.request.EditStudentRequest;
import app.lifeni.bms.entity.api.response.StudentInfoResponse;
import app.lifeni.bms.entity.model.Student;
import app.lifeni.bms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Autowired
    UserDao userDao;

    @Autowired
    CollegeDao collegeDao;

    @Override
    public List<StudentInfoResponse> queryAllStudents() {
        var colleges = collegeDao.queryAllColleges();
        var students = studentDao.queryAllStudents();

        return students.stream().map(student -> {
            var collegeName = colleges.stream()
                    .filter(college -> college.getCollegeId() == student.getCollegeId())
                    .findFirst();

            var name = "";
            if (collegeName.isPresent()) {
                name = collegeName.get().getCollegeName();
            }

            return new StudentInfoResponse(student.getUserId(),
                    student.getUserName(), student.getSex(),
                    student.getBirthYear(), student.getGrade(),
                    student.getCollegeId(), name);
        }).toList();
    }

    @Override
    public boolean addStudent(Student student) {
        var studentResult = studentDao.addStudent(student);
        var userResult = userDao.addUser(Long.toString(student.getUserId()), 2);
        return studentResult > 0 && userResult > 0;
    }

    @Override
    public boolean editStudent(long userId, EditStudentRequest payload) {
        var result = studentDao.editStudent(userId, payload);
        return result > 0;
    }

    @Override
    public boolean removeStudent(long userId) {
        var result = studentDao.removeStudent(userId);
        return result > 0;
    }


}
