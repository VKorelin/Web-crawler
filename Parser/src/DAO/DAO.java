package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    String db_connect_string = "jdbc:jtds:sqlserver://localhost:1433/WWW";
    String db_userid = "";
    String db_password = "";
    
    public DAO(){
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
    db_connect_string, db_userid, db_password);
            System.out.println("connected");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //Add document to DB
    public void CreateDocument(Document d) throws SQLException{
        if (conn == null) {
                System.out.println("No connection!");
                System.exit(0);
        }
        
        String query = "";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
    }
    
    
}
