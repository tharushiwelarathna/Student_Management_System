package lk.brightway1.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.StudentBO;
import lk.brightway1.pos.dto.RegistrationDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.dto.StudentDetailsDTO;
import lk.brightway1.pos.view.tm.StudentDetailTM;
import lk.brightway1.pos.view.tm.StudentTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewStudentsFormController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtID;

    @FXML
    private TableView<StudentDetailTM> tblStudent;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colCourseCode;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblDob;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblRegNo;

    @FXML
    private Label lblRegDate;

    @FXML
    private Label lblCourseCode;

    @FXML
    private Label lblLastName;

    @FXML

    private Label lblRegFee;
    StudentBO studentBO;
    ObservableList<StudentDetailTM> observableList=FXCollections.observableArrayList();

    @FXML
    void txtIDSearchOnAction(ActionEvent event) throws Exception {
        ArrayList<StudentDTO> allStudents = studentBO.getAllStudents();
        for (StudentDTO allStudent : allStudents) {
            if (txtID.getText().equals(allStudent.getStudentID())){
                lblFirstName.setText(allStudent.getFirstName());
                lblLastName.setText(allStudent.getLastName());
                lblAddress.setText(allStudent.getAddress());
                lblContact.setText(String.valueOf(allStudent.getContact()));
                lblDob.setText(allStudent.getDob());
                lblGender.setText(allStudent.getGender());
            }
        }

        ArrayList<RegistrationDTO> registerDetails = studentBO.getRegisterDetails(txtID.getText());
        for (RegistrationDTO registerDetail : registerDetails) {
            lblRegNo.setText(registerDetail.getRegNO());
            lblRegDate.setText(registerDetail.getRegDate());
            lblCourseCode.setText(registerDetail.getCourseCode());
            lblRegFee.setText(String.valueOf(registerDetail.getRegFee()));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        colCourseCode.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));

        studentBO=BoFactory.getInstance().getBO(BoFactory.BOType.STUDENT);

        try {
            tableLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void tableLoad() throws Exception {
        ArrayList<StudentDetailsDTO> studentDetails = studentBO.getStudentDetails();
        for (StudentDetailsDTO studentDetail : studentDetails) {
            observableList.add(new StudentDetailTM(studentDetail.getStudentID(),studentDetail.getFirstName(),studentDetail.getLastName(),studentDetail.getCourseCode()));
        }
        tblStudent.setItems(observableList);

    }

}

