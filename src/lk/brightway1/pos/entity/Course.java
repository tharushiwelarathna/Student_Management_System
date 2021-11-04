package lk.brightway1.pos.entity;

public class Course implements SuperEntity {
    private String courseCode;
    private String courseName;
    private String courseType;
    private String deuration;
    private double courseFee;

    public Course() {
    }

    public Course(String courseCode, String courseName, String courseType, String deuration, double courseFee) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseType = courseType;
        this.deuration = deuration;
        this.courseFee = courseFee;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getDeuration() {
        return deuration;
    }

    public void setDeuration(String deuration) {
        this.deuration = deuration;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", deuration='" + deuration + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}

