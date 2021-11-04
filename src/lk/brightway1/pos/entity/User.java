package lk.brightway1.pos.entity;

public class User implements SuperEntity{
    private String userId;
    private String userName;
    private String password;
    private String roll;

    public User() {
    }

    public User(String userId, String userName, String password, String roll) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roll='" + roll + '\'' +
                '}';
    }
}
