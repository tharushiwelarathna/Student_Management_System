package lk.brightway1.pos.dao.custom;

import lk.brightway1.pos.dao.CrudDAO;
import lk.brightway1.pos.entity.Student;

public interface StudentDAO extends CrudDAO<Student,String> {
    String getLastStudentId() throws Exception;
}
