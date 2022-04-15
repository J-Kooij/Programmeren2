package Programmeren2.Database;

import java.sql.PreparedStatement;

import Programmeren2.Domain.Registration;

public class DBRegister extends Database{

    public DBRegister() {
        super();
    }
    
    public void createRegistration(Registration registration) {

        String query = "INSERT INTO Register VALUES(?, ?, ?)";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {

            stmt.setDate(1,  new java.sql.Date(registration.getRegistrationDate().getTime()));
            stmt.setString(2, registration.getCourse().getCourseName());
            stmt.setString(3, registration.getStudent().getEmail());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.print("[DBRegister]: Error creating registration "+ e.toString());
        }
    }

    public void viewRegistration() {

    }

    public void updateRegistration() {

    }

    public void deleteRegistration() {

    }
}
