package lk.brightway1.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.UserBO;
import lk.brightway1.pos.dto.UserDTO;

import lk.brightway1.pos.view.tm.UserTM;

import java.util.List;
import java.util.regex.Pattern;

public class UserFormController {
    public JFXTextField txtUserId;
    public JFXTextField txtPassword;
    public JFXTextField txtName;
    public JFXTextField txtRoll;
    public JFXButton btnAdd;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXButton btnClear;
    public TableView<UserTM> tblUser;
    public TableColumn colUserId;
    public TableColumn colName;

    public TableColumn colRoll;
    public JFXButton btnNew;
    UserBO bo;
    ObservableList<UserTM> tmList = FXCollections.observableArrayList();
    public void initialize() throws Exception {
        bo= BoFactory.getInstance()
                .getBO(BoFactory.BOType.USER);


        colUserId.setCellValueFactory(new PropertyValueFactory("userId"));
        colName.setCellValueFactory(new PropertyValueFactory("userName"));
        //colPassword.setCellValueFactory(new PropertyValueFactory("password"));
        colRoll.setCellValueFactory(new PropertyValueFactory("roll"));


        loadAllUsers();


    }

    public void btnAddOnAction(ActionEvent actionEvent) throws Exception {
        if (Pattern.compile("^(U0)[0-9]{1,}$").matcher(txtUserId.getText()).matches()) {
            if (Pattern.compile("^[A-z]{1,}$").matcher(txtName.getText()).matches()) {
                if (Pattern.compile("^[0-9]{1,}$").matcher(txtPassword.getText()).matches()) {
                    if (Pattern.compile("^[A-z,0-9]{1,}$").matcher(txtRoll.getText()).matches()) {
                        boolean isSaved = bo.saveUser(
                                new UserDTO(txtUserId.getText(),
                                        txtName.getText(),
                                        txtPassword.getText(),
                                        txtRoll.getText()));
                        if(isSaved){

                            new Alert(Alert.AlertType.CONFIRMATION,"User Add Successfully", ButtonType.OK).show();
                            loadAllUsers();

                            return;
                        }else {
                            new Alert(Alert.AlertType.WARNING,"User Added if fail!", ButtonType.OK).show();

                        }


                        System.out.println(isSaved);

                    } else {
                        txtRoll.setFocusColor(Paint.valueOf("red"));
                        txtRoll.requestFocus();
                    }
                } else {
                    txtPassword.setFocusColor(Paint.valueOf("red"));
                    txtPassword.requestFocus();
                }
            } else {
                txtName.setFocusColor(Paint.valueOf("red"));
                txtName.requestFocus();
            }
        } else {
            txtUserId.setFocusColor(Paint.valueOf("red"));
            txtUserId.requestFocus();
        }


    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws Exception {
        try {
            boolean isDeleted=bo.deleteUser(txtUserId.getText());
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"User Deleted!!!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       tmList.clear();
        tblUser.refresh();
        loadAllUsers();
    }

    private void loadAllUsers() throws Exception {
        tmList.clear();
        List<UserDTO> allUsers = bo.getAllUsers();
        for (UserDTO userDTO : allUsers
        ) {
            UserTM tm = new UserTM(userDTO.getUserId(),
            userDTO.getUserName(),
            
            userDTO.getRoll());
            tmList.add(tm);

        }
        try {


        } catch (Exception e1) {
            e1.printStackTrace();
        }


        tblUser.setItems(tmList);
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws Exception {
        UserDTO userDTO = new UserDTO(
                txtUserId.getText(),
                txtName.getText(),
                txtPassword.getText(),
                txtRoll.getText()

        );
       // System.out.println("userDTO = " + userDTO);
        try {
            if(bo.updateUser(userDTO)){
                new Alert(Alert.AlertType.CONFIRMATION,"Succsess..!").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Failed..!").show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblUser.refresh();
        loadAllUsers();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtUserId.setText(null);
        txtName.setText(null);
        txtPassword.setText(null);
        txtRoll.setText(null);

    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        try {
            txtUserId.setText(bo.getNewUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
