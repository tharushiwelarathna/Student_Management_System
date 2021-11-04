package lk.brightway1.pos.dao.custom;

import lk.brightway1.pos.dao.CrudDAO;
import lk.brightway1.pos.entity.Registration;

public interface RegistrationDAO extends CrudDAO<Registration,String> {
    String getLastRegNo() throws Exception;
}
