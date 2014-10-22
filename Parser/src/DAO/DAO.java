package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    private static DAO instance = new DAO();
    private Connection connection = null;
    public static final String URL = "jdbc:sqlserver:\\MYPC\\SQLEXPRESS; databaseName = Reuters";
    public static final String USER = "administrator";
    public static final String PASSWORD = "admin";
    public static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public DAO() { //Step 1: Load driver
        try {
            Class.forName(DRIVER_CLASS);
            System.out.println("Successful: Driver has found");
        }
        catch (ClassNotFoundException ignore) {
            System.out.println("Error: Driver has not found");
        }
    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            //Step 2: Establish Java MSSQLServer connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Successful: Connected to Database.");
        }
        catch (SQLException ignore) {
            System.out.println("Error: Unable to Connect to Database.");
        }
        return conn;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

    public void close() {
        try {
            instance.close();
        }
        catch (Exception ignore) {
            System.out.println("Connection has not closed");
        }
    }

}
