package app.lifeni.bms.dao;

import app.lifeni.bms.entity.model.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthDao {
    UserLogin verifyUserByName(@Param("username") String username, @Param("password") String password);

    UserLogin queryUserById(@Param("userId") long userId);

    int resetUserPasswordById(@Param("userId") long userId, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);
}
