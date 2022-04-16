package Programmeren2.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Programmeren2.Domain.Gender;
import Programmeren2.Domain.Student;

public class DBStudent extends Database{

    public DBStudent() {
        super();
    }

    //Method to get all students
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        String query = "SELECT * FROM Student";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)){
            ResultSet results = stmt.executeQuery();

            while(results.next()){
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
            System.out.print("[DBStudent]: Succesfull getting all students ");
        } catch (Exception e) {
            System.out.print("[DBStudent]: Error getting all students: " + e.toString());
        }
        return students;
    }

    //Method to get specific student
    public Student getStudent(String studentEmail){

        String query = "SELECT * FROM Student WHERE Email = ?";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)){
            stmt.setString(1, studentEmail);
            ResultSet results = stmt.executeQuery();

            while(results.next()){
                String email = results.getString("Email");
                String name = results.getString("Name");
                Gender gender = Gender.convertToGender(results.getString("Gender"));
                String birthDate = results.getString("BirthDate");
                String address = results.getString("Address");
                String city = results.getString("city");
                String country = results.getString("Country");

                Student student = new Student(name, email, gender, birthDate, address, city, country);
                return student;
            }
            System.out.print("[DBStudent]: Succesfull getting specific students ");
        } catch (Exception e) {
            System.out.print("[DBStudent]: Error getting specific students: " + e.toString());
        }
        return null;
    }

    //method to input created student in db
    public void createStudents(Student student){

        String query = "INSERT INTO Student VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)){

                stmt.setString(2, student.getName());
                stmt.setString(1, student.getEmail());
                stmt.setString(4, student.getGender().getValue());
                stmt.setString(3, student.getBirthDate());
                stmt.setString(5, student.getAddress());
                stmt.setString(6, student.getCity());
                stmt.setString(7, student.getCountry());

                stmt.executeUpdate();
            System.out.print("[DBStudent]: Succesfull created student");
        } catch (Exception e) {
            System.out.print("[DBStudent]: Error created students: " + e.toString());
        }
    }

    public void editStudents(Student student){

        String query = "UPDATE Student SET Email = ?, Name = ?, BirthDate = ?, Gender = ?, Address = ?, City = ?, Country = ? WHERE Email = ?";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)){

                stmt.setString(2, student.getName());
                stmt.setString(1, student.getEmail());
                stmt.setString(4, student.getGender().getValue());
                stmt.setString(3, student.getBirthDate());
                stmt.setString(5, student.getAddress());
                stmt.setString(6, student.getCity());
                stmt.setString(7, student.getCountry());

                stmt.setString(1, student.getEmail());

                stmt.executeUpdate();
            System.out.print("[DBStudent]: Succesfull edited student");
        } catch (Exception e) {
            System.out.print("[DBStudent]: Error edited students: " + e.toString());
        }
    }

    public void deleteStudents(String email){

        String query = "DELETE FROM Student WHERE email = ? ";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)){

                stmt.setString(1, email);

                stmt.executeUpdate();
            System.out.print("[DBStudent]: Succesfull deleted student");
        } catch (Exception e) {
            System.out.print("[DBStudent]: Error deleted students: " + e.toString());
        }
    }
    
}
