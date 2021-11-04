package lk.brightway1.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.RegistrationBO;
import lk.brightway1.pos.bo.custom.StudentBO;
import lk.brightway1.pos.bo.custom.TeacherBO;
import lk.brightway1.pos.db.DBConnection;
import lk.brightway1.pos.dto.RegistrationDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.dto.TeacherDTO;
import lk.brightway1.pos.view.tm.RegistrationTM;
import lk.brightway1.pos.view.tm.StudentTM;
import lk.brightway1.pos.view.tm.TeacherTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class RecordsFormController {
    public TableView<RegistrationTM> tblRegistration;
    public TableColumn colRegNo;
    public AnchorPane root;
    public TableColumn colRegDate;
    public TableColumn colStudentId;
    public TableColumn colCourseCode;
    public TableColumn colRegFee;
    public TableView<StudentTM> tblStudent;
    public TableColumn colId;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colAddress;
    public TableColumn colSContact;
    public TableColumn colDob;
    public TableColumn colGender;
    public TableView<TeacherTM> tblTeacher;
    public TableColumn colTID;
    public TableColumn colFName;
    public TableColumn colLName;
    public TableColumn colDOB;
    public TableColumn colJoinDate;
    public TableColumn colgender;
    public TableColumn colcontact;
    public TableColumn colCode;
    public JFXButton btnPrint;

    RegistrationBO registrationBO= BoFactory.getInstance().getBO(BoFactory.BOType.REGISTRATION);
    TeacherBO teacherBO=BoFactory.getInstance().getBO(BoFactory.BOType.TEACHER);
    StudentBO bo = BoFactory.getInstance().getBO(BoFactory.BOType.STUDENT);

    public void initialize() throws Exception {

        colRegNo.setCellValueFactory(new PropertyValueFactory("regNo"));
        colRegDate.setCellValueFactory(new PropertyValueFactory("regDate"));
        colStudentId.setCellValueFactory(new PropertyValueFactory("studentId"));
        colCourseCode.setCellValueFactory(new PropertyValueFactory("courseCode"));
        colRegFee.setCellValueFactory(new PropertyValueFactory("regFee"));




       colId.setCellValueFactory(new PropertyValueFactory("studentID"));
        colFirstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colSContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colDob.setCellValueFactory(new PropertyValueFactory("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));






        colTID.setCellValueFactory(new PropertyValueFactory("teacherId"));
        colFName.setCellValueFactory(new PropertyValueFactory("firstName"));
        colLName.setCellValueFactory(new PropertyValueFactory("lastName"));
        colDOB.setCellValueFactory(new PropertyValueFactory("dob"));
        colJoinDate.setCellValueFactory(new PropertyValueFactory("joinDate"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));
        colcontact.setCellValueFactory(new PropertyValueFactory("contactNumber"));
        colCode.setCellValueFactory(new PropertyValueFactory("courseCode"));


       LoadAllStudents();
        LoadAllTeachers();
        LoadAllRegistrations();




    }

    private void LoadAllRegistrations() {
        ObservableList<RegistrationTM> rList =
                FXCollections.observableArrayList();
        List<RegistrationDTO> allRegistrations = null;
        try {
            allRegistrations = registrationBO.getAllRegistrations();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (RegistrationDTO registrationDTO : allRegistrations
        ){ try {

            RegistrationTM r= new RegistrationTM(
                    registrationDTO.getRegNO(),
            registrationDTO.getRegDate(),registrationDTO.getStudentID(),
            registrationDTO.getCourseCode(),registrationDTO.getRegFee());

            rList.add(r);

        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
        }

        tblRegistration.setItems(rList);
    }



    private void LoadAllTeachers() {
        ObservableList<TeacherTM> tList =
                FXCollections.observableArrayList();
        List<TeacherDTO> allTeachers = null;
        try {
            allTeachers = teacherBO.getAllTeacher();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        for (TeacherDTO teacherDTO : allTeachers
        ){ try {

            TeacherTM t= new TeacherTM(teacherDTO.getTeacherId(),teacherDTO.getFirstName(),teacherDTO.getLastName(),teacherDTO.getDob(),
            teacherDTO.getJoinDate(),teacherDTO.getGender(),teacherDTO.getContactNumber(),teacherDTO.getCourseCode());

            tList.add(t);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        }

        tblTeacher.setItems(tList);
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


    public void btnPrintOnAction(ActionEvent actionEvent)  {
        try {
            InputStream is = this.getClass().getResourceAsStream("/lk/brightway1/pos/report/StudentReport.jasper");

            // JasperReport jr= JasperCompileManager.compileReport(is);
            JasperPrint jp = JasperFillManager.fillReport(is, null, DBConnection.getInstance().getConnection());
            //JasperPrintManager.printReport(jp,true);
            JasperViewer.viewReport(jp, true);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
