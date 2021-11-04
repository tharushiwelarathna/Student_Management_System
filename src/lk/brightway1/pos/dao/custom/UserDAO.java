package lk.brightway1.pos.dao.custom;

import lk.brightway1.pos.dao.CrudDAO;

import lk.brightway1.pos.entity.User;

public interface UserDAO extends CrudDAO<User,String> {
    String getLastUserId() throws Exception;
}
