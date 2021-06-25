package app.lifeni.bms.dao;

import app.lifeni.bms.entity.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    List<Student> queryAllStudents();
}
