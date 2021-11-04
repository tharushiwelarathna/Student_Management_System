package lk.brightway1.pos.bo.custom;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

public interface LoginBO {
    public void loginUser(JFXTextField txt, JFXTextField pw, JFXButton btn,String location)throws Exception;
}

