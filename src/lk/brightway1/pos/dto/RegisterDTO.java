package lk.brightway1.pos.dto;

public class RegisterDTO {
    private String regNO;
    private String regDate;
    private String studentID;
    private String studentFirstName;
    private double fullPayment;

    public RegisterDTO() {
    }

    public RegisterDTO(String regNO, String regDate, String studentID, String studentFirstName, double fullPayment) {
        this.regNO = regNO;
        this.regDate = regDate;
        this.studentID = studentID;
        this.studentFirstName = studentFirstName;
        this.fullPayment = fullPayment;
    }

    public String getRegNO() {
        return regNO;
    }

    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public double getFullPayment() {
        return fullPayment;
    }

    public void setFullPayment(double fullPayment) {
        this.fullPayment = fullPayment;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "regNO='" + regNO + '\'' +
                ", regDate='" + regDate + '\'' +
                ", studentID='" + studentID + '\'' +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", fullPayment=" + fullPayment +
                '}';
    }
}
