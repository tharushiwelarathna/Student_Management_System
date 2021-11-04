package lk.brightway1.pos.view.tm;

public class AttendanceTM {

     private String dates;
    private String startingTime;
     private String endingTime;
    private String studingHours;

    public AttendanceTM() {
    }

    public AttendanceTM(String dates, String startingTime, String endingTime, String studingHours) {
        this.dates = dates;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.studingHours = studingHours;
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
        return "AttendanceTM{" +
                "dates='" + dates + '\'' +
                ", startingTime='" + startingTime + '\'' +
                ", endingTime='" + endingTime + '\'' +
                ", studingHours='" + studingHours + '\'' +
                '}';
    }
}
