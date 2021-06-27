package app.lifeni.bms.dao;

import app.lifeni.bms.entity.api.request.EditStudentRequest;
import app.lifeni.bms.entity.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    List<Student> queryAllStudents();

    int addStudent(@Param("student") Student student);

    int editStudent(@Param("userId") long userId, @Param("student") EditStudentRequest student);

    int deleteStudent(long userId);

}
