package lk.brightway1.pos.bo.custom.impl;

import lk.brightway1.pos.bo.custom.RegistrationBO;
import lk.brightway1.pos.dao.DAOFactory;
import lk.brightway1.pos.dao.custom.QueryDAO;
import lk.brightway1.pos.dao.custom.RegistrationDAO;
import lk.brightway1.pos.dto.RegistrationDTO;
import lk.brightway1.pos.dto.StudentDTO;
import lk.brightway1.pos.entity.Registration;
import lk.brightway1.pos.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    private RegistrationDAO dao= DAOFactory.getInstance()
            .getDAO(DAOFactory.DAOType.REGISTRATION);

    QueryDAO qDao = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QUERY);

    @Override
    public int getFullRegisterCount() throws Exception {
       /* List<Registration> rList=dao.getAll();
        int regFull=0;
        for (Registration registration : rList) {
            regFull+=1;
        }
        return String.valueOf(regFull);*/
       // return QueryDAO.getFullRegisterCount();

        return qDao.getFullRegisterCount();
    }



    @Override
    public boolean saveRegistration(RegistrationDTO dto) throws Exception {
        return dao.save(new Registration(
                dto.getRegNO(),
                dto.getRegDate(),
                dto.getStudentID(),
                dto.getCourseCode(),
                dto.getRegFee()
        ));
    }

    @Override
    public boolean updateRegistration(RegistrationDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRegistration(String regNo) throws Exception {
        return false;
    }

    @Override
    public RegistrationDTO getRegistration(String regNo) throws Exception {
        Registration registration=dao.get(regNo);
        return new RegistrationDTO(
                registration.getRegNO(),
                registration.getRegDate(),
                registration.getStudentID(),
                registration.getCourseCode(),
                registration.getRegFee()
        );


    }

    @Override
    public ArrayList<RegistrationDTO> getAllRegistrations() throws Exception {
        List<Registration> rList=dao.getAll();
        ArrayList<RegistrationDTO> dtoList= new ArrayList();
        for (Registration registration : rList) {
            dtoList.add(new RegistrationDTO(registration.getRegNO(),
                    registration.getRegDate(),
                    registration.getStudentID(),
                    registration.getCourseCode(),
                    registration.getRegFee()));
        }
        return dtoList;
    }

    @Override
    public String getNewRegNo() throws Exception {
        String lastRegNo = dao.getLastRegNo();

        if (lastRegNo  == null) {
            return "R001";
        } else {
            int maxId = Integer.parseInt(lastRegNo .replace("R", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "R00" + maxId;
            } else if (maxId < 100) {
                id = "R0" + maxId;
            } else {
                id = "R" + maxId;
            }
            return id;
        }
    }

}
