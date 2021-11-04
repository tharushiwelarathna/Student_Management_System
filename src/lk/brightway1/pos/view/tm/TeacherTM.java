package lk.brightway1.pos.view.tm;

public class TeacherTM {
    private String teacherId;
    private String firstName;
    private String lastName;
    private String dob;
    private String joinDate;
    private String gender;
    private int contactNumber;
    private String courseCode;

    public TeacherTM() {
    }

    public TeacherTM(String teacherId, String firstName, String lastName, String dob, String joinDate, String gender, int contactNumber, String courseCode) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.joinDate = joinDate;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.courseCode = courseCode;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "TeacherTM{" +
                "teacherId='" + teacherId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNumber=" + contactNumber +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
