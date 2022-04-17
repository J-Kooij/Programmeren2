package Programmeren2.Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Programmeren2.Domain.ContactPerson;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Module;
import Programmeren2.Domain.Speaker;
import Programmeren2.Domain.Status;
import Programmeren2.Domain.Webcast;

public class DBContentItem extends Database {

    public DBContentItem() {
        super();
    }

    // Method get all modules from specific course
    public List<Module> getModules(Course course) {

        List<Module> modules = new ArrayList<>();
        String query = "SELECT * FROM Module INNER JOIN ContentItem ON Module.ContentItemId = ContentItem.ContentItemId INNER JOIN ContactPerson ON ContactPerson.Name = Module.ContactPerson WHERE ContentItem.CourseName = ?";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
            stmt.setString(1, course.getCourseName());
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                int contentItemId = results.getInt("ContentItemId");
                Date publicationDate = results.getDate("PublicationDate");
                int moduleVersion = results.getInt("Version");
                String title = results.getString("Title");
                String description = results.getString("description");
                Status status = Status.convertToStatus(results.getString("Status"));
                String contactPersonName = results.getString("Name");
                String contactPersonEmail = results.getString("Email");

                ContactPerson contactPerson = new ContactPerson(contactPersonName, contactPersonEmail);

                Module module = new Module(contentItemId, publicationDate, title, description, status, moduleVersion, contactPerson);
                modules.add(module);


            }
            System.out.print("[DbContentItem]: Succesfull getting all modules ");
        } catch (Exception e) {
            System.out.print("[DbContentItem]: Error getting all modules: " + e.toString());
        }
        return modules;
    }

        // Method get all webcast from specific course
        public List<Webcast> getWebcasts(Course course) {
        
            List<Webcast> webcasts = new ArrayList<>();
            String query = "SELECT * FROM Webcast INNER JOIN ContentItem ON Webcast.ContentItemId = ContentItem.ContentItemId INNER JOIN Speaker ON Speaker.Speaker = Webcast.Speaker WHERE ContentItem.CourseName = ? ";
            try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
                stmt.setString(1, course.getCourseName());
                ResultSet results = stmt.executeQuery();
    
                while (results.next()) {
                    int contentItemId = results.getInt("ContentItemId");
                    Date publicationDate = results.getDate("PublicationDate");
                    String title = results.getString("Title");
                    String description = results.getString("Description");
                    Status status = Status.convertToStatus(results.getString("Status"));
                    String speakerName = results.getString("Speaker");
                    String SpeakerOrganisation = results.getString("Organisation");
                    String url = results.getString("URL");
                    int length = results.getInt("LengthInMinutes");
    
                    Speaker speaker = new Speaker(speakerName, SpeakerOrganisation);

                    Webcast webcast = new Webcast(contentItemId, publicationDate, title, description, status, speaker, length, url);
                    webcasts.add(webcast);

                }
                System.out.print("[DbContentItem]: Succesfull getting all webcasts ");
            } catch (Exception e) {
                System.out.print("[DbContentItem]: Error getting all webcasts: " + e.toString());
            }
            return webcasts;
        }
}
