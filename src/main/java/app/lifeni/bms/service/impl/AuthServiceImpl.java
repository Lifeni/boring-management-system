package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.AuthDao;
import app.lifeni.bms.entity.api.request.LoginRequest;
import app.lifeni.bms.entity.api.request.ResetPasswordRequest;
import app.lifeni.bms.entity.api.response.LoginResponse;
import app.lifeni.bms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDao authDao;

    @Override
    public LoginResponse authLogin(LoginRequest payload) {
        var username = payload.getUsername();
        var password = payload.getPassword();

        var user = authDao.verifyUserByName(username, password);

        if (user != null) {
            var userId = user.getUserId();
            var role = user.getRole();
            var userName = user.getUserName();
            return new LoginResponse(userId, role, userName);
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
