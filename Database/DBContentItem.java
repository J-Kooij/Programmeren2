package Programmeren2.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Programmeren2.Domain.ContactPerson;
import Programmeren2.Domain.ContentItem;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Module;
import Programmeren2.Domain.Speaker;
import Programmeren2.Domain.Webcast;

public class DBContentItem extends Database {

    public DBContentItem() {
        super();
    }

    // Method get all contentItem
    // public List<ContentItem> getContentItems() {

    //     List<ContentItem> contentItems = new ArrayList<>();
    //     contentItems.addAll(getModules());
    //     contentItems.addAll(getWebcasts());
    //     return contentItems;
    // }

    // Method get all modules
    public List<Module> getModules() {

        List<Module> modules = new ArrayList<>();
        String query = "SELECT * FROM Module INNER JOIN ContentItem ON Module.ContentItemId = ContentItem.ContentItemId INNER JOIN ContactPerson ON ContactPerson.Name = Module.ContactPerson ";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                int contentItemId = results.getInt("ContentItemId");
                String publicationDate = results.getString("PublicationDate");
                int moduleVersion = results.getInt("Version");

                String contactPersonName = results.getString("Name");
                String contactPersonEmail = results.getString("Email");

                ContactPerson contactPerson = new ContactPerson(contactPersonName, contactPersonEmail);

                // Module module = new Module(contentItemId, publicationDate, title, descriptionl, status, version, contentItemId2, contactPerson);
                // modules.add(module);


            }
            System.out.print("[DbContentItem]: Succesfull getting all modules ");
        } catch (Exception e) {
            System.out.print("[DbContentItem]: Error getting all modules: " + e.toString());
        }
        return modules;
    }

        // Method get all webcast
        public List<Webcast> getWebcasts() {
        
            List<Webcast> webcasts = new ArrayList<>();
            String query = "SELECT * FROM Webcast INNER JOIN ContentItem ON Webcast.ContentItemId = ContentItem.ContentItemId INNER JOIN Speaker ON Speaker.Speaker = Webcast.Speaker ";
            try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
                ResultSet results = stmt.executeQuery();
    
                while (results.next()) {
                    int contentItemId = results.getInt("ContentItemId");
                    String publicationDate = results.getString("PublicationDate");
                    int moduleVersion = results.getInt("Version");
    
                    String speakerName = results.getString("Speaker");
                    String SpeakerOrganisation = results.getString("Organisation");
    
                    Speaker speaker = new Speaker(speakerName, SpeakerOrganisation);

                    // Webcast webcast = new Webcast(contentItemId, publicationDate, title, descriptionl, status, contentItemId2, speaker);
                    // webcasts.add(webcast);

                }
                System.out.print("[DbContentItem]: Succesfull getting all webcasts ");
            } catch (Exception e) {
                System.out.print("[DbContentItem]: Error getting all webcasts: " + e.toString());
            }
            return webcasts;
        }
}
