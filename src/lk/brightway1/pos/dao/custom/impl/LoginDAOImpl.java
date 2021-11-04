package lk.brightway1.pos.dao.custom.impl;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import lk.brightway1.pos.dao.custom.LoginDAO;
import lk.brightway1.pos.db.DBConnection;
import lk.brightway1.pos.entity.Login;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {


    @Override
    public boolean save(Login login) throws Exception {
        return false;
    }

    @Override
    public boolean update(Login login) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Login get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Login> getAll() throws Exception {
        return null;
    }

    @Override
    public Login Search(String id) throws Exception {
        return null;
    }

    @Override
    public Login find(String key) throws Exception {
        return null;
    }

    @Override
    public void loginUser(JFXTextField txt, JFXTextField pw, JFXButton btn,String location) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM login WHERE userName=? AND pw=?");
        ps.setString(1, txt.getText());
        ps.setString(2, pw.getText());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            // System.out.println("login now");
//            URL resource = this.getClass().getResource("/lk/brightway1/pos/view/MainForm.fxml");
            Stage close = (Stage) btn.getScene().getWindow();
            close.close();
            URL resource = this.getClass().getResource("/lk/brightway1/pos/view/"+location);
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();

            stage.setScene(scene);
//
            stage.show();





        }else{
            // System.out.println("no");
            new Alert(Alert.AlertType.WARNING, "Please Check UserName or Password ", ButtonType.OK).show();
        }

    }
}
