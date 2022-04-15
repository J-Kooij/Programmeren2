package Programmeren2.Database;

import java.sql.*;

/**
 * Dit is een voorbeeld Java toepassing waarin je verbinding maakt met een SQLServer database.
 */
public class Database {
    protected Connection connection;

    //initialize connection with database
    public Database() {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=ccdatabase;integratedSecurity=true;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            this.connection = DriverManager.getConnection(connectionUrl);
      
            System.out.println("[Database]: Successful connected to database.");

        } catch (Exception e) {
            System.out.println("[Database]: Could not connect to database: "+e.toString());
            e.printStackTrace();
        } 
    }
}