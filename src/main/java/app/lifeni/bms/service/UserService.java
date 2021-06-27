package app.lifeni.bms.service;

import app.lifeni.bms.entity.api.request.ResetPasswordByAdminRequest;
import app.lifeni.bms.entity.api.response.UserInfoResponse;

import java.util.List;

public interface UserService {
    List<UserInfoResponse> queryAllUsers();

    boolean resetPasswordByAdmin(long userId, ResetPasswordByAdminRequest password);

    boolean removeUser(long userId);
}
