package lk.brightway1.pos.dao.custom.impl;

import lk.brightway1.pos.dao.CrudUtil;
import lk.brightway1.pos.dao.custom.TeacherDAO;
import lk.brightway1.pos.entity.Student;
import lk.brightway1.pos.entity.Teacher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {
    @Override
    public boolean save(Teacher teacher) throws Exception {
        return CrudUtil.execute
                ("INSERT INTO Teacher VALUES(?,?,?,?,?,?,?,?)",
                        teacher.getTeacherId(),teacher.getFirstName(),teacher.getLastName(),
                        teacher.getDob(),teacher.getJoinDate(),teacher.getGender(),teacher.getContactNumber(),teacher.getCourseCode());
    }

    @Override
    public boolean update(Teacher teacher) throws Exception {
        return   CrudUtil.execute("Update Teacher set courseCode=?,contactNumber=?,gender=?,joinDate=?,dob=? ,lastName=?,firstName=? where teacherID=?",
                teacher.getCourseCode(),
                teacher.getContactNumber(),
                teacher.getGender(),
                teacher.getJoinDate(),
                teacher.getDob(),
                teacher.getLastName(),
                teacher.getFirstName(),
                teacher.getTeacherId()
        );
    }


    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("Delete From Teacher Where TeacherID=? ",id);
    }

    @Override
    public Teacher get(String id) throws Exception {
        ResultSet rst= CrudUtil.execute("SELECT * FROM Teacher WHERE TeacherId=?",id);

        if(rst.next()){
            return new Teacher(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getString(5),rst.getString(6),rst.getInt(7),rst.getString(8));

        }return null;
    }

    @Override
    public List<Teacher> getAll() throws Exception {
        ArrayList TeacherList = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * from Teacher");
        while (rst.next()) {
            TeacherList.add(new Teacher(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4) , rst.getString(5), rst.getString(6),rst.getInt(7),rst.getString(8)));

        }
        return TeacherList;
    }

    @Override
    public Teacher Search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * from Teacher where TeacherID=?", id);
        if(rst.next()){
            return new Teacher(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getInt(7),rst.getString(8));
        }
        return null;
    }

    @Override
    public Teacher find(String key) throws Exception {
        return null;
    }


    @Override
    public String getLastTeacherId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Teacher ORDER BY TeacherId DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }
}
