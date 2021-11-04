package lk.brightway1.pos.dto;

public class RegistrationDTO {
    private String regNO;
    private String RegDate;
    private String studentID;
    private String courseCode;
    private double regFee;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String regNO, String regDate, String studentID, String courseCode, double regFee) {
        this.regNO = regNO;
        RegDate = regDate;
        this.studentID = studentID;
        this.courseCode = courseCode;
        this.regFee = regFee;
    }

    public String getRegNO() {
        return regNO;
    }

    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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
        return "RegistrationDTO{" +
                "regNO='" + regNO + '\'' +
                ", RegDate='" + RegDate + '\'' +
                ", studentID='" + studentID + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", regFee=" + regFee +
                '}';
    }
}
