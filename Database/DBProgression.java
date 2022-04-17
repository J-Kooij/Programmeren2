package Programmeren2.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Programmeren2.Domain.ContentItem;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Progression;
import Programmeren2.Domain.Student;

public class DBProgression extends Database {
    DBContentItem dbContentItem = new DBContentItem();
    public DBProgression() {
        super();
        
    }

    public List<Progression> getProgression(Student student, Course course){
        List<Progression> progressions = new ArrayList<>();

        String query = "SELECT * FROM ContentStudent WHERE Email = ?";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)){
            stmt.setString(1, student.getEmail());
            ResultSet results = stmt.executeQuery();

            while(results.next()){
                String name = results.getString("CourseName");
                String subject = results.getString("Subject");
                String introductionText = results.getString("IntroductionText");
                Difficulty difficulty = Difficulty.convertToDiff(results.getString("Difficulty")); ;

                ContentItem contentItem = dbContentItem.getModules(course);

                Progression progression = new Progression(student, contentItem, percentage)
            }
        
            System.out.print("[DbCourse]: Succesfull getting specific courses ");
        } catch (Exception e) {
            System.out.print("[DbCourse]: Error getting specific courses: " + e.toString());
        }
    

        return progressions;
    }
    
}
