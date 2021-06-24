package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.request.LoginRequest;
import app.lifeni.bms.entity.api.request.ResetPasswordRequest;
import app.lifeni.bms.entity.api.response.UserInfoResponse;

public interface AuthService {
    UserInfoResponse authLogin(LoginRequest payload);

    UserInfoResponse authQueryUser(long userId);

    boolean authResetPassword(ResetPasswordRequest payload);

}


