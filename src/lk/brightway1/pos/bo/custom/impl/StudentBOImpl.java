package lk.brightway1.pos.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.brightway1.pos.bo.BoFactory;
import lk.brightway1.pos.bo.custom.RegistrationBO;
import lk.brightway1.pos.bo.custom.StudentBO;
import lk.brightway1.pos.dao.DAOFactory;
import lk.brightway1.pos.dao.custom.QueryDAO;
import lk.brightway1.pos.dao.custom.RegDetailsDAO;
import lk.brightway1.pos.dao.custom.RegistrationDAO;
import lk.brightway1.pos.dao.custom.StudentDAO;
import lk.brightway1.pos.db.DBConnection;
import lk.brightway1.pos.dto.RegistrationDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.dto.StudentDetailsDTO;
import lk.brightway1.pos.entity.Registration;
import lk.brightway1.pos.entity.Student;
import lk.brightway1.pos.entity.StudentDetails;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    QueryDAO queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QUERY);
    private StudentDAO dao= DAOFactory.getInstance()
            .getDAO(DAOFactory.DAOType.STUDENT);

    RegistrationBO rBo = BoFactory.getInstance().getBO(BoFactory.BOType.REGISTRATION);

    @Override
    public StudentDTO Search(String id) throws Exception {
        Student s = dao.Search(id);
        return new StudentDTO(
                s.getStudentId(),
                s.getFirstName(),
                s.getLastName(),
                s.getAddress(),
                s.getContact(),
                s.getDob(),
                s.getGender()   
        );
    }

    @Override
    public boolean saveStudent(StudentDTO dto, RegistrationDTO regDto) throws Exception {
        DBConnection.getInstance().getConnection().setAutoCommit(false);
        try {

            if (dao.save(new Student(
                    dto.getStudentID(),
                    dto.getFirstName(),
                    dto.getLastName(),
                    dto.getAddress(),
                    dto.getContact(),
                    dto.getDob(),
                    dto.getGender()
            ))) {
                if (rBo.saveRegistration(new RegistrationDTO(
                        regDto.getRegNO(),
                        regDto.getRegDate(),
                        regDto.getStudentID(),
                        regDto.getCourseCode(),
                        regDto.getRegFee()
                ))) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        }finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return dao.update(new Student(dto.getStudentID(),dto.getFirstName(),
                dto.getLastName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));
    }


    @Override
    public boolean deletestudent(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student s=dao.get(id);
        return new StudentDTO(s.getStudentId(),s.getFirstName(),s.getLastName(),s.getAddress(),
                s.getContact(),s.getDob(),s.getGender());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        List<Student> sList=dao.getAll();
        ArrayList<StudentDTO> dtoList= new ArrayList();
        for (Student s : sList) {
            dtoList.add(new StudentDTO(s.getStudentId(),s.getFirstName(),s.getLastName(),s.getAddress(),s.getContact(),s.getDob(),s.getGender()));
        }
        return dtoList;
    }

    @Override
    public String getNewStudentId() throws Exception {
        String lastStudentId = dao.getLastStudentId();

        if (lastStudentId  == null) {
            return "S001";
        } else {
            int maxId = Integer.parseInt(lastStudentId .replace("S", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "S00" + maxId;
            } else if (maxId < 100) {
                id = "S0" + maxId;
            } else {
                id = "S" + maxId;
            }
            return id;
        }
    }



    @Override
    public ArrayList<StudentDetailsDTO> getStudentDetails() throws Exception {
        ArrayList<StudentDetailsDTO> arrayList = new ArrayList<>();
        ArrayList<StudentDetails> studentDetails = queryDAO.getStudentDetails();
        for (StudentDetails studentDetail : studentDetails) {
            arrayList.add(new StudentDetailsDTO(studentDetail.getStudentID(),studentDetail.getFirstName(),studentDetail.getLastName(),studentDetail.getCourseCode()));
        }
        return arrayList;
    }

    @Override
    public ArrayList<RegistrationDTO> getRegisterDetails(String id) throws Exception {
        ArrayList<RegistrationDTO> arrayList = new ArrayList<>();
        ArrayList<Registration> registerDetails = queryDAO.getRegisterDetails(id);
        for (Registration registerDetail : registerDetails) {
            arrayList.add(new RegistrationDTO(registerDetail.getRegNO(),registerDetail.getRegDate(),registerDetail.getStudentID(),registerDetail.getCourseCode(),registerDetail.getRegFee()));
        }
        return arrayList;
    }


}
