package lk.brightway1.pos.dao;

import lk.brightway1.pos.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
   public static <T> T execute(String sql, Object... params) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        int i = 0;
        for (Object param : params) {
            i++;
            pstm.setObject(i, param);
        }
        if (sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();     // ResultSet
        }
        return (T) ((Boolean) (pstm.executeUpdate() > 0));    // boolean
    }

   /* public static <T> T execute(String sql,Object...args) throws SQLException, ClassNotFoundException {
        PreparedStatement stm=DBConnection.getInstance()
                .getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            stm.setObject((i+1),args[i]);
        }

        if (sql.startsWith("SELECT")){
            return (T)stm.executeQuery();
        }

        return ((T)(Boolean)(stm.executeUpdate()>0));

    }*/
}
