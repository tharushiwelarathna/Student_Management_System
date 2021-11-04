package lk.brightway1.pos.bo.custom.impl;

import lk.brightway1.pos.bo.custom.TeacherBO;
import lk.brightway1.pos.dao.DAOFactory;
import lk.brightway1.pos.dao.custom.TeacherDAO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.dto.TeacherDTO;
import lk.brightway1.pos.entity.Student;
import lk.brightway1.pos.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherBOImpl implements TeacherBO {
    TeacherDAO teacherDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.TEACHER);
    @Override
    public boolean saveTeacher(TeacherDTO dto) throws Exception {
        return teacherDAO.save(new Teacher(dto.getTeacherId(),dto.getFirstName(),dto.getLastName(),dto.getJoinDate(),
                dto.getDob(),dto.getGender(),dto.getContactNumber(),dto.getCourseCode()));
    }

    @Override
    public boolean update(TeacherDTO dto) throws Exception {
        return teacherDAO.update(new Teacher(dto.getTeacherId(),dto.getFirstName(),dto.getLastName(),dto.getDob(),dto.getJoinDate(),dto.getGender(),
                dto.getContactNumber(),dto.getCourseCode()));
    }


    @Override
    public boolean deleteTeacher(String id) throws Exception {
        return teacherDAO.delete(id);
    }

    @Override
    public TeacherDTO getTeacher(String id) throws Exception {
        Teacher teacher=teacherDAO.get(id);
        return new TeacherDTO(teacher.getTeacherId(),teacher.getFirstName(),teacher.getLastName(),teacher.getDob(),
                teacher.getJoinDate(),teacher.getGender(),teacher.getContactNumber(),teacher.getCourseCode());

    }

    @Override
    public ArrayList<TeacherDTO> getAllTeacher() throws Exception {
        List<Teacher> TList=teacherDAO.getAll();
        ArrayList<TeacherDTO> dtoList= new ArrayList();
        for (Teacher teacher: TList) {
            dtoList.add(new TeacherDTO(
                    teacher.getTeacherId(),
                    teacher.getFirstName(),
                    teacher.getLastName(),
                    teacher.getDob(),
                    teacher.getJoinDate(),
                    teacher.getGender(),
                    teacher.getContactNumber(),
                    teacher.getCourseCode()
            ));
        }
        return dtoList;
    }

    @Override
    public String getNewTeacherId() throws Exception {
        String lastTeacherId = teacherDAO.getLastTeacherId();

        if (lastTeacherId  == null) {
            return "T001";
        } else {
            int maxId = Integer.parseInt(lastTeacherId .replace("T", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "T00" + maxId;
            } else if (maxId < 100) {
                id = "T0" + maxId;
            } else {
                id = "T" + maxId;
            }
            return id;
        }
    }

    @Override
    public TeacherDTO Search(String id) throws Exception {
        Teacher teacher = teacherDAO.Search(id);
        return new TeacherDTO(teacher.getTeacherId(),teacher.getFirstName(),teacher.getLastName(),teacher.getDob(),teacher.getJoinDate(),
                teacher.getGender(),teacher.getContactNumber(),teacher.getCourseCode());
    }
}
