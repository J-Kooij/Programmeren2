package Programmeren2.Database.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Programmeren2.Database.Database;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Difficulty;

public class DBCourse extends Database {

    public DBCourse() {
        super();
    }

    //Method to create a course
    public void createCourse(Course course) {

        String query = "INSERT INTO Course VALUES(?, ?, ?, ?)";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {

            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getSubject());
            stmt.setString(3, course.getIntroductionText());
            stmt.setString(4, course.getDifficulty().getValue());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.print("[DbCourse]: Error creating course");
        }
    }

    //Method to get all courses
    public List<Course> getCourses(){

        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM Course";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)){
            ResultSet results = stmt.executeQuery();

            while(results.next()){
                String courseName = results.getString("CourseName");
                String subject = results.getString("Subject");
                String introductionText = results.getString("IntroductionText");
                Difficulty difficulty = Difficulty.convertToDiff(results.getString("Difficulty")); ;


                Course course = new Course(courseName, subject, introductionText, difficulty);
                courses.add(course);
            }
            System.out.print("[DbCourse]: Succesfull getting all courses ");
        } catch (Exception e) {
            System.out.print("[DbCourse]: Error getting all courses: " + e.toString());
        }
        return courses;
    }


}
