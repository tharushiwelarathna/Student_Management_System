package lk.brightway1.pos.view.tm;

import lk.brightway1.pos.entity.RegDetails;

import java.time.LocalDate;
import java.util.ArrayList;

public class Register {
    private String courseCode;
    private LocalDate date;
     private String studentID;
     private ArrayList<RegDetails> regDetails = new ArrayList<>();

    public Register() {
    }

    public Register(String courseCode, LocalDate date, String studentID, ArrayList<RegDetails> regDetails) {
        this.courseCode = courseCode;
        this.date = date;
        this.studentID = studentID;
        this.regDetails = regDetails;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public ArrayList<RegDetails> getRegDetails() {
        return regDetails;
    }

    public void setRegDetails(ArrayList<RegDetails> regDetails) {
        this.regDetails = regDetails;
    }

    @Override
    public String toString() {
        return "Register{" +
                "courseCode='" + courseCode + '\'' +
                ", date=" + date +
                ", studentID='" + studentID + '\'' +
                ", regDetails=" + regDetails +
                '}';
    }
}
