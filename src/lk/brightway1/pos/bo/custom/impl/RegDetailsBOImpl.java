package lk.brightway1.pos.bo.custom.impl;

import lk.brightway1.pos.bo.custom.RegDetailsBO;
import lk.brightway1.pos.dao.DAOFactory;
import lk.brightway1.pos.dao.custom.QueryDAO;
import lk.brightway1.pos.dao.custom.RegDetailsDAO;
import lk.brightway1.pos.dto.RegDetailsDTO;
import lk.brightway1.pos.entity.RegDetails;

import java.util.ArrayList;

public class RegDetailsBOImpl implements RegDetailsBO {
    private RegDetailsDAO regDetailsDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOType.REG_DETAILS);


    QueryDAO qDao = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QUERY);
    @Override
    public boolean save(RegDetailsDTO dto, ArrayList<RegDetailsDTO> regDetails) throws Exception {
        return regDetailsDAO.save(new RegDetails(dto.getCourseCode(),
                dto.getDeuration(),
                dto.getCourseFee(),
                dto.getRegFee(),
                dto.getTotal()));

    }

    @Override
    public boolean update(RegDetailsDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public RegDetailsDTO get(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegDetailsDTO> getAll() throws Exception {
        return null;
    }

    @Override
    public ArrayList<String> get() {
        return null;
    }
}
