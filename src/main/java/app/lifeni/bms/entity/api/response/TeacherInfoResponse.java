package app.lifeni.bms.entity.api.response;

import java.sql.Date;

public class TeacherInfoResponse {

    private long userId;
    private String userName;
    private String sex;
    private java.sql.Date birthYear;
    private String degree;
    private String title;
    private java.sql.Date grade;
    private long collegeId;
    private String collegeName;

    public TeacherInfoResponse(long userId, String userName, String sex, Date birthYear, String degree, String title, Date grade, long collegeId, String collegeName) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.birthYear = birthYear;
        this.degree = degree;
        this.title = title;
        this.grade = grade;
        this.collegeId = collegeId;
        this.collegeName = collegeName;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Date birthYear) {
        this.birthYear = birthYear;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getGrade() {
        return grade;
    }

    public void setGrade(Date grade) {
        this.grade = grade;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
