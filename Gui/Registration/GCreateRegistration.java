package Programmeren2.Gui.Registration;

import javafx.stage.Stage;

import java.util.List;

import Programmeren2.Database.DBCourse;
import Programmeren2.Database.DBRegister;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Registration;
import Programmeren2.Domain.Student;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GCreateRegistration {
    public static void showWindow(Stage window, Student student) {
        DBRegister dbRegister = new DBRegister();
        VBox vBox = new VBox();
        Label title = new Label("Sign" + student.getName() + "in for a course");
        Label email = new Label("Email: " + student.getEmail());
        ChoiceBox<String> courseChoice = new ChoiceBox<>();

        DBCourse dbCourse = new DBCourse();
        List<Course> courses = dbCourse.getCourses();
        for (Course c : courses) {
            courseChoice.getItems().add(c.getCourseName());
        }

        Button signIn = new Button("Save & Sign student in");
        signIn.setStyle(
                "-fx-background-color: #0495bd; -fx-text-fill: white; -fx-font-size:17; -fx-font-weight: bold");

        signIn.setOnAction((event) ->{
            Registration newRegistration = new Registration(  new java.sql.Date(System.currentTimeMillis())  , dbCourse.getCourse(courseChoice.getValue()), student);
            dbRegister.createRegistration(newRegistration);
            GRegistration.showWindow(window, student);
        });
                vBox.getChildren().addAll(title, email, courseChoice, signIn);
        Scene scene = new Scene(vBox, 500, 300);
        window.setScene(scene);
    }
}