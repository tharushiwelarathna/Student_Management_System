package lk.brightway1.pos.entity;

public class Attendance implements SuperEntity{
    private String studentID;
     private String dates;
   private String startingTime;
     private String endingTime;
      private String studyingHours;

    public Attendance() {
    }

    public Attendance(String studentID, String dates, String startingTime, String endingTime, String studyingHours) {
        this.studentID = studentID;
        this.dates = dates;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.studyingHours = studyingHours;
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

    public String getStudyingHours() {
        return studyingHours;
    }

    public void setStudyingHours(String studyingHours) {
        this.studyingHours = studyingHours;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "studentID='" + studentID + '\'' +
                ", dates='" + dates + '\'' +
                ", startingTime='" + startingTime + '\'' +
                ", endingTime='" + endingTime + '\'' +
                ", studyingHours='" + studyingHours + '\'' +
                '}';
    }
}
