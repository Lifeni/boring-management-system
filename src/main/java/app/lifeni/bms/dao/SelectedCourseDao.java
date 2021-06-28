package app.lifeni.bms.dao;

import app.lifeni.bms.entity.model.SelectedCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SelectedCourseDao {
    List<SelectedCourse> queryAllSelectedCourses();

    List<SelectedCourse> querySelectedCourseById(@Param("courseId") long courseId);

    List<SelectedCourse> querySelectedCourseByStudent(@Param("studentId") long studentId);
}
