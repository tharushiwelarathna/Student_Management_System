package lk.brightway1.pos.controller;

import com.jfoenix.controls.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.RegistrationBO;
import lk.brightway1.pos.bo.custom.StudentBO;
import lk.brightway1.pos.dto.RegistrationDTO;
import lk.brightway1.pos.dto.StudentDTO;

import java.io.IOException;
import java.util.regex.Pattern;


public class StudentFormController {
    public AnchorPane root;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtContact;
    public JFXDatePicker txtDOB;
    public JFXTextField txtAddress;
    public JFXTextField txtRegNo;
    public JFXTextField txtRegFee;
    public JFXTextField txtID;
    public JFXTextField txtCourseCode;
    public JFXButton btnClear;
    public JFXButton btnRegistor;
    public Label lblAmount;
    public JFXComboBox cmbGender;
    public JFXTextField txtSID;
    public JFXButton btnManageStudent;
    public JFXDatePicker txtRegDate;
    public JFXButton btnNew;
    StudentBO bo;
    RegistrationBO registrationBO;

    public void initialize() throws Exception {
        bo= BoFactory.getInstance()
                .getBO(BoFactory.BOType.STUDENT);
        registrationBO=BoFactory.getInstance().getBO(BoFactory.BOType.REGISTRATION);

        cmbGender.setItems( FXCollections.observableArrayList("Male","Female"));

        //date eka auto watenna liyanna

    }


    public void txtFirstNameSearchOnAction(ActionEvent actionEvent) {
    }

    public void txtSelectIDOnAction(ActionEvent actionEvent) {
    }

    public void txtSearchIDOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtID.setText(null);
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtAddress.setText(null);
        txtContact.setText(null);
        txtDOB.setValue(null);
        txtRegDate.setValue(null);
        cmbGender.setValue(null);
        txtRegNo.setText(null);
        txtSID.setText(null);
        txtRegFee.setText(null);
        txtCourseCode.setText(null);


    }



    public void btnSaveOnAction(ActionEvent actionEvent) {
       /* boolean isSaved= false;
        try {
            isSaved = bo.saveStudent(
                    new StudentDTO(txtID.getText(),txtFirstName.getText(),txtLastName.getText(),
                            txtAddress.getText(),Integer.parseInt(txtContact.getText()), txtDOB.getValue().toString(), cmbGender.getValue().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(isSaved);

        */
/*
        if (Pattern.compile("^(S00)[1-9]{1,}$").matcher(txtID.getText()).matches()) {
            if (Pattern.compile("^[A-z]{1,}$").matcher(txtFirstName.getText()).matches()) {
                if (Pattern.compile("^[A-z]{1,}$").matcher(txtLastName.getText()).matches()) {
                    if (Pattern.compile("^[A-z]{1,}$").matcher(txtAddress.getText()).matches()) {
                        if (Pattern.compile("^[0-9]{1,}[0-9]{1,}$").matcher(txtContact.getText()).matches()) {

                            boolean isSaved = false;
                            try {
                                isSaved = bo.saveStudent(
                                        new StudentDTO(txtID.getText(), txtFirstName.getText(), txtLastName.getText(),
                                                txtAddress.getText(), Integer.parseInt(txtContact.getText()), txtDOB.getValue().toString(), cmbGender.getValue().toString()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            System.out.println(isSaved);
                        } else {
                            txtContact.setFocusColor(Paint.valueOf("red"));
                            txtContact.requestFocus();
                        }
                    } else {
                        txtAddress.setFocusColor(Paint.valueOf("red"));
                        txtAddress.requestFocus();
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
            txtID.setFocusColor(Paint.valueOf("red"));
            txtID.requestFocus();
        }
*/



    }

    public void btnRegistorOnAction(ActionEvent actionEvent) {
       /* boolean isSaved=false;
        try {
            isSaved=registrationBO.saveStudent(new RegistrationDTO(txtRegNo.getText(),txtRegDate.getValue().toString(), txtSID.getText(), txtCourseCode.getText(), Double.parseDouble(txtRegFee.getText())));


            } catch (Exception ex) {
            ex.printStackTrace();

            }

            System.out.println(isSaved);

        */
        /*if (Pattern.compile("^(R)[0-9]{1,}$").matcher(txtRegNo.getText()).matches()) {
            if (Pattern.compile("^[\\d-]{1,}$").matcher(txtRegDate.getValue().toString()).matches()) {
                if (Pattern.compile("^(S)[0-9]{1,}$").matcher(txtSID.getText()).matches()) {
                    if (Pattern.compile("^(C)[0-9]{1,}$").matcher(txtCourseCode.getText()).matches()) {
                        if (Pattern.compile("^[\\d|.]{1,}$").matcher(txtRegFee.getText()).matches()) {

                            registrationBO.saveStudent(new RegistrationDTO(txtRegNo.getText(),txtRegDate.getValue().toString(), txtSID.getText(), txtCourseCode.getText(), Double.parseDouble(txtRegFee.getText())));


                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }

                            System.out.println(isSaved);
                        } else {
                            txtRegFee.setFocusColor(Paint.valueOf("red"));
                            txtRegFee.requestFocus();
                        }
                    } else {
                        txtCourseCode.setFocusColor(Paint.valueOf("red"));
                        txtCourseCode.requestFocus();
                    }
                } else {
                    txtSID.setFocusColor(Paint.valueOf("red"));
                    txtSID.requestFocus();
                }
            } else {
                txtRegDate.setDefaultColor(Paint.valueOf("red"));
                txtRegDate.requestFocus();
            }
        }else {
            txtRegNo.setFocusColor(Paint.valueOf("red"));
            txtRegNo.requestFocus();
        }

*/
        if (Pattern.compile("^(S0)[1-9]{1,}$").matcher(txtID.getText()).matches()) {
            if (Pattern.compile("^[A-z]{1,}$").matcher(txtFirstName.getText()).matches()) {
                if (Pattern.compile("^[A-z]{1,}$").matcher(txtLastName.getText()).matches()) {
                    if (Pattern.compile("^[A-z]{1,}$").matcher(txtAddress.getText()).matches()) {
                        if (Pattern.compile("^[0-9]{1,}[0-9]{1,}$").matcher(txtContact.getText()).matches()) {
                            if (Pattern.compile("^(R0)[0-9]{1,}$").matcher(txtRegNo.getText()).matches()) {
                                if (Pattern.compile("^[\\d-]{1,}$").matcher(txtRegDate.getValue().toString()).matches()) {
                                    if (Pattern.compile("^(S0)[0-9]{1,}$").matcher(txtSID.getText()).matches()) {
                                        if (Pattern.compile("^(C0)[0-9]{1,}$").matcher(txtCourseCode.getText()).matches()) {
                                            if (Pattern.compile("^[\\d|.]{1,}$").matcher(txtRegFee.getText()).matches()) {


        try {

            boolean isAdded = bo.saveStudent(getStudent(), getRegistration());
            if(isAdded){
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully!!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                                            } else {
                                                txtRegFee.setFocusColor(Paint.valueOf("red"));
                                                txtRegFee.requestFocus();
                                            }
                                        } else {
                                            txtCourseCode.setFocusColor(Paint.valueOf("red"));
                                            txtCourseCode.requestFocus();
                                        }
                                    } else {
                                        txtSID.setFocusColor(Paint.valueOf("red"));
                                        txtSID.requestFocus();
                                    }
                                } else {
                                    txtRegDate.setDefaultColor(Paint.valueOf("red"));
                                    txtRegDate.requestFocus();
                                }
                            }else {
                                txtRegNo.setFocusColor(Paint.valueOf("red"));
                                txtRegNo.requestFocus();
                            }
                        } else {
                            txtContact.setFocusColor(Paint.valueOf("red"));
                            txtContact.requestFocus();
                        }
                    } else {
                        txtAddress.setFocusColor(Paint.valueOf("red"));
                        txtAddress.requestFocus();
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
            txtID.setFocusColor(Paint.valueOf("red"));
            txtID.requestFocus();
        }


    }

    public StudentDTO getStudent() {

                            return new StudentDTO(

                                    txtID.getText(),
                                    txtFirstName.getText(),
                                    txtLastName.getText(),
                                    txtAddress.getText(),
                                    Integer.parseInt(txtContact.getText()),
                                    String.valueOf(txtDOB.getValue()),
                                    String.valueOf(cmbGender.getValue())
                            );


    }

    public RegistrationDTO getRegistration(){
        return new RegistrationDTO(
        txtRegNo.getText(),String.valueOf(txtRegDate.getValue()),
        txtSID.getText(),txtCourseCode.getText(),
                Double.parseDouble(txtRegFee.getText()));
    }


    public void btnManageStudentOnAction(ActionEvent actionEvent) {
        InitUI("ManageStudentForm.fxml");
    }
    private void InitUI(String Location) {
        try {
            this.root.getChildren().clear();
            this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/brightway1/pos/view/" + Location)));
        }catch (IOException ex){
            new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

        }
    }

    public void btnNewOnAction(ActionEvent actionEvent) {



        // Generate a new id
        try {
            txtID.setText(bo.getNewStudentId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
