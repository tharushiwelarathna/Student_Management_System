package lk.brightway1.pos.dao.custom;

import lk.brightway1.pos.dao.CrudDAO;
import lk.brightway1.pos.entity.Course;

public interface CourseDAO extends CrudDAO<Course,String> {
    String getLastCourseCode() throws Exception;
}
