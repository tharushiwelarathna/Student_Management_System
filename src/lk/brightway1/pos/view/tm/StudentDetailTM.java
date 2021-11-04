package lk.brightway1.pos.view.tm;

public class StudentDetailTM {
    private String StudentID;
    private String FirstName;
    private String LastName;
    private String CourseCode;

    public StudentDetailTM() {
    }

    public StudentDetailTM(String studentID, String firstName, String lastName, String courseCode) {
        StudentID = studentID;
        FirstName = firstName;
        LastName = lastName;
        CourseCode = courseCode;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    @Override
    public String toString() {
        return "StudentDetailTM{" +
                "StudentID='" + StudentID + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", CourseCode='" + CourseCode + '\'' +
                '}';
    }
}
