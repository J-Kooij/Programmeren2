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

    public List<Progression> getProgression(Student student, Course course) {
        List<Progression> progressions = new ArrayList<>();

        String query = "SELECT * FROM ContentStudent WHERE Email = ?";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
            stmt.setString(1, student.getEmail());
            ResultSet results = stmt.executeQuery();

            List<ContentItem> contentItems = new ArrayList<>();
            contentItems.addAll(dbContentItem.getModules(course));
            for (int i = 0; i< contentItems.size() ; i++){
            while (results.next()) {
                    int percentage = results.getInt("Progression");
                    // ContentItem contentItem = getContentItemW(progression.getContentItem().getContentItemId());
                    ContentItem contentItem = contentItems.get(i);
                    Progression progress = new Progression(student, contentItem, percentage);
                    progressions.add(progress);
                }
                                
            }

            System.out.print("[DBProgression]: Succesfull getting   ");
        } catch (Exception e) {
            System.out.print("[DBProgression]: Error getting  : " + e.toString());
        }

        return progressions;
    }

    
    // public ContentItem getContentItemW(int id) {
    //     String query = "SELECT * FROM Webcast INNER JOIN ContentItem ON Webcast.ContentItemId = ContentItem.ContentItemId INNER JOIN Speaker ON Speaker.Speaker = Webcast.Speaker WHERE ContentItemId = ? ";
    //     try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
    //         stmt.setInt(1, id);
    //         ResultSet results = stmt.executeQuery();

                

    //         System.out.print("[DbCourse]: Succesfull getting  ");
    //     } catch (Exception e) {
    //         System.out.print("[DbCourse]: Error getting  " + e.toString());
    //     }

    //     return contentItem;
    // }

}
