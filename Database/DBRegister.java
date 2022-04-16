package Programmeren2.Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Programmeren2.Domain.Course;
import Programmeren2.Domain.Registration;
import Programmeren2.Domain.Student;

public class DBRegister extends Database {

    public DBRegister() {
        super();
    }

    //Input registration into database
    public void createRegistration(Registration registration) {

        String query = "INSERT INTO Register VALUES(?, ?, ?)";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {

            stmt.setDate(1, new java.sql.Date(registration.getRegistrationDate().getTime()));
            stmt.setString(2, registration.getCourse().getCourseName());
            stmt.setString(3, registration.getStudent().getEmail());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.print("[DBRegister]: Error creating registration " + e.toString());
        }
    }

    // get Registrations from specific student
    public List<Registration> getRegistrations(Student student) {
        List<Registration> registrations = new ArrayList<>();
        DBCourse dbCourse = new DBCourse();
        String query = "SELECT* FROM Register WHERE StudentEmail = ?";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {

            stmt.setString(1, student.getEmail());
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                Date registrationDate = results.getDate("RegistrationDate");
                Course course = dbCourse.getCourse(results.getString("CourseName"));

                Registration registration = new Registration(registrationDate, course, student);
                registrations.add(registration);
            }
            stmt.executeUpdate();
            System.out.print("[DBRegister]: Succesfull getting registration ");
        } catch (Exception e) {
            System.out.print("[DBRegister]: Error getting registration " + e.toString());
        }
        return registrations;
    }

    public void updateRegistration() {

    }

    public void deleteRegistration() {

    }
}
