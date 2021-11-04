package lk.brightway1.pos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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

public class DashBoardFormUserController implements Initializable {
    public AnchorPane root;
    public TableView <CourseTM>table;
    public TableColumn colCourseName;
    public Label lblNoOfTarget;
    public Label lblNoOfGirls;
    public Label lblNoOfBoys;
    public Label lblNoOfRegistered;
    public TableView<UserTM> tbl;
    public TableColumn colCourseName1;
    StudentBO bo;
    RegistrationBO registrationBO;
    ObservableList<UserTM> oList = FXCollections.observableArrayList();
    ObservableList<CourseTM> observableList = FXCollections.observableArrayList();
    CourseBO courseBO = BoFactory.getInstance().getBO(BoFactory.BOType.COURSE);
    RegistrationBO rBo = BoFactory.getInstance().getBO(BoFactory.BOType.REGISTRATION);
    UserBO userBO=BoFactory.getInstance().getBO((BoFactory.BOType.USER));


    public void addCourseForm(MouseEvent mouseEvent)  throws IOException {
        InitUI("ManageCourseForm.fxml");
    }
    private void InitUI(String Location) {
        try {
            this.root.getChildren().clear();
            this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/brightway1/pos/view/" + Location)));
        }catch (IOException ex){
            new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registrationBO=BoFactory.getInstance().getBO(BoFactory.BOType.REGISTRATION);
        bo= BoFactory.getInstance()
                .getBO(BoFactory.BOType.STUDENT);




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

    /*
    public void addUserForm(MouseEvent mouseEvent) throws IOException{
        InitUI("UserForm.fxml");
    }

     */
}
