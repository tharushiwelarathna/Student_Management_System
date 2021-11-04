package lk.brightway1.pos.bo.custom.impl;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.brightway1.pos.bo.custom.LoginBO;
import lk.brightway1.pos.dao.DAOFactory;
import lk.brightway1.pos.dao.custom.LoginDAO;

public class LoginBOImpl implements LoginBO {
    private LoginDAO loginDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOType.LOGIN);


    @Override
    public void loginUser(JFXTextField txt, JFXTextField pw, JFXButton btn,String location) throws Exception {
        loginDAO.loginUser(txt, pw,btn,location);
    }


}
