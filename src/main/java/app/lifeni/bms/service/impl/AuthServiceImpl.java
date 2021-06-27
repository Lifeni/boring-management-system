package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.AuthDao;
import app.lifeni.bms.dao.RoleDao;
import app.lifeni.bms.entity.api.request.LoginRequest;
import app.lifeni.bms.entity.api.request.ResetPasswordRequest;
import app.lifeni.bms.entity.api.response.UserInfoResponse;
import app.lifeni.bms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDao authDao;

    @Autowired
    RoleDao roleDao;

    @Override
    public UserInfoResponse authLogin(LoginRequest payload) {
        var username = payload.getUsername();
        var password = payload.getPassword();

        var user = authDao.verifyUserByName(username, password);

        if (user != null) {
            var userId = user.getUserId();
            var roleId = user.getRole();
            var userName = user.getUserName();
            var roleName = roleDao.queryRoleById(roleId).getRoleName();

            return new UserInfoResponse(userId, roleId, userName, roleName);
        }
        return null;
    }

    @Override
    public UserInfoResponse authQueryUser(long userId) {
        var user = authDao.queryUserById(userId);

        if (user != null) {
            var roleId = user.getRole();
            var userName = user.getUserName();
            var roleName = roleDao.queryRoleById(roleId).getRoleName();

            return new UserInfoResponse(userId, roleId, userName, roleName);
        }
        return null;
    }

    @Override
    public boolean authResetPassword(ResetPasswordRequest payload) {
        var userId = payload.getUserId();
        var oldPassword = payload.getOldPassword();
        var newPassword = payload.getNewPassword();

        var user = authDao.resetUserPasswordById(userId, oldPassword, newPassword);

        return user > 0;
    }
}
