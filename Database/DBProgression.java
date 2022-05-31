package Programmeren2.Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Programmeren2.Domain.ContentItem;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Progression;
import Programmeren2.Domain.Speaker;
import Programmeren2.Domain.Status;
import Programmeren2.Domain.Student;
import Programmeren2.Domain.Webcast;

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
            for (int i = 0; i < contentItems.size(); i++) {
                while (results.next()) {
                    int percentage = results.getInt("Progression");
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

    // public List<Progression> getProgressions(Course course) {
    // List<Progression> progressions = new ArrayList<>();

    // String query = "SELECT * FROM ContentStudent";
    // try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
    // stmt.setString(1, student.getEmail());
    // ResultSet results = stmt.executeQuery();

    // List<ContentItem> contentItems = new ArrayList<>();
    // contentItems.addAll(dbContentItem.getModules(course));
    // for (int i = 0; i < contentItems.size(); i++) {
    // while (results.next()) {
    // int percentage = results.getInt("Progression");
    // // ContentItem contentItem =
    // // getContentItemW(progression.getContentItem().getContentItemId());
    // ContentItem contentItem = contentItems.get(i);
    // Progression progress = new Progression(student, contentItem, percentage);
    // progressions.add(progress);
    // }

    // }

    // System.out.print("[DBProgression]: Succesfull getting ");
    // } catch (Exception e) {
    // System.out.print("[DBProgression]: Error getting : " + e.toString());
    // }

    // return progressions;
    // }

    public List<Progression> getTopThreeWebcasts() {

        String query = "SELECT * From Webcast INNER JOIN ContentItem ON ContentItem.ContentItemId = Webcast.ContentItemId INNER JOIN ContentStudent ON ContentStudent.ContentItemId = ContentItem.ContentItemId INNER JOIN Speaker ON Speaker.Speaker = Webcast.Speaker ORDER BY Progression DESC";
        try (PreparedStatement stmt = super.connection.prepareStatement(query)) {
            ResultSet results = stmt.executeQuery();

            List<Webcast> webcasts = new ArrayList<>();
            List<Progression> progressions = new ArrayList<>();

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
                int percentage = results.getInt("Progression");

                Speaker speaker = new Speaker(speakerName, SpeakerOrganisation);

                Webcast webcast = new Webcast(contentItemId, publicationDate, title, description, status, speaker,
                        length, url);
                webcasts.add(webcast);

                Progression progression = new Progression(webcast, percentage);
                progressions.add(progression);
            }
            return progressions;
        } catch (Exception e) {
            System.out.print("[DBProgression]: Error getting  : " + e.toString());
        }
        return null;

    }

}
