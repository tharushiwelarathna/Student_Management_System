package lk.brightway1.pos.bo.custom.impl;

import lk.brightway1.pos.bo.custom.CourseBO;
import lk.brightway1.pos.dao.DAOFactory;
import lk.brightway1.pos.dao.custom.CourseDAO;
import lk.brightway1.pos.dto.CourseDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.entity.Course;
import lk.brightway1.pos.entity.Student;


import java.util.ArrayList;
import java.util.List;


public class CourseBOImpl implements CourseBO {
    private CourseDAO dao= DAOFactory.getInstance().getDAO(DAOFactory.DAOType.COURSE);




    @Override
    public ArrayList<CourseDTO> getAllCourses() throws Exception {

        List<Course> cList=dao.getAll();
        ArrayList<CourseDTO> dtoList= new ArrayList();
        for (Course c : cList) {
            dtoList.add(new CourseDTO(c.getCourseCode(),c.getCourseName(),c.getCourseType(),c.getDeuration(),
                    c.getCourseFee()));

        }
        return dtoList;
    }

    @Override
    public CourseDTO Search(String code) throws Exception {
        Course course = dao.Search(code);
        return new CourseDTO(course.getCourseCode(),course.getCourseName(),course.getCourseType(),course.getDeuration(),course.getCourseFee());
    }


    @Override
    public String getNewCourseCode() throws Exception {
        String lastCourseCode = dao.getLastCourseCode();

        if (lastCourseCode == null) {
            return "C001";
        } else {
            int maxId = Integer.parseInt(lastCourseCode.replace("C", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "C00" + maxId;
            } else if (maxId < 100) {
                id = "C0" + maxId;
            } else {
                id = "C" + maxId;
            }
            return id;
        }
    }

    @Override
    public boolean saveCourse(CourseDTO dto) throws Exception {
        return dao.save(new Course(dto.getCode(),dto.getCourseName(),dto.getCourseType(),dto.getDeuration(),
                dto.getCourseFee()));
    }


    @Override
    public boolean updateCourse(CourseDTO dto) throws Exception {
        return dao.update(new Course(dto.getCode(),dto.getCourseName(),dto.getCourseType(),dto.getDeuration(),
                dto.getCourseFee()));
    }

    @Override
    public boolean deleteCourse(String courseCode) throws Exception {
        return dao.delete(courseCode);
    }

    @Override
    public CourseDTO getCourse(String courseCode) throws Exception {
        Course c=dao.get(courseCode);
        return new CourseDTO(c.getCourseCode(),c.getCourseName(),c.getCourseType(),c.getDeuration(),c.getCourseFee());
    }


}
