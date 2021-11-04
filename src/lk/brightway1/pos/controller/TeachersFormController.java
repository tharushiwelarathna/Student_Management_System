package lk.brightway1.pos.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.TeacherBO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.dto.TeacherDTO;
import lk.brightway1.pos.entity.Teacher;
import org.apache.poi.hssf.record.formula.functions.T;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class TeachersFormController {
    public JFXButton btnClear;
    public JFXButton btnUpdate;
    public JFXTextField txtTeacherID;
    public AnchorPane root;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtContact;
    public JFXDatePicker txtDOB;
    public JFXButton btnSave;
    public JFXComboBox cmbGender;
    public JFXTextField txtCourseCode;
    public JFXDatePicker txtJoinDate;
    public JFXButton btnDelete;
    public JFXButton btnNew;
    TeacherBO bo;

    public void initialize() throws Exception {
        bo= BoFactory.getInstance()
                .getBO(BoFactory.BOType.TEACHER);
        cmbGender.setItems( FXCollections.observableArrayList("Male","Female"));

    }

    public void txtTIDSearchOnAction(ActionEvent actionEvent) {
        try {
            TeacherDTO teacherDTO = bo.Search(txtTeacherID.getText());
            if(teacherDTO !=null){
                txtTeacherID.setText(teacherDTO .getTeacherId());
                txtFirstName.setText(teacherDTO .getFirstName());
                txtLastName.setText(teacherDTO .getLastName());
                txtDOB.setValue(LocalDate.parse(teacherDTO .getDob()));
                txtJoinDate.setValue(LocalDate.parse(teacherDTO .getJoinDate()));
                cmbGender.setValue(teacherDTO .getGender());
                txtContact.setText(Integer.toString(teacherDTO .getContactNumber()));
                txtCourseCode.setText(teacherDTO .getCourseCode());
            } else {
                new Alert(Alert.AlertType.CONFIRMATION,"Teacher NotFound",ButtonType.OK).show();

            }
        } catch (Exception ex) {
            new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(),ButtonType.OK).show();

        }

    }





    public void btnClearOnAction(ActionEvent actionEvent) {
        txtTeacherID.setText(null);
        txtJoinDate.setValue(null);
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtContact.setText(null);
        txtDOB.setValue(null);
        cmbGender.setValue(null);
        txtCourseCode.setText(null);
    }

    public void btnUpdateOnACtion(ActionEvent actionEvent) {
        TeacherDTO teacherDTO = new TeacherDTO(
                txtTeacherID.getText(),
                txtFirstName.getText(),
                txtLastName.getText(),
                txtDOB.getValue().toString(),
                txtJoinDate.getValue().toString(),
                cmbGender.getValue().toString(),
                Integer.parseInt(txtContact.getText()),
                txtCourseCode.getText()
        );
        System.out.println("teacherDTO = " + teacherDTO);
        try {
            if(bo.update(teacherDTO)){
                new Alert(Alert.AlertType.CONFIRMATION,"Succsess..!").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Failed..!").show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
       /* boolean isSaved= false;
        try {
            isSaved = bo.saveTeacher(
                    new TeacherDTO(txtTeacherID.getText(),txtFirstName.getText(),
                            txtLastName.getText(),txtDOB.getValue().toString(),txtJoinDate.getValue().toString(),cmbGender.getValue().toString(),
                            Integer.parseInt(txtContact.getText()),txtCourseCode.getText())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(isSaved);

        */
        if (Pattern.compile("^(T00)[1-9]{1,}$").matcher(txtTeacherID.getText()).matches()) {
            if (Pattern.compile("^[A-z]{1,}$").matcher(txtFirstName.getText()).matches()) {
                if (Pattern.compile("^[A-z]{1,}$").matcher(txtLastName.getText()).matches()) {
                    if (Pattern.compile("^[0-9]{1,}[0-9]{1,}$").matcher(txtContact.getText()).matches()) {
                        if (Pattern.compile("^(C0)[1-9]{1,}$").matcher(txtCourseCode.getText()).matches()) {

                            boolean isSaved= false;
                            System.out.println(new TeacherDTO(txtTeacherID.getText(),txtFirstName.getText(),
                                    txtLastName.getText(),txtDOB.getValue().toString(),txtJoinDate.getValue().toString(),cmbGender.getValue().toString(),
                                    Integer.parseInt(txtContact.getText()),txtCourseCode.getText()));
                            try {
                                isSaved = bo.saveTeacher(
                                        new TeacherDTO(txtTeacherID.getText(),txtFirstName.getText(),
                                                txtLastName.getText(),txtDOB.getValue().toString(),txtJoinDate.getValue().toString(),cmbGender.getValue().toString(),
                                                Integer.parseInt(txtContact.getText()),txtCourseCode.getText())
                                );
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println(isSaved);
                        } else {
                            txtCourseCode.setFocusColor(Paint.valueOf("red"));
                            txtCourseCode.requestFocus();
                        }
                    } else {
                        txtContact.setFocusColor(Paint.valueOf("red"));
                        txtContact.requestFocus();
                    }
                } else {
                    txtLastName.setFocusColor(Paint.valueOf("red"));
                    txtLastName.requestFocus();
                }
            } else {
                txtFirstName.setFocusColor(Paint.valueOf("red"));
                txtFirstName.requestFocus();
            }
        }else {
            txtTeacherID.setFocusColor(Paint.valueOf("red"));
            txtTeacherID.requestFocus();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted=bo.deleteTeacher(txtTeacherID.getText());
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Teacher Deleted!!!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        // Generate a new id
        try {
            txtTeacherID.setText(bo.getNewTeacherId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
