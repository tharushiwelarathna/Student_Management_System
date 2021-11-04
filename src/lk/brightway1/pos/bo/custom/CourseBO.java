package lk.brightway1.pos.bo.custom;

import lk.brightway1.pos.bo.SuperBO;
import lk.brightway1.pos.dto.CourseDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.view.tm.CourseTM;

import java.util.ArrayList;
import java.util.List;

public interface CourseBO  {
    public String getNewCourseCode() throws Exception;
    public boolean saveCourse(CourseDTO dto)throws Exception;
    public boolean updateCourse(CourseDTO dto)throws Exception;
    public boolean deleteCourse(String code)throws Exception;
    public CourseDTO getCourse(String code)throws Exception;
    public ArrayList<CourseDTO> getAllCourses()throws Exception;
    public CourseDTO Search(String code)throws Exception;
}

