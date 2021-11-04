package lk.brightway1.pos.bo.custom.impl;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.brightway1.pos.bo.custom.Login2BO;
import lk.brightway1.pos.bo.custom.LoginBO;
import lk.brightway1.pos.dao.DAOFactory;
import lk.brightway1.pos.dao.custom.Login2DAO;
import lk.brightway1.pos.dao.custom.LoginDAO;

public class Login2BOImpl implements Login2BO {
    private Login2DAO login2DAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOType.LOGIN2);
    @Override
    public void loginUser(JFXTextField txt, JFXTextField pw, JFXButton btn, String location) throws Exception {
        login2DAO.loginUser(txt, pw,btn,location);
    }
}
