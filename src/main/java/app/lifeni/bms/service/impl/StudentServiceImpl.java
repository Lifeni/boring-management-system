package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.CollegeDao;
import app.lifeni.bms.dao.StudentDao;
import app.lifeni.bms.entity.api.response.StudentInfoResponse;
import app.lifeni.bms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
