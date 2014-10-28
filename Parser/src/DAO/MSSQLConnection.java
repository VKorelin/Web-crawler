/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class MSSQLConnection {

    public Connection connection;

    public static final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS; databaseName=Reuters;";
    public static final String USER = "sa";
    public static final String PASSWORD = "55555";
    public static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public MSSQLConnection() { //Step 1: Load driver

        connection = null;

        try {
            Class.forName(DRIVER_CLASS);
            System.out.println("Successful: Driver has found");
        }
        catch (ClassNotFoundException ignore) {
            System.out.println("Error: Driver has not found");
        }
    }

    private void createMSSQLConnection() { //Step 2: Establish Java MSSQLServer connection

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Successful: Connected to Database.");
        }
        catch (SQLException ignore) {
            ignore.printStackTrace();
            System.out.println("Error: Unable to Connect to Database.");
        }
    }

    public void closeMSSQLConnection() {
        try {
            connection.close();
        }
        catch (SQLException ignore) {  //Step 3: Close Java MSSQLServer connection
            System.out.println("Connection has not closed");
        }
    }

    public Connection getMSSQLConnection() {
        return connection;
    }

}
