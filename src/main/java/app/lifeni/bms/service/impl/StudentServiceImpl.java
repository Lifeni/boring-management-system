package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.CollegeDao;
import app.lifeni.bms.dao.StudentDao;
import app.lifeni.bms.entity.api.response.StudentInfoResponse;
import app.lifeni.bms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

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

            if (collegeName.isPresent()) {
                var name = collegeName.get().getCollegeName();
                return new StudentInfoResponse(student.getUserId(),
                        student.getUserName(), student.getSex(),
                        student.getBirthYear(), student.getGrade(),
                        student.getCollegeId(), name);
            }
            return null;
        }).toList();
    }

    @Override
    public boolean addStudent(long userId, String userName, String sex, Date birthYear, Date grade, long collegeId) {
        var result = studentDao.addStudent(userId, userName, sex, birthYear, grade, collegeId);
        return result > 0;
    }

    @Override
    public boolean editStudent(String userName, String sex, Date birthYear, Date grade, long collegeId) {
        var result = studentDao.editStudent(userName, sex, birthYear, grade, collegeId);
        return result > 0;
    }

    @Override
    public boolean deleteStudent(long userId) {
        var result = studentDao.deleteStudent(userId);
        return result > 0;
    }


}
