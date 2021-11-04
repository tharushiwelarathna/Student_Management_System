package lk.brightway1.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.CourseBO;
import lk.brightway1.pos.bo.custom.RegDetailsBO;
import lk.brightway1.pos.bo.custom.RegistrationBO;
import lk.brightway1.pos.bo.custom.StudentBO;
import lk.brightway1.pos.db.DBConnection;
import lk.brightway1.pos.dto.CourseDTO;
import lk.brightway1.pos.dto.RegDetailsDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.view.tm.RegDetailsTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class FeesFormController {
    public AnchorPane root;
    public Label lblDate;
    public JFXComboBox cmbStudentId;
    public JFXComboBox cmbCourseCode;
    public JFXTextField txtDeuration;
    public JFXTextField txtCourseFee;
    public Label lblTotal;
    public TableColumn colCode;
    public TableColumn colDeuration;
    public TableColumn colCourseFee;
    public TableColumn colRegFee;
    public TableColumn colTotal;
    public TableColumn colDelete;
    public TableView<RegDetailsTM> tblRegDetails;
    public JFXTextField txtstudentFirstName;
    public Label lblId;
    public JFXTextField txtFee;
    public JFXButton btnGenarateDinamicReport;
    public JFXButton btnAdd;

    StudentBO studentBO;
    CourseBO courseBO;
    RegistrationBO registrationBO;
    RegDetailsBO regDetailsBO;

    public void initialize() throws Exception {

        // Let's set the date
        LocalDate today = LocalDate.now();
        lblDate.setText(today.toString());

        regDetailsBO = BoFactory.getInstance().getBO(BoFactory.BOType.REG_DETAILS);
        studentBO = BoFactory.getInstance().getBO(BoFactory.BOType.STUDENT);
        courseBO = BoFactory.getInstance().getBO(BoFactory.BOType.COURSE);
        registrationBO = BoFactory.getInstance().getBO(BoFactory.BOType.REGISTRATION);
        loadStudent();
        loadCourse();

    }

    private void loadStudent() throws Exception {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        ArrayList<StudentDTO> arrayList = studentBO.getAllStudents();
        for (StudentDTO studentDTO : arrayList) {
            observableList.add(studentDTO.getStudentID());
        }
        cmbStudentId.setItems(observableList);
    }

    public void cmbStudentIdOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO dto = studentBO.getStudent(String.valueOf(cmbStudentId.getValue()));
        if (dto != null) {
            txtstudentFirstName.setText(dto.getFirstName());
        }
    }

    private void loadCourse() throws Exception {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        ArrayList<CourseDTO> arrayList = courseBO.getAllCourses();
        for (CourseDTO courseDTO : arrayList) {
            observableList.add(courseDTO.getCode());
        }
        cmbCourseCode.setItems(observableList);
    }

    public void cmbCourseCodeOnAction(ActionEvent actionEvent) throws Exception {
        CourseDTO dto = courseBO.getCourse(String.valueOf(cmbCourseCode.getValue()));
        if (dto != null) {
            txtDeuration.setText(dto.getDeuration());
            txtCourseFee.setText(String.valueOf(dto.getCourseFee()));
        }
    }

    ObservableList<RegDetailsTM> observableList = FXCollections.observableArrayList();

    public void btnAddToCartOnAction(ActionEvent actionEvent) {

        colCode.setCellValueFactory(new PropertyValueFactory("courseCode"));
        colDeuration.setCellValueFactory(new PropertyValueFactory("deuration"));
        colCourseFee.setCellValueFactory(new PropertyValueFactory("courseFee"));
        colRegFee.setCellValueFactory(new PropertyValueFactory("regFee"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colDelete.setCellValueFactory(new PropertyValueFactory("button"));

        String code = String.valueOf(cmbCourseCode.getValue());
        String duration = txtDeuration.getText();
        double courseFee = Double.parseDouble(txtCourseFee.getText());
        double regFee = Double.parseDouble(txtFee.getText());
        double tot = courseFee + regFee;

        if (!observableList.isEmpty()) { // check observableList is empty

            for (int i = 0; i < tblRegDetails.getItems().size(); i++) { // check all rows in table
                if (colCode.getCellData(i).equals(code)) { // check  itemcode in table == itemcode we enter
                    new Alert(Alert.AlertType.WARNING, "Error", ButtonType.OK).show();
                    return;
                }
            }
        }
        Button button = new Button("Delete");
        observableList.add(new RegDetailsTM(code, duration, courseFee, regFee, tot));
        tblRegDetails.setItems(observableList); // if their is no list or, no matched itemcode
        getSubTotal();

        button.setOnAction((e) -> {
            try {
                RegDetailsTM selectedItem = tblRegDetails.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    observableList.remove(selectedItem);
                    tblRegDetails.getItems().remove(selectedItem);
                } else {
                    new Alert(Alert.AlertType.WARNING, "Please Select Row that You Want to Remove !").show();
                    tblRegDetails.requestFocus();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        generateRegNo();
    }

    private void generateRegNo() {
        try {
            lblId.setText(registrationBO.getNewRegNo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSubTotal() {
        double tot = 0.0;
        for (RegDetailsTM regDetailsTM : observableList) {
            tot += regDetailsTM.getTotal();
        }
        lblTotal.setText(String.valueOf(tot));
    }


    public void btnSaveOnAction(ActionEvent actionEvent) {

    }

    public void genarateDinamicOnAction(ActionEvent actionEvent) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/brightway1/pos/report/FeeReport.jrxml");

            JasperReport jr = JasperCompileManager.compileReport(is);
            HashMap hm = new HashMap();
            hm.put("deuration", txtDeuration.getText());
            hm.put("cosFee", txtCourseFee.getText());
            hm.put("regFee", txtFee.getText());
            hm.put("Total",lblTotal.getText());
            JasperPrint jp = JasperFillManager.fillReport(jr, hm, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp, true);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        try {
            if (tblRegDetails.getItems().size() == 0) {
                new Alert(Alert.AlertType.WARNING, "Add RegDetail", ButtonType.OK).show();
            } else {
                boolean isSaved = regDetailsBO.save(getRegister(),getRegDetails());
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
                } else {
                    new Alert(Alert.AlertType.CONFIRMATION, "Not Saved", ButtonType.OK).show();
                }
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "error", ButtonType.OK).show();


        }




    }

    private ArrayList<RegDetailsDTO> getRegDetails() {
        String code = String.valueOf(cmbCourseCode.getValue());
        ArrayList<RegDetailsDTO> regDetailDTOS = new ArrayList<>();

        for (int i = 0; i < tblRegDetails.getItems().size(); i++) {
            RegDetailsTM regDetailsTM = observableList.get(i);
            regDetailDTOS.add(new RegDetailsDTO(
                    regDetailsTM.getCourseCode(),regDetailsTM.getDeuration(),regDetailsTM.getCourseFee(),regDetailsTM.getRegFee(),
                    regDetailsTM.getTotal()));
        }
        return regDetailDTOS;
    }


    private RegDetailsDTO getRegister() {

        String code = String.valueOf(cmbCourseCode.getValue());
        String duration = txtDeuration.getText();
        double courseFee = Double.parseDouble(txtCourseFee.getText());
        double regFee = Double.parseDouble(txtFee.getText());
        double tot = courseFee + regFee;


        return new RegDetailsDTO(code,duration,courseFee,regFee,tot);
    }

}