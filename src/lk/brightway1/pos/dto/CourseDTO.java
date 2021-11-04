package lk.brightway1.pos.dto;

public class CourseDTO {
    private String code;
    private String courseName;
    private String courseType;
    private String deuration;
    private double courseFee;

    public CourseDTO() {
    }

    public CourseDTO(String code, String courseName, String courseType, String deuration, double courseFee) {
        this.code = code;
        this.courseName = courseName;
        this.courseType = courseType;
        this.deuration = deuration;
        this.courseFee = courseFee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return "CourseDTO{" +
                "code='" + code + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", deuration='" + deuration + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}
