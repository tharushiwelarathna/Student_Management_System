package lk.brightway1.pos.dao;

import lk.brightway1.pos.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DAOFactory(): daoFactory;
    }

    public enum DAOType {
        COURSE,STUDENT,TEACHER,REGISTRATION,QUERY,STUDENT_DETAILS,ATTENDANCE,REG_DETAILS,USER,LOGIN,LOGIN2
    }

    public <T extends SuperDAO> T getDAO(DAOType daoType){
        switch (daoType){
            case COURSE:
                return (T) new CourseDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case REGISTRATION:
                return (T) new RegistrationDAOImpl();
            case TEACHER:
                return (T) new TeacherDAOImpl();
            case ATTENDANCE:
                return (T) new AttendanceDAOImpl();
            case STUDENT_DETAILS:
                return (T) new StudentDetailsDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case REG_DETAILS:
                return (T) new  RegDetailsDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            case LOGIN:
                return (T) new LoginDAOImpl();
            case LOGIN2:
                return (T)new Login2DAOImpl();
            default:
                return null;
        }
    }
}
