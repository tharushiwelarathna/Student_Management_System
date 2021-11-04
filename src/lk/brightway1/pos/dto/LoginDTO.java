package lk.brightway1.pos.dto;

public class LoginDTO {
    private String userName;
    private String pw;

    public LoginDTO() {
    }

    public LoginDTO(String userName, String pw) {
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
        return "LoginDTO{" +
                "userName='" + userName + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
