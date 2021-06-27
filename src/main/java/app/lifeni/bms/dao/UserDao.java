package app.lifeni.bms.dao;

import app.lifeni.bms.entity.model.User;
import app.lifeni.bms.entity.model.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<UserLogin> queryAllUsers();

    User queryUser(@Param("userId") long userId);

    int addUser(@Param("userName") String userName, @Param("roleId") long roleId);

    int resetPasswordByAdmin(@Param("userId") long userId, @Param("password") String password);

    int removeUser(@Param("userId") long userId);

    int removeUserByName(@Param("userName") String userName);
}
