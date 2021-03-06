package app.lifeni.bms.dao;

import app.lifeni.bms.entity.model.College;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollegeDao {
    List<College> queryAllColleges();

    College queryCollegeById(@Param("collegeId") long collegeId);
}
