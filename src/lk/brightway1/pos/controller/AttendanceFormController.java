package lk.brightway1.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.AttendanceBO;
import lk.brightway1.pos.bo.custom.StudentBO;
import lk.brightway1.pos.dto.AttendanceDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.entity.Attendance;
import lk.brightway1.pos.view.tm.AttendanceTM;
import lk.brightway1.pos.view.tm.StudentTM;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AttendanceFormController {

    public JFXButton btnCheckAttendance;
    public JFXButton btnStarting;
    public JFXButton btnEnding;
    public JFXButton btnAbsent;
    public TableView <AttendanceTM>tblAttendance;
    public TableColumn colDate;
    public TableColumn colStarting;
    public TableColumn colEnding;
    public TableColumn colStudyHours;
    public Label lblStudentName;
    public JFXComboBox cmbStudentId;
    public Label lblAbsentStudent;

    StudentBO studentBO = BoFactory.getInstance().getBO(BoFactory.BOType.STUDENT);
    AttendanceBO attendanceBO = BoFactory.getInstance().getBO(BoFactory.BOType.ATTENDANCE);

    public void initialize(){
        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));*/

        loadStudentId();
        checkAbsentStudent();
        setCellValueFactory();

        colDate.setCellValueFactory(new PropertyValueFactory("dates"));
        colStarting.setCellValueFactory(new PropertyValueFactory("startingTime"));
        colEnding.setCellValueFactory(new PropertyValueFactory("endingTime"));
        colStudyHours.setCellValueFactory(new PropertyValueFactory("studingHours"));


        try {
            loadAllAttendance();// Alt+ Enter
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadAllAttendance() throws Exception{
        ObservableList<AttendanceTM> tmList =
                FXCollections.observableArrayList();
        List<AttendanceDTO> allAttendances = null;
        try {
            allAttendances = attendanceBO.getAllAttendances();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (AttendanceDTO dto : allAttendances
        ){ try {

            AttendanceTM tm= new AttendanceTM(dto.getDates(),dto.getStartingTime(),dto.getEndingTime(),dto.getStudingHours());

            tmList.add(tm);

        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
        }

        tblAttendance.setItems(tmList);

    }

    public void loadStudentId(){
       /* try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            ArrayList<String> idList = studentBO.getStudentName();
            for(String s : idList){
                obList.add(s);
            }
            cmbStudentId.setItems(obList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        */

        try {
            ArrayList<StudentDTO> allStudent = studentBO.getAllStudents();
            ObservableList sidlist= FXCollections.observableArrayList();
            for (StudentDTO dto:allStudent) {
                sidlist.add(dto.getStudentID());

            }
            cmbStudentId.setItems(sidlist);
        } catch (Exception ex) {
            // new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

        }
    }

    public void btnCheckAttendanceOnAction(ActionEvent actionEvent) {
        ObservableList<AttendanceTM> obList = FXCollections.observableArrayList();

        try {
            ArrayList<AttendanceDTO> dtoList = attendanceBO.getAttendance(String.valueOf(cmbStudentId.getValue()));

            for(AttendanceDTO dto : dtoList){
                obList.add(new AttendanceTM(
                        dto.getDates(),
                        dto.getStartingTime(),
                        dto.getEndingTime(),
                        dto.getStudingHours()
                ));
            }
            tblAttendance.setItems(obList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnStartingOnAction(ActionEvent actionEvent) {
        String date = LocalDate.now().toString();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String checkTime = dtf.format(now);

        try {
            if(attendanceBO.saveAttendance(new AttendanceDTO(
                    String.valueOf(cmbStudentId.getValue()),
                   date,
                    checkTime,
                   checkTime,
                  checkTime




            ))){
                new Alert(Alert.AlertType.CONFIRMATION, "Good Morning").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something going wrong !").show();
        }
    }

    public void btnEndingOnAction(ActionEvent actionEvent) {
        String StartingTime = "absent";

        String date = LocalDate.now().toString();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String checkOut = dtf.format(now);

        try {
            attendanceBO.getAttendance(String.valueOf(cmbStudentId.getValue()));
            //StartingTime = attendance.getStartingTime();

            if(attendanceBO.updateAttendance(new AttendanceDTO(
                    String.valueOf(cmbStudentId.getValue()),
                    date,
                    StartingTime,
                    checkOut,
                    checkOut
            ))){
                new Alert(Alert.AlertType.CONFIRMATION, "Come Tomorrow !!").show();

            }else{
                new Alert(Alert.AlertType.ERROR, "Something went wrong !!").show();
            }
        } catch (Exception e) {
            //new Alert(Alert.AlertType.ERROR, "Something going wrong !").show();
            System.out.println(e);
        }

    }

    public void btnAbsentOnAction(ActionEvent actionEvent) {
        String date = LocalDate.now().toString();
        try {
            if(attendanceBO.saveAttendance(new AttendanceDTO(
                    String.valueOf(cmbStudentId.getValue()),
                    date,
                    "Absent",
                    "Absent",
                    "Absent"
            ))){
                new Alert(Alert.AlertType.INFORMATION, "Absent Confirmed !").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something going wrong !").show();
        }
    }

    public void cmbStudentIdOnAction(ActionEvent actionEvent) {
        try {
            StudentDTO dto = studentBO.getStudent(String.valueOf(cmbStudentId.getValue()));
            lblStudentName.setText(dto.getFirstName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void checkAbsentStudent(){
        try {

            lblAbsentStudent.setText(String.valueOf(attendanceBO.checkAbsentStudent()));
        } catch (Exception e) {
            lblAbsentStudent.setText("0");
        }
    }
    private void setCellValueFactory(){
        colDate.setCellValueFactory(new PropertyValueFactory("date"));
        colStarting.setCellValueFactory(new PropertyValueFactory("starting"));
        colEnding.setCellValueFactory(new PropertyValueFactory("ending"));
        colStudyHours.setCellValueFactory(new PropertyValueFactory("studyHours"));
    }
}
