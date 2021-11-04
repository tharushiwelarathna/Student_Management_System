package lk.brightway1.pos.dao.custom.impl;

import lk.brightway1.pos.dao.CrudUtil;
import lk.brightway1.pos.dao.custom.StudentDAO;
import lk.brightway1.pos.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public String getLastStudentId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Student ORDER BY StudentId DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }

    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute("Insert Into Student values(?,?,?,?,?,?,?)", student.getStudentId(),
                student.getFirstName(),student.getLastName(), student.getAddress(), student.getContact(),
                student.getDob(), student.getGender());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtil.execute("Update  Student set FirstName=?, lastName=?,Address=?,Contact=?,Dob=?,Gender=? where StudentID=?",
                student.getFirstName(),
                student.getLastName(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender(),
                student.getStudentId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("Delete From Student Where StudentID=? ",id);
    }

    @Override
    public Student get(String id) throws Exception {
        ResultSet rst= CrudUtil.execute("SELECT * FROM Student WHERE StudentID=?",id);

        if(rst.next()){
            return new Student(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getInt(5),rst.getString(6),rst.getString(7));

        }return null;
    }

    @Override
    public List<Student> getAll() throws Exception {
        ArrayList StudentList = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * from Student");
        while (rst.next()) {
            StudentList.add(new Student(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4) ,rst.getInt(5), rst.getString(6), rst.getString(7)));

        }
        return StudentList;
    }

    @Override
    public Student Search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * from Student where StudentID=?", id);
        if(rst.next()){
            return new Student(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getString(6),rst.getString(7));
        }
        return null;
    }

    @Override
    public Student find(String key) throws Exception {
        return null;
    }
}
