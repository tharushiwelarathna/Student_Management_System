package lk.brightway1.pos.bo.custom;

import lk.brightway1.pos.dto.RegistrationDTO;
import lk.brightway1.pos.dto.StudentDTO;
import rex.utils.S;

import java.util.ArrayList;
import java.util.List;

public interface RegistrationBO {

     //public String getFullRegisterCount() throws Exception;


    public int getFullRegisterCount()throws Exception;


    boolean saveRegistration(RegistrationDTO registrationDTO) throws Exception;

   public boolean updateRegistration(RegistrationDTO dto)throws Exception;
    public boolean deleteRegistration(String regNo)throws Exception;
    public RegistrationDTO getRegistration(String regNo)throws Exception;
    public ArrayList<RegistrationDTO> getAllRegistrations()throws Exception;


    String getNewRegNo() throws Exception;

}
