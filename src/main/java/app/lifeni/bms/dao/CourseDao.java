package app.lifeni.bms.dao;

import app.lifeni.bms.entity.api.request.EditCourseRequest;
import app.lifeni.bms.entity.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseDao {
    List<Course> queryAllCourses();

    Course queryCourseById(@Param("courseId") long courseId);

    int addCourse(@Param("course") Course course);

    int editCourse(@Param("courseId") long courseId, @Param("course") EditCourseRequest course);

    int removeCourse(long courseId);
}
