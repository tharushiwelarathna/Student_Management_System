package lk.brightway1.pos.dao.custom.impl;

import lk.brightway1.pos.dao.CrudUtil;
import lk.brightway1.pos.dao.custom.QueryDAO;
import lk.brightway1.pos.entity.Attendance;
import lk.brightway1.pos.entity.Registration;
import lk.brightway1.pos.entity.StudentDetails;

import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {


    @Override
    public ArrayList<StudentDetails> getStudentDetails() throws Exception {
        ArrayList<StudentDetails> arratlist = new ArrayList<>();
        ResultSet resultSet= CrudUtil.execute("SELECT student.StudentID,student.FirstName,student.LastName,registration.CourseCode from registration inner join student on student.StudentID=registration.StudentID");
        while (resultSet.next()){
            arratlist.add(new StudentDetails(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        }
        return arratlist;
    }

    @Override
    public ArrayList<Registration> getRegisterDetails(String id) throws Exception {
        ArrayList<Registration> arrayList = new ArrayList<>();
        ResultSet resultSet=CrudUtil.execute("SELECT * FROM registration WHERE StudentID=?",id);
        while (resultSet.next()){
            arrayList.add(new Registration(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),Double.parseDouble(resultSet.getString(5))));
        }
        return arrayList;
    }

    @Override
    public ArrayList<Attendance> getEmployeeAttendance(String id) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM attendance WHERE StudentID = ? ", id);
        ArrayList<Attendance> atList = new ArrayList<>();

        while(set.next()){
            atList.add(new Attendance(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5)
            ));
        }
        return atList;
    }

    @Override
    public int getFullRegisterCount() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT COUNT(*) FROM Registration");

        int count =0;
        while(set.next()){
            return count = set.getInt(1);
        }
        return count;
    }

    @Override
    public int getFullMaleCount() throws Exception {
        return 0;
    }



  /*  @Override
    public String getFullRegisterCount() throws Exception {
        ResultSet rst=CrudUtil.execute("SELECT * FROM Registration");
        int i =0;
        while (rst.next()){
            i++;

        }
        return i+"";
    }
*/


}
