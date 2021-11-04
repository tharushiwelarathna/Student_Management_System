package lk.brightway1.pos.dao.custom;

import lk.brightway1.pos.dao.SuperDAO;
import lk.brightway1.pos.entity.Attendance;
import lk.brightway1.pos.entity.Registration;
import lk.brightway1.pos.entity.StudentDetails;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public ArrayList<StudentDetails>getStudentDetails()throws Exception;
    public ArrayList<Registration>getRegisterDetails(String id)throws Exception;

    public ArrayList<Attendance> getEmployeeAttendance(String id) throws Exception;
//    String getFullRegisterCount()throws Exception;

    public int getFullRegisterCount() throws Exception;
    public int getFullMaleCount( ) throws Exception;


}
