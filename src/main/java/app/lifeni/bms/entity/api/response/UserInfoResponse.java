package app.lifeni.bms.entity.api.response;

public class UserInfoResponse {
    private long userId;
    private long roleId;
    private String userName;
    private String roleName;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserInfoResponse(long userId, long roleId, String userName, String roleName) {
        this.userId = userId;
        this.roleId = roleId;
        this.userName = userName;
        this.roleName = roleName;
    }
}
