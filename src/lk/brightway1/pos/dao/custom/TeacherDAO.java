package lk.brightway1.pos.dao.custom;

import lk.brightway1.pos.dao.CrudDAO;
import lk.brightway1.pos.entity.Teacher;

public interface TeacherDAO extends CrudDAO<Teacher,String> {
    String getLastTeacherId() throws Exception;
}
