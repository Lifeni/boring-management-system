package app.lifeni.bms.entity.api.response;

public class CourseStudentListResponse {
    private long userId;
    private String userName;
    private long mark;
    private boolean isMarked;

    public CourseStudentListResponse(long userId, String userName, long mark, boolean isMarked) {
        this.userId = userId;
        this.userName = userName;
        this.mark = mark;
        this.isMarked = isMarked;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }
}
