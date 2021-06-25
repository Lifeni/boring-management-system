package app.lifeni.bms.dao;

import app.lifeni.bms.entity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> queryAllUsers();

    int resetPasswordByAdmin(@Param("userId") long userId, @Param("password") String password);
}
