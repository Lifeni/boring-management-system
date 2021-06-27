package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.request.EditStudentRequest;
import app.lifeni.bms.entity.api.response.StudentInfoResponse;
import app.lifeni.bms.entity.model.Student;

import java.util.List;

public interface StudentService {
    List<StudentInfoResponse> queryAllStudents();

    boolean addStudent(Student student);

    boolean editStudent(long userId, EditStudentRequest payload);

    boolean deleteStudent(long userId);
}
