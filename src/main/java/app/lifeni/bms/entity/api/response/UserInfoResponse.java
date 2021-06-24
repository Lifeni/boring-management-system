package app.lifeni.bms.entity.api.response;

public class UserInfoResponse {
    private long userId;
    private long role;
    private String userName;

    public UserInfoResponse(long userId, long role, String userName) {
        this.userId = userId;
        this.role = role;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
