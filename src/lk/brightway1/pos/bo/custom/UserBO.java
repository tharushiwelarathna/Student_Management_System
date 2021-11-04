package lk.brightway1.pos.bo.custom;


import lk.brightway1.pos.dto.UserDTO;

import java.util.ArrayList;

public interface UserBO {
    public UserDTO Search(String id)throws Exception;

    public boolean saveUser(UserDTO dto)throws Exception;
    public  boolean updateUser(UserDTO dto)throws Exception;
    public boolean deleteUser(String id)throws Exception;
    public UserDTO getUser(String id)throws Exception;
    public ArrayList<UserDTO> getAllUsers()throws Exception;
    public String getNewUserId() throws Exception;

}
