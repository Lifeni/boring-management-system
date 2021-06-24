package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.response.UserInfoResponse;

import java.util.List;

public interface UserService {
    List<UserInfoResponse> queryAllUsers();

}
