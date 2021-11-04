package lk.brightway1.pos.view.tm;

public class RegistrationTM {
    private String regNo;
    private String regDate;
    private String studentId;
    private String courseCode;
    private double regFee;

    public RegistrationTM() {
    }

    public RegistrationTM(String regNo, String regDate, String studentId, String courseCode, double regFee) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.regFee = regFee;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    @Override
    public String toString() {
        return "RegistrationTM{" +
                "regNo='" + regNo + '\'' +
                ", regDate='" + regDate + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", regFee=" + regFee +
                '}';
    }
}
