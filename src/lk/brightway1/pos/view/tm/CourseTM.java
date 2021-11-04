package lk.brightway1.pos.view.tm;

public class CourseTM {
     private String courseCode;
     private String corseName;
     private String courseType;
     private String deuration;
     private double courseFee;

    public CourseTM() {
    }

    public CourseTM(String courseCode, String corseName, String courseType, String deuration, double courseFee) {
        this.courseCode = courseCode;
        this.corseName = corseName;
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

    public String getCorseName() {
        return corseName;
    }

    public void setCorseName(String corseName) {
        this.corseName = corseName;
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
        return "CourseTM{" +
                "courseCode='" + courseCode + '\'' +
                ", corseName='" + corseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", deuration='" + deuration + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}

