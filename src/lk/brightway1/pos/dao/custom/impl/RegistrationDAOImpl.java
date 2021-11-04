package lk.brightway1.pos.dao.custom.impl;


import lk.brightway1.pos.dao.CrudUtil;
import lk.brightway1.pos.dao.custom.RegistrationDAO;
import lk.brightway1.pos.entity.Registration;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public String getLastRegNo() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Registration ORDER BY RegNo DESC LIMIT 1");
        if (!rst.next()) {
            return null;
        } else {
            return rst.getString(1);
        }
    }

    @Override
    public boolean save(Registration registration) throws Exception {
        return   CrudUtil.execute("Insert Into Registration Values(?,?,?,?,?)",registration.getRegNO(),registration.getRegDate(),registration.getStudentID(),registration.getCourseCode(),registration.getRegFee());
    }

    @Override
    public boolean update(Registration registration) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String regNo) throws Exception {

       return CrudUtil.execute("Delete from Registration where RegistrationNo=?",regNo);
    }

    @Override
    public Registration get(String regNo) throws Exception {
        ResultSet rst= CrudUtil.execute("SELECT * FROM Registration WHERE RegNo?",regNo);

        if(rst.next()){
            return new Registration(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getDouble(5));

        }return null;
    }

    @Override
    public List<Registration> getAll() throws Exception {
        ArrayList RegistrationList = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * from Registration");
        while (rst.next()) {
            RegistrationList.add(new Registration(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getDouble(5)));

        }
        return RegistrationList;
    }

    @Override
    public Registration Search(String regNo) throws Exception {
        return null;
    }

    @Override
    public Registration find(String key) throws Exception {
        return null;
    }
}
