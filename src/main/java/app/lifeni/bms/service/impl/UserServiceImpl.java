package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.RoleDao;
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

    @Autowired
    RoleDao roleDao;

    @Override
    public List<UserInfoResponse> queryAllUsers() {
        var users = userDao.queryAllUsers();
        var roles = roleDao.queryAllRoles();

        if (users != null) {
            return users.stream().map(user -> {
                var roleName = roles.stream()
                        .filter(role -> role.getRoleId() == user.getRole())
                        .findFirst();

                if (roleName.isPresent()) {
                    var name = roleName.get().getRoleName();
                    return new UserInfoResponse(user.getUserId(), user.getRole(), user.getUserName(), name);
                }

                return null;
            }).toList();
        }
        return null;
    }

    @Override
    public boolean resetPasswordByAdmin(long userId, ResetPasswordByAdminRequest payload) {
        var password = payload.getPassword();
        var result = userDao.resetPasswordByAdmin(userId, password);
        return result > 0;
    }

    @Override
    public boolean removeUser(long userId) {
        var result = userDao.removeUser(userId);
        return result > 0;
    }
}
