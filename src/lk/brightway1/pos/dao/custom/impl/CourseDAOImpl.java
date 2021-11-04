package lk.brightway1.pos.dao.custom.impl;

import lk.brightway1.pos.dao.CrudUtil;
import lk.brightway1.pos.dao.custom.CourseDAO;
import lk.brightway1.pos.entity.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    public String getLastCourseCode() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Course ORDER BY CourseCode DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }





    @Override
    public boolean save(Course course) throws Exception {
        return CrudUtil.execute("INSERT INTO Course VALUES (?,?,?,?,?)", course.getCourseCode(),course.getCourseName(),course.getCourseType(),course.getDeuration(),course.getCourseFee());
    }

    @Override
    public boolean update(Course entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM Course WHERE CourseCode=?", key);
    }

    @Override
    public Course get(String s) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Course WHERE CourseCode=?",s);
        if(set.next()){
            return new Course(set.getString(1),set.getString(2),set.getString(3),
                    set.getString(4),set.getDouble(5));
        }
        return null;
    }

    @Override
    public List<Course> getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Course");
        List<Course> courses = new ArrayList<>();
        while (rst.next()) {
            courses.add(new Course(rst.getString(1),
                    rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getDouble(5))
            );
        }
        return courses;
    }

    @Override
    public Course Search(String id) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM course WHERE courseCode = ?", id);
        while(set.next()){
            return new Course(
                    set.getString(1),
            set.getString(2),
            set.getString(3),
            set.getString(4),
            set.getDouble(5));
        }
        return null;

    }

    @Override
    public Course find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM COURSE WHERE code=?", key);
        if (rst.next()) {
            return new Course(rst.getString(1),
                    rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getDouble(5));
        }
        return null;
    }
}
