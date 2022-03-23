package Programmeren2.Database;

import java.sql.PreparedStatement;

import Programmeren2.Domain.Course;

public class DBCourse extends Database{

    public DBCourse(){
        super();
    }

    public void createCourse(Course course){

        // Create prepared statement
        String query = "INSERT INTO Course VALUES(?, ?, ?, ?)";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
            // Set data in prepared statement
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getSubject());
            stmt.setString(3, course.getIntroductionText());
            stmt.setString(4, course.getDifficulty());
            // Execute statement
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.format("Error while creating Course (createCourse): %s", e.toString());
        }


    }
}
