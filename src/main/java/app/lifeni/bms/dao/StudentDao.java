package app.lifeni.bms.dao;

import app.lifeni.bms.entity.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    List<Student> queryAllStudents();

    int addStudent(@Param("userId") long userId, @Param("userName") String userName, @Param("sex") String sex, @Param("birthYear") Date birthYear, @Param("grade") Date grade, @Param("collegeId") long collegeId);

    int editStudent(@Param("userName") String userName, @Param("sex") String sex, @Param("birthYear") Date birthYear, @Param("grade") Date grade, @Param("collegeId") long collegeId);

    int deleteStudent(long userId);

}
