package lk.brightway1.pos.bo.custom;

import javafx.collections.ObservableList;
import lk.brightway1.pos.dto.TeacherDTO;

import java.util.ArrayList;

public interface TeacherBO {
    public boolean saveTeacher(TeacherDTO dto)throws Exception;
    public boolean update(TeacherDTO dto)throws Exception;
    public boolean deleteTeacher(String id)throws Exception;
    public TeacherDTO getTeacher(String id)throws Exception;
    public ArrayList<TeacherDTO> getAllTeacher()throws Exception;
    public String getNewTeacherId() throws Exception;
    public TeacherDTO Search(String id) throws Exception;


}
