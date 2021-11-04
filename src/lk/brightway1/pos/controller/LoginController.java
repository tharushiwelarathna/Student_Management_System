package lk.brightway1.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.Login2BO;
import lk.brightway1.pos.bo.custom.LoginBO;

import java.io.IOException;
import java.net.URL;



public class LoginController {

    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXButton btnSignIn;
    public AnchorPane root;

    private LoginBO loginBO= BoFactory.getInstance().getBO(BoFactory.BOType.LOGIN);
    private Login2BO login2BO=BoFactory.getInstance().getBO(BoFactory.BOType.LOGIN2);

    public void btnSighInOnAction(ActionEvent actionEvent) throws IOException {


        try {

            loginBO.loginUser(txtUserName,txtPassword,btnSignIn,"MainForm.fxml");




        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        String userName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();

        if (userName.length() > 0 && password.length() > 0) {
            if (userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234")) {

                // b=false;
                //setVisible();

                URL resource = this.getClass().getResource("/lk/brightway1/pos/view/MainForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene = new Scene(load);
                Stage stage = new Stage();
                // stage.setTitle("Library Management System");
                stage.setScene(scene);
//                stage.initStyle(StageStyle.TRANSPARENT);
                stage.show();

                Stage close = (Stage) btnSignIn.getScene().getWindow();
                close.close();

            } else if (userName.equalsIgnoreCase("user") && password.equalsIgnoreCase("4321")) {


                URL resource = this.getClass().getResource("/lk/brightway1/pos/view/MainFormUser.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene = new Scene(load);
                Stage stage = new Stage();
                // stage.setTitle("Library Management System");
                stage.setScene(scene);
//                stage.initStyle(StageStyle.TRANSPARENT);
                stage.show();

                Stage close = (Stage) btnSignIn.getScene().getWindow();
                close.close();

            }else{
                new Alert(Alert.AlertType.WARNING, "Invalid UserName or Password!", ButtonType.OK).show();
                txtUserName.requestFocus();
                txtPassword.requestFocus();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "Enter User and Password", ButtonType.OK).show();
            txtUserName.requestFocus();
        }



         */
    }




}
