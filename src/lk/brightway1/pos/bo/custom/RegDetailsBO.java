package lk.brightway1.pos.bo.custom;

import lk.brightway1.pos.dto.RegDetailsDTO;

import java.util.ArrayList;

public interface RegDetailsBO {
    public boolean save(RegDetailsDTO dto, ArrayList<RegDetailsDTO> regDetails)throws Exception;
    public  boolean update(RegDetailsDTO dto)throws Exception;
    public boolean delete(String id)throws Exception;
    public RegDetailsDTO get(String id)throws Exception;
    public ArrayList<RegDetailsDTO> getAll()throws Exception;
    ArrayList<String> get();

}
