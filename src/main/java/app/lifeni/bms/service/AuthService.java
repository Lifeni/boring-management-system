package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.request.LoginRequest;
import app.lifeni.bms.entity.api.request.ResetPasswordRequest;
import app.lifeni.bms.entity.api.response.LoginResponse;

public interface AuthService {
    LoginResponse authLogin(LoginRequest payload);

    boolean authResetPassword(ResetPasswordRequest payload);
}


