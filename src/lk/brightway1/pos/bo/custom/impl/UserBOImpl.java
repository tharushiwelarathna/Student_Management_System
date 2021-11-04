package lk.brightway1.pos.bo.custom.impl;

import lk.brightway1.pos.bo.custom.UserBO;
import lk.brightway1.pos.dao.DAOFactory;
import lk.brightway1.pos.dao.custom.TeacherDAO;
import lk.brightway1.pos.dao.custom.UserDAO;
import lk.brightway1.pos.dto.TeacherDTO;
import lk.brightway1.pos.dto.UserDTO;
import lk.brightway1.pos.entity.Teacher;
import lk.brightway1.pos.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOType.USER);

    @Override
    public UserDTO Search(String id) throws Exception {
        return null;
    }

    @Override
    public boolean saveUser(UserDTO dto) throws Exception {
        return userDAO.save(new User(dto.getUserId(),dto.getUserName(),
                dto.getPassword(),dto.getRoll()));

    }

    @Override
    public boolean updateUser(UserDTO dto) throws Exception {
        return userDAO.update(new User(dto.getUserId(),dto.getUserName(),
                dto.getPassword(),dto.getRoll()));
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return userDAO.delete(id);
    }

    @Override
    public UserDTO getUser(String id) throws Exception {
        User user=userDAO.get(id);
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getRoll());

    }

    @Override
    public ArrayList<UserDTO> getAllUsers() throws Exception {
        List<User> TList=userDAO.getAll();
        ArrayList<UserDTO> dtoList= new ArrayList();
        for (User user: TList) {
            dtoList.add(new UserDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user.getPassword(),
                    user.getRoll()
            ));
        }
        return dtoList;
    }

    @Override
    public String getNewUserId() throws Exception {
        String lastUserId = userDAO.getLastUserId();

        if (lastUserId  == null) {
            return "U001";
        } else {
            int maxId = Integer.parseInt(lastUserId .replace("U", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "U00" + maxId;
            } else if (maxId < 100) {
                id = "U0" + maxId;
            } else {
                id = "U" + maxId;
            }
            return id;
        }
    }
}
