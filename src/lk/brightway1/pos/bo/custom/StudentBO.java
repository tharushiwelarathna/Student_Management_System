package lk.brightway1.pos.bo.custom;

import javafx.collections.ObservableList;
import lk.brightway1.pos.dto.RegistrationDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.dto.StudentDetailsDTO;

import java.util.ArrayList;
import java.util.List;

public interface StudentBO {

    public StudentDTO Search(String id)throws Exception;

    public boolean saveStudent(StudentDTO dto, RegistrationDTO regDTO)throws Exception;
    public  boolean updateStudent(StudentDTO dto)throws Exception;
    public boolean deletestudent(String id)throws Exception;
    public StudentDTO getStudent(String id)throws Exception;
    public ArrayList<StudentDTO> getAllStudents()throws Exception;
    public String getNewStudentId() throws Exception;
    public ArrayList<StudentDetailsDTO>getStudentDetails()throws Exception;
    public ArrayList<RegistrationDTO>getRegisterDetails(String id)throws Exception;





}
