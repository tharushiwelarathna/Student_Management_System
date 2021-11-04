package lk.brightway1.pos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.CourseBO;
import lk.brightway1.pos.bo.custom.RegistrationBO;
import lk.brightway1.pos.bo.custom.StudentBO;
import lk.brightway1.pos.bo.custom.UserBO;
import lk.brightway1.pos.dto.CourseDTO;
import lk.brightway1.pos.dto.UserDTO;
import lk.brightway1.pos.view.tm.CourseTM;
import lk.brightway1.pos.view.tm.UserTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainFormController  implements Initializable {
    public AnchorPane root;
    public Button btnStudents;
    public Button btnTeachers;
    public Button btnFees;


    public Button btnDashboard;
    public Button btnViewStudents;
    public Button btnAttendance;
    public Button btnRecords;
    public TableView<CourseTM> table;
    public TableColumn colCourseName;
    public Label lblNoOfTarget;
    public Label lblNoOfGirls;
    public Label lblNoOfBoys;
    public Label lblNoOfRegistered;
    public TableColumn colCourseName1;
    public TableView<UserTM> tbl;
    StudentBO bo;

    ObservableList<UserTM> oList = FXCollections.observableArrayList();
    ObservableList<CourseTM> observableList = FXCollections.observableArrayList();
    CourseBO courseBO = BoFactory.getInstance().getBO(BoFactory.BOType.COURSE);
    RegistrationBO rBo = BoFactory.getInstance().getBO(BoFactory.BOType.REGISTRATION);
    UserBO userBO=BoFactory.getInstance().getBO((BoFactory.BOType.USER));


    private void InitUI(String Location) {
        try {
            this.root.getChildren().clear();
            this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + Location)));
        }catch (IOException ex){
            System.out.println(ex);
         //   new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

        }
    }
    public  void initialize(){
        //studentOnAction(new ActionEvent());

    }

    public void dashboardOnAction(ActionEvent actionEvent) {
        InitUI("DashBoardForm.fxml");
    }

    public void studentOnAction(ActionEvent actionEvent) {
        InitUI("StudentForm.fxml");

       /* try {
            this.root.getChildren().clear();
            this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/StudentForm.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void teachersOnAction(ActionEvent actionEvent) {
        InitUI("TeachersForm.fxml");
    }

    public void feesOnAction(ActionEvent actionEvent) {
        InitUI("FeesForm.fxml");
    }


    public void viewStudentsOnAction(ActionEvent actionEvent){ InitUI("ViewStudentsForm.fxml"); }

    public void attendanceOnAction(ActionEvent actionEvent) {
        InitUI("AttendanceForm.fxml");
    }

    public void btnRecordsOnAction(ActionEvent actionEvent) {InitUI("RecordsForm.fxml");
    }

    public void addCourseForm(MouseEvent mouseEvent) {
        InitUI("ManageCourseForm.fxml");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bo= BoFactory.getInstance()
                .getBO(BoFactory.BOType.STUDENT);



        colCourseName1.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("corseName"));


        try {
            lblNoOfRegistered.setText(String.valueOf(rBo.getFullRegisterCount()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        loadCourseName();
        loadUserName();
    }

    private void loadUserName() {
        oList.clear();

        ArrayList<UserDTO> allUsers = null;
        try {
            allUsers = userBO.getAllUsers();

            for (UserDTO allUser : allUsers) {
                oList.add(new UserTM(allUser.getUserId(), allUser.getUserName(), allUser.getRoll()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tbl.setItems(oList);
    }

   /* public static void loadRegister(){
        //lblNoOfRegistered.setText(RegistrationBO.getFullRegisterCount());
        lblNoOfRegistered.setText(rBo.getFullRegisterCount());
    }*/

    private void loadCourseName() {
        observableList.clear();

        ArrayList<CourseDTO> allCourses = null;
        try {
            allCourses = courseBO.getAllCourses();

            for (CourseDTO allCours : allCourses) {
                observableList.add(new CourseTM(allCours.getCode(),allCours.getCourseName(),allCours.getCourseType(),allCours.getDeuration(),allCours.getCourseFee()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setItems(observableList);

    }

    public void addUserForm(MouseEvent mouseEvent) throws IOException{
        InitUI("UserForm.fxml");
    }
}
