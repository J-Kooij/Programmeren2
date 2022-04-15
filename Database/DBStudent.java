package Programmeren2.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Programmeren2.Domain.Gender;
import Programmeren2.Domain.Student;

public class DBStudent extends Database {

    public DBStudent() {
        super();
    }
    //Method to get all students
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        String query = "SELECT * FROM Student";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                String email = results.getString("Email");
                String name = results.getString("Name");
                Gender gender = Gender.convertToGender(results.getString("Gender"));
                String birthDate = results.getString("BirthDate");
                String address = results.getString("Address");
                String city = results.getString("city");
                String country = results.getString("Country");

                Student student = new Student(name, email, gender, birthDate, address, city, country);
                students.add(student);
            }
            System.out.print("[Db]: Succesfull getting all courses ");
        } catch (Exception e) {
            System.out.print("[DbCourse]: Error getting all courses: " + e.toString());
        }
        return students;
    }

}
