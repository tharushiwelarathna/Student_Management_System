package lk.brightway1.pos.dto;

import javafx.scene.control.Button;

public class RegDetailsDTO {
    private String courseCode;
    private String deuration;
    private double courseFee;
    private double regFee;
    private double total;

    public RegDetailsDTO() {
    }

    public RegDetailsDTO(String courseCode, String deuration, double courseFee, double regFee, double total) {
        this.courseCode = courseCode;
        this.deuration = deuration;
        this.courseFee = courseFee;
        this.regFee = regFee;
        this.total = total;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
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

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RegDetailsDTO{" +
                "courseCode='" + courseCode + '\'' +
                ", deuration='" + deuration + '\'' +
                ", courseFee=" + courseFee +
                ", regFee=" + regFee +
                ", total=" + total +
                '}';
    }
}
