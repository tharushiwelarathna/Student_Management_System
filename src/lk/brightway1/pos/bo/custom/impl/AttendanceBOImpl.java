package lk.brightway1.pos.bo.custom.impl;

import lk.brightway1.pos.bo.custom.AttendanceBO;
import lk.brightway1.pos.dao.DAOFactory;
import lk.brightway1.pos.dao.custom.AttendanceDAO;
import lk.brightway1.pos.dao.custom.QueryDAO;
import lk.brightway1.pos.dao.custom.StudentDAO;
import lk.brightway1.pos.dto.AttendanceDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.entity.Attendance;
import lk.brightway1.pos.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class AttendanceBOImpl implements AttendanceBO {
    QueryDAO queryDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QUERY);
    private AttendanceDAO dao= DAOFactory.getInstance()
            .getDAO(DAOFactory.DAOType.ATTENDANCE);


    @Override
    public boolean saveAttendance(AttendanceDTO dto) throws Exception {
        return dao.save(new Attendance(dto.getStudentID(),  dto.getDates(),
                dto.getStartingTime(),dto.getEndingTime(),dto.getStudingHours()));
    }

    @Override
    public boolean updateAttendance(AttendanceDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAttendance(String id) throws Exception {
        return false;
    }

    @Override
    public ArrayList<AttendanceDTO> getAttendance(String id) throws Exception {
        ArrayList<Attendance> listDto = queryDAO.getEmployeeAttendance(id);
        ArrayList<AttendanceDTO> dtoList = new ArrayList<>();

        for(Attendance at : listDto){
            dtoList.add(new AttendanceDTO(
                    at.getStudentID(),
                    at.getDates(),
                    at.getStartingTime(),
                    at.getEndingTime(),
                    at.getStudyingHours()
            ));
        }
        return dtoList;



    }


    @Override
    public ArrayList<AttendanceDTO> getAllAttendances() throws Exception {
        List<Attendance> aList=dao.getAll();
        ArrayList<AttendanceDTO> dtoList= new ArrayList();
        for (Attendance attendance : aList) {
            dtoList.add(new AttendanceDTO(attendance.getStudentID(),attendance.getDates(),attendance.getStartingTime(),
                    attendance.getEndingTime(),attendance.getStudyingHours()));
        }
        return dtoList;
    }

    @Override
    public char[] checkAbsentStudent() {
        return new char[0];
    }

    @Override
    public List<AttendanceDTO> getAllAttendance(String valueOf) {
        return null;
    }
}
