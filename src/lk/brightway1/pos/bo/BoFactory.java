package lk.brightway1.pos.bo;

import lk.brightway1.pos.bo.custom.impl.*;
import lk.brightway1.pos.dao.custom.impl.RegDetailsDAOImpl;

public class BoFactory {
    private  static  BoFactory boFactory;

    private  BoFactory(){
    }
    public static BoFactory getInstance() {
        return (boFactory == null) ?
                (boFactory = new BoFactory()) : (boFactory);
    }

    public enum BOType {
        STUDENT,TEACHER,COURSE,REGISTRATION,ATTENDANCE,STUDENT_DETAILS,REG_DETAILS,USER,LOGIN,LOGIN2
    }
    public  <T>T getBO(BOType type){
        switch (type){
            case STUDENT:
                return (T)new StudentBOImpl();
            case TEACHER:
                return (T)new TeacherBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBOImpl();
            case ATTENDANCE:
                return (T) new AttendanceBOImpl();
            case STUDENT_DETAILS:
                return (T) new StudentDetailsBOImpl();
            case REG_DETAILS:
                return (T) new RegDetailsBOImpl();
            case USER:
                return (T) new UserBOImpl();
            case LOGIN:
                return (T) new LoginBOImpl();
            case LOGIN2:
                return (T) new Login2BOImpl();

            default:return null;

        }
    }
}
