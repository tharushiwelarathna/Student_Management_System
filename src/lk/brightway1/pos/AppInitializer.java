package lk.brightway1.pos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AppInitializer extends Application {



    public static void main(String[] args){launch(args);}
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
       Parent root=FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/Login.fxml"))));
        primaryStage.setTitle("DashBoard");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.resizableProperty().setValue(false);

        
        primaryStage.setScene(new Scene(root));

        primaryStage.show();

         */

      /*  primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/Login.fxml"))));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();

       */
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/Login.fxml"))));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }
}
