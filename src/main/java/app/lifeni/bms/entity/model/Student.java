package app.lifeni.bms.entity.model;

import java.sql.Date;

public class Student {

    private long userId;
    private String userName;
    private String sex;
    private java.sql.Date birthYear;
    private java.sql.Date grade;

    public Student(long userId, String userName, String sex, Date birthYear, Date grade, long collegeId) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.birthYear = birthYear;
        this.grade = grade;
        this.collegeId = collegeId;
    }

    private long collegeId;

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

  public java.sql.Date getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(java.sql.Date birthYear) {
    this.birthYear = birthYear;
  }

  public java.sql.Date getGrade() {
    return grade;
  }

  public void setGrade(java.sql.Date grade) {
    this.grade = grade;
  }

  public long getCollegeId() {
    return collegeId;
  }

  public void setCollegeId(long collegeId) {
    this.collegeId = collegeId;
  }

}
