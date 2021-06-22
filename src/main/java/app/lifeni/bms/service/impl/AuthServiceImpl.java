package app.lifeni.bms.service.impl;

import app.lifeni.bms.dao.AuthDao;
import app.lifeni.bms.entity.request.LoginRequest;
import app.lifeni.bms.entity.response.LoginResponse;
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

        var user = authDao.verifyUser(username, password);

        if (user != null) {
            var userId = user.getUserId();
            var role = user.getRole();
            return new LoginResponse(userId, role);
        }
        return null;
    }
}
