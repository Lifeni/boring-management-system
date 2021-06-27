package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.response.StudentInfoResponse;

import java.sql.Date;
import java.util.List;

public interface StudentService {
    List<StudentInfoResponse> queryAllStudents();

    boolean addStudent(long userId, String userName, String sex, Date birthYear, Date grade, long collegeId);

    boolean editStudent(String userName, String sex, Date birthYear, Date grade, long collegeId);

    boolean deleteStudent(long userId);
}
