package lk.brightway1.pos.dao.custom.impl;

import lk.brightway1.pos.dao.CrudUtil;
import lk.brightway1.pos.dao.custom.UserDAO;
import lk.brightway1.pos.entity.Student;
import lk.brightway1.pos.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public String getLastUserId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM User ORDER BY UserId DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }

    @Override
    public boolean save(User user) throws Exception {
        return CrudUtil.execute("Insert Into User values(?,?,?,?)", user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getRoll());

    }

    @Override
    public boolean update(User user) throws Exception {
        return CrudUtil.execute("Update  User set UserName=?,Password=?,Roll=? where UserID=?",
               user.getUserName(),
                user.getPassword(),
                user.getRoll(),
                user.getUserId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("Delete From User Where UserID=? ",id);
    }

    @Override
    public User get(String id) throws Exception {
        ResultSet rst= CrudUtil.execute("SELECT * FROM User WHERE UserID=?",id);

        if(rst.next()){
            return new User(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4));

        }return null;
    }

    @Override
    public List<User> getAll() throws Exception {
        ArrayList UserList = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * from User");
        while (rst.next()) {
            UserList .add(new User(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4)));

        }
        return UserList;
    }

    @Override
    public User Search(String id) throws Exception {
        return null;
    }

    @Override
    public User find(String key) throws Exception {
        return null;
    }
}
