package org.o7planning.tutorial.javajasperreport.conn;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class OracleConnUtils {
 
    public static Connection getOracleConnection()
            throws ClassNotFoundException, SQLException {
        String hostName = "10.232.71.29";
        String sid = "INATP02";
        String userName = "shobana";
        String password = "shobana";
 
        return getOracleConnection(hostName, sid, userName, password);
    }
 
    public static Connection getOracleConnection(String hostName, String sid,
            String userName, String password) throws ClassNotFoundException,
            SQLException {
 
      
        // Declare the class Driver for ORACLE DB
        // This is necessary with Java 5 (or older)
        // Java6 (or newer) automatically find the appropriate driver.
        // If you use Java> 5, then this line is not needed.    
        Class.forName("oracle.jdbc.OracleDriver");
 
 
        // Example: jdbc:oracle:thin:@localhost:1521:db11g
        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
 
        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}