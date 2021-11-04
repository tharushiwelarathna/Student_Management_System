package lk.brightway1.pos.dao.custom.impl;

import lk.brightway1.pos.dao.CrudUtil;
import lk.brightway1.pos.dao.custom.AttendanceDAO;
import lk.brightway1.pos.entity.Attendance;
import lk.brightway1.pos.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {
    @Override
    public boolean save(Attendance attendance) throws Exception {
        return CrudUtil.execute("Insert Into Attendance values(?,?,?,?,?)",attendance.getStudentID(),attendance.getDates(),
                attendance.getStartingTime(),attendance.getEndingTime(),attendance.getStudyingHours());
    }

    @Override
    public boolean update(Attendance attendance) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public Attendance get(String id) throws Exception {
        return null;
    }

    @Override
    public List<Attendance> getAll() throws Exception {
        ArrayList AttendanceList = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * from Attendance");
        while (rst.next()) {
            AttendanceList.add(new Attendance(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4) ,rst.getString(5)));

        }
        return AttendanceList;
    }

    @Override
    public Attendance Search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * from Attendance where StudentID=?", id);
        if(rst.next()){
            return new Attendance(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
        }
        return null;
    }

    @Override
    public Attendance find(String key) throws Exception {
        return null;
    }
}