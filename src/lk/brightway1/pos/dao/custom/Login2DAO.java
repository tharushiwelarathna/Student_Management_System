package lk.brightway1.pos.dao.custom;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.brightway1.pos.dao.CrudDAO;
import lk.brightway1.pos.entity.Login;

public interface Login2DAO extends CrudDAO<Login,String> {
    public void loginUser(JFXTextField txt, JFXTextField pw , JFXButton btn, String location)throws Exception;
}
