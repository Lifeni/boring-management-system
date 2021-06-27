package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.request.EditTeacherRequest;
import app.lifeni.bms.entity.api.response.TeacherInfoResponse;
import app.lifeni.bms.entity.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<TeacherInfoResponse> queryAllTeachers();

    boolean addTeacher(Teacher teacher);

    boolean editTeacher(long userId, EditTeacherRequest payload);

    boolean removeTeacher(long userId);
}
