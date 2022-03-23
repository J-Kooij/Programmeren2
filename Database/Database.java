package Programmeren2.Database;

import java.sql.*;

/**
 * Dit is een voorbeeld Java toepassing waarin je verbinding maakt met een SQLServer database.
 */
public class Database {

    // public void getConnection() {
        public static void main(String[] args) {
        
        
        //initialize connection with database
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=ccdatabase;integratedSecurity=true;";

        Connection connection = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("connected!");
    
        }
        catch (Exception e) {
            System.out.println("Could not connect to database.");
            e.printStackTrace();
        }

        finally {
            if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }
}