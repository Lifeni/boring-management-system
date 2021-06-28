package app.lifeni.bms.dao;

import app.lifeni.bms.entity.api.request.EditTeacherRequest;
import app.lifeni.bms.entity.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherDao {
    List<Teacher> queryAllTeachers();

    Teacher queryTeacherById(long userId);

    int addTeacher(@Param("teacher") Teacher teacher);

    int editTeacher(@Param("userId") long userId, @Param("teacher") EditTeacherRequest teacher);

    int removeTeacher(long userId);

}
