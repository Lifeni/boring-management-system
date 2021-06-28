package app.lifeni.bms.entity.api.response;

public class StudentCourseResponse {
    private long courseId;
    private String courseName;
    private long teacherId;
    private String teacherName;
    private String courseTime;
    private String classRoom;
    private long courseWeek;
    private String courseType;
    private long collegeId;
    private String collegeName;
    private long score;
    private boolean isSelected;
    private boolean isFinished;
    private long mark;

    public StudentCourseResponse(long courseId, String courseName, long teacherId,
                                 String teacherName, String courseTime, String classRoom,
                                 long courseWeek, String courseType, long collegeId,
                                 String collegeName, long score, boolean isSelected,
                                 boolean isFinished, long mark) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.courseTime = courseTime;
        this.classRoom = classRoom;
        this.courseWeek = courseWeek;
        this.courseType = courseType;
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.score = score;
        this.isSelected = isSelected;
        this.isFinished = isFinished;
        this.mark = mark;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public long getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(long courseWeek) {
        this.courseWeek = courseWeek;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
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

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public long getMark() {
        return mark;
    }

    public void setMark(long mark) {
        this.mark = mark;
    }
}
