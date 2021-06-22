package app.lifeni.bms.entity.api.response;

public class LoginResponse {
    private long userId;
    private long role;

    public LoginResponse(long userId, long role) {
        this.userId = userId;
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }
}
