package lk.brightway1.pos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   /* private static DBConnection dbConnection;
    private Connection connection;

    */

    /*private DBConnection()throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Brightway1","root","1234");

    }
    public static DBConnection getInstance()throws SQLException,ClassNotFoundException{
        return (null==dbConnection)?(dbConnection=new DBConnection()):(dbConnection);
    }
    public Connection getConnection(){return connection;}

     */
    /*
    private   DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BrightwayInstitute", "root", "1234");
        } catch (ClassNotFoundException | SQLException ex) {


        }

    }
    public static DBConnection getInstance(){
        return dbConnection==null?dbConnection=new DBConnection():dbConnection;
    }
    public Connection getConnection(){
        return connection;

     */
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BrightwayInstitute", "root", "1234");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {

        return (dbConnection==null)?(dbConnection= new DBConnection()):(dbConnection);
    }

    public Connection getConnection(){
        return connection;
    }
    }


