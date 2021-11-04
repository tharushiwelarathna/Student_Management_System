package lk.brightway1.pos.view.tm;

public class UserTM {
     private String userId;
    private String userName;

    private String roll;

    public UserTM() {
    }

    public UserTM(String userId, String userName, String roll) {
        this.userId = userId;
        this.userName = userName;
        this.roll = roll;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "UserTM{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", roll='" + roll + '\'' +
                '}';
    }
}
