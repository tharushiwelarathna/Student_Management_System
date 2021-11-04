package lk.brightway1.pos.entity;

public class Login implements SuperEntity {
    private String userName;
    private String pw;

    public Login() {
    }

    public Login(String userName, String pw) {
        this.userName = userName;
        this.pw = pw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userName='" + userName + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
