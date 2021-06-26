package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.response.StudentInfoResponse;

import java.util.List;

public interface StudentService {
    List<StudentInfoResponse> queryAllStudents();
}
