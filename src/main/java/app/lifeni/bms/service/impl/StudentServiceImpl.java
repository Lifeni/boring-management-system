package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.StudentDao;
import app.lifeni.bms.entity.model.Student;
import app.lifeni.bms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> queryAllStudents() {
        return studentDao.queryAllStudents();
    }
}
