package lk.brightway1.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.config.JREInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.StudentBO;
import lk.brightway1.pos.dto.CourseDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.entity.Student;
import lk.brightway1.pos.view.tm.CourseTM;
import lk.brightway1.pos.view.tm.StudentTM;
import rex.utils.S;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ManageStudentFormController {
    public AnchorPane root;
    public TableView<StudentTM> tblStudent;
    public TableColumn colID;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDOB;
    public TableColumn colGender;
    public JFXComboBox CmbID;
    public JFXTextField txtId;
    public JFXButton btnBack;
    public JFXButton btnClear;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXTextField lblFirstName;
    public JFXTextField lblAddress;
    public JFXTextField lblDob;
    public JFXTextField lblLastName;
    public JFXTextField lblContact;
    public JFXTextField lblGender;

    StudentBO bo = BoFactory.getInstance().getBO(BoFactory.BOType.STUDENT);


    public void initialize() throws Exception {

        colID.setCellValueFactory(new PropertyValueFactory("studentID"));
        colFirstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colDOB.setCellValueFactory(new PropertyValueFactory("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));

        LoadStudentID();


        LoadAllStudents();

    }


    private void LoadAllStudents() {
        ObservableList<StudentTM> tmList =
                FXCollections.observableArrayList();
        List<StudentDTO> allStudents = null;
        try {
            allStudents = bo.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (StudentDTO studentDTO : allStudents
        ){ try {

            StudentTM tm= new StudentTM(studentDTO.getStudentID(),studentDTO.getFirstName(),
                    studentDTO.getLastName(),studentDTO.getAddress(),studentDTO.getContact(),studentDTO.getDob(),studentDTO.getGender());

            tmList.add(tm);

            }
            catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        tblStudent.setItems(tmList);

    }



    private void LoadStudentID() {
        try {
            ArrayList<StudentDTO> allStudent = bo.getAllStudents();
            ObservableList sidlist= FXCollections.observableArrayList();
            for (StudentDTO dto:allStudent) {
                sidlist.add(dto.getStudentID());

            }
            CmbID.setItems(sidlist);
        } catch (Exception ex) {
            // new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

        }
    }




    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/brightway1/pos/view/MainForm.fxml"))));

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        lblFirstName.setText(null);
        lblLastName.setText(null);
        lblGender.setText(null);
        lblDob.setText(null);
        lblContact.setText(null);
        lblAddress.setText(null);
        txtId.setText(null);


    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws Exception {
        try {
            boolean isDeleted=bo.deletestudent(txtId.getText());
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Student Deleted!!!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        tblStudent.refresh();
        LoadAllStudents();

    }



    public void btnUpdateOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO(txtId.getText(), lblFirstName.getText(), lblLastName.getText(), lblAddress.getText(), Integer.parseInt(lblContact.getText()), lblDob.getText(), lblGender.getText());
       // System.out.println("studentDTO = " + studentDTO);
        try {
            if(bo.updateStudent(studentDTO)){
                new Alert(Alert.AlertType.CONFIRMATION,"Succsess..!").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Failed..!").show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblStudent.refresh();
        LoadAllStudents();

    }



    public void txtSearchIdOnAction(ActionEvent actionEvent) {
        LoadStudentData(txtId.getText());


    }

    private void LoadStudentData(String id) {
        try {
            StudentDTO student = bo.Search(id);

            txtId.setText(student.getStudentID());
            lblFirstName.setText(student.getFirstName());
            lblLastName.setText(student.getLastName());
            lblAddress.setText(student.getAddress());
            lblContact.setText(Integer.toString(student.getContact()));
            lblDob.setText(student.getDob());
            lblGender.setText(student.getGender());

        } catch (Exception ex) {
            // new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();
        }
    }

    public void cmbSelectIdOnAction(ActionEvent actionEvent) {
        LoadStudentData((String) CmbID.getValue());
    }
}
