package app.lifeni.bms.service;

import app.lifeni.bms.entity.request.LoginRequest;
import app.lifeni.bms.entity.response.LoginResponse;

public interface AuthService {
    LoginResponse authLogin(LoginRequest payload);
}


