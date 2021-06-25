package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.UserDao;
import app.lifeni.bms.entity.api.request.ResetPasswordByAdminRequest;
import app.lifeni.bms.entity.api.response.UserInfoResponse;
import app.lifeni.bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserInfoResponse> queryAllUsers() {
        var users = userDao.queryAllUsers();

        if (users != null) {
            return users.stream().map(user -> {
                var userId = user.getUserId();
                var role = user.getRole();
                var userName = user.getUserName();
                return new UserInfoResponse(userId, role, userName);
            }).toList();
        }
        return null;
    }

    @Override
    public boolean resetPasswordByAdmin(long userId, ResetPasswordByAdminRequest payload) {
        var password = payload.getPassword();
        var user = userDao.resetPasswordByAdmin(userId, password);
        return user > 0;
    }
}
