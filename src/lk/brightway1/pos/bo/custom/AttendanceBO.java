package lk.brightway1.pos.bo.custom;

import lk.brightway1.pos.dto.AttendanceDTO;
import lk.brightway1.pos.entity.Attendance;

import java.util.ArrayList;
import java.util.List;

public interface AttendanceBO {
    public boolean saveAttendance(AttendanceDTO dto)throws Exception;
    public boolean updateAttendance(AttendanceDTO dto)throws Exception;
    public boolean deleteAttendance(String id)throws Exception;


    public ArrayList<AttendanceDTO> getAttendance(String id)throws Exception;

    public ArrayList<AttendanceDTO> getAllAttendances()throws Exception;

    char[] checkAbsentStudent();

    List<AttendanceDTO> getAllAttendance(String valueOf);
}
