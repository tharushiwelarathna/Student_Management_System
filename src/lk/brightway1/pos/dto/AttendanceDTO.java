package lk.brightway1.pos.dto;

public class AttendanceDTO {
    private String studentID;
     private String dates;
    private String startingTime;
    private String endingTime;
    private String studingHours;

    public AttendanceDTO() {
    }

    public AttendanceDTO(String studentID, String dates, String startingTime, String endingTime, String studingHours) {
        this.studentID = studentID;
        this.dates = dates;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.studingHours = studingHours;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public String getStudingHours() {
        return studingHours;
    }

    public void setStudingHours(String studingHours) {
        this.studingHours = studingHours;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "studentID='" + studentID + '\'' +
                ", dates='" + dates + '\'' +
                ", startingTime='" + startingTime + '\'' +
                ", endingTime='" + endingTime + '\'' +
                ", studingHours='" + studingHours + '\'' +
                '}';
    }
}
