package app.lifeni.bms.dao;

import app.lifeni.bms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthDao {
    User verifyUser(@Param("username") String username, @Param("password") String password);
}
