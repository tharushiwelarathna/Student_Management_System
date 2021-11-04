package lk.brightway1.pos.dto;

public class Login2DTO {
    private String userName;
    private String pw;

    public Login2DTO() {
    }

    public Login2DTO(String userName, String pw) {
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
        return "Login2DTO{" +
                "userName='" + userName + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
