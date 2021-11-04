package lk.brightway1.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.CourseBO;
import lk.brightway1.pos.dto.CourseDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.entity.Course;
import lk.brightway1.pos.view.tm.CourseTM;
import org.bson.types.Code;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class ManageCourseFormController {
    public AnchorPane root;
    public JFXTextField txtCode;
    public JFXTextField txtCourseName;
    public JFXTextField txtType;
    public JFXTextField txtDeuration;
    public JFXTextField txtFee;
    public TableView<CourseTM> tblCourse;
    public TableColumn colCode;
    public TableColumn colName;
    public TableColumn colType;
    public TableColumn colDeuration;
    public TableColumn colCourseFee;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXButton btnNew;

    CourseBO bo;
    ObservableList<CourseTM> tmList = FXCollections.observableArrayList();

    public void initialize() throws Exception {
        bo = BoFactory.getInstance()
                .getBO(BoFactory.BOType.COURSE);

        colCode.setCellValueFactory(new PropertyValueFactory("courseCode"));
        colName.setCellValueFactory(new PropertyValueFactory("corseName"));
        colType.setCellValueFactory(new PropertyValueFactory("courseType"));
        colDeuration.setCellValueFactory(new PropertyValueFactory("deuration"));
        colCourseFee.setCellValueFactory(new PropertyValueFactory("courseFee"));

        loadAllCourses();// Alt+ Enter

    }

    private void loadAllCourses() throws Exception {
        tmList.clear();
        List<CourseDTO> allCourses = bo.getAllCourses();
        for (CourseDTO courseDTO : allCourses
        ) {
            CourseTM tm = new CourseTM(courseDTO.getCode(), courseDTO.getCourseName(), courseDTO.getCourseType(),
                    courseDTO.getDeuration(), courseDTO.getCourseFee());
            tmList.add(tm);

        }
        try {


        } catch (Exception e1) {
            e1.printStackTrace();
        }


        tblCourse.setItems(tmList);

}

    public void btnAddOnAction(ActionEvent actionEvent) throws Exception {
       /* boolean isSaved= bo.saveCourse(
                new CourseDTO(txtCode.getText(),
                        txtCourseName.getText(),
                        txtType.getText(),
                        txtDeuration.getText(),
                        Double.parseDouble(txtFee.getText()))
        );
        System.out.println(isSaved);*/

        if (Pattern.compile("^(C0)[0-9]{1,}$").matcher(txtCode.getText()).matches()) {
            if (Pattern.compile("^[A-z]{1,}$").matcher(txtCourseName.getText()).matches()) {
                if (Pattern.compile("^[A-z]{1,}$").matcher(txtType.getText()).matches()) {
                    if (Pattern.compile("^[A-z,0-9]{1,}$").matcher(txtDeuration.getText()).matches()) {
                        if (Pattern.compile("^[0-9]{1,}$").matcher(txtFee.getText()).matches()) {
                            boolean isSaved = bo.saveCourse(
                                    new CourseDTO(txtCode.getText(),
                                            txtCourseName.getText(),
                                            txtType.getText(),
                                            txtDeuration.getText(),
                                            Double.parseDouble(txtFee.getText()))
                            );

                                if(isSaved){

                                    new Alert(Alert.AlertType.CONFIRMATION,"Course Add Successfully", ButtonType.OK).show();
                                    loadAllCourses();

                                    return;
                                }else {
                                    new Alert(Alert.AlertType.WARNING,"Course Added if fail!", ButtonType.OK).show();

                                }


                            System.out.println(isSaved);


                        } else {
                            txtFee.setFocusColor(Paint.valueOf("red"));
                            txtFee.requestFocus();
                        }
                    } else {
                        txtDeuration.setFocusColor(Paint.valueOf("red"));
                        txtDeuration.requestFocus();
                    }
                } else {
                    txtType.setFocusColor(Paint.valueOf("red"));
                    txtType.requestFocus();
                }
            } else {
                txtCourseName.setFocusColor(Paint.valueOf("red"));
                txtCourseName.requestFocus();
            }
        }else {
            txtCode.setFocusColor(Paint.valueOf("red"));
            txtCode.requestFocus();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws Exception {
        try {
            boolean isDeleted=bo.deleteCourse(txtCode.getText());
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Course Deleted!!!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tmList.clear();
        tblCourse.refresh();
        loadAllCourses();


    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        LoadCourseData(txtCode.getText());
    }

    private void LoadCourseData(String code) {
        try {
            CourseDTO c = bo.Search(code);
            txtCode.setText(c.getCode());
            txtCourseName.setText(c.getCourseName());
            txtType.setText(c.getCourseType());
            txtDeuration.setText(c.getDeuration());
            txtFee.setText(c.getCourseFee()+"");



        } catch (Exception ex) {
            // new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();
        }
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        txtCode.clear();
        txtCourseName.clear();
        txtType.clear();
        txtDeuration.clear();
        txtFee.clear();
        tblCourse.getSelectionModel().clearSelection();
        txtCourseName.setDisable(false);
        txtType.setDisable(false);
        txtDeuration.setDisable(false);
        txtFee.setDisable(false);
        txtCourseName.requestFocus();

        btnSave.setDisable(false);

        // Generate a new id
        try {
            txtCode.setText(bo.getNewCourseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
