package lk.brightway1.pos.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginFormController implements Initializable {
    public VBox vbox;

    private Parent fxml;

    public void open_signInOnAction(ActionEvent actionEvent) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1),vbox);
        t.setToX(vbox.getLayoutX()*20);
        t.play();
        t.setOnFinished((e)->{
            try {
                fxml = FXMLLoader.load(getClass().getResource("/lk/brightway1/pos/view/SignInForm.fxml/"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException ex) {
                Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE,null,ex);
            }

        });

    }

    public void open_signupOnAction(ActionEvent actionEvent) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1),vbox);
//        t.setToX(vbox.getLayoutX()*20);
        t.setToX(vbox.getLayoutX()*1.1);
        t.play();
        t.setOnFinished((e)->{
            try {
                fxml = FXMLLoader.load(getClass().getResource("/lk/brightway1/pos/view/SignUpForm.fxml/"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException ex) {
                Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE,null,ex);
            }

        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t=new TranslateTransition(Duration.seconds(1),vbox);
        t.setToX(vbox.getLayoutX()*20);
        t.play();
        t.setOnFinished((e)->{
            try {
                fxml=FXMLLoader.load(getClass().getResource("/lk/brightway1/pos/view/SignInForm.fxml/"));
            } catch (IOException ex) {
                Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE,null,ex);
            }


        });

    }
}
