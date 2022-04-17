package Programmeren2.Gui.Registration;

import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;
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

public class GEditRegistration {
    public static void showWindow(Stage window, Registration registration) {
        VBox vBox = new VBox();
        Label title = new Label("Sign" + registration.getStudent().getName() + "in for a course");
        Label email = new Label("Email: " + registration.getStudent().getEmail());
        ChoiceBox<String> courseChoice = new ChoiceBox<>();
        courseChoice.setValue(registration.getCourse().getCourseName());
        // Moet loop komen die alle courses add vanuit arraylist
        // niet vergeten type naar Course veranderen
        DBCourse dbCourse = new DBCourse();
        List<Course> courses = dbCourse.getCourses();
        for(Course c: courses){
            courseChoice.getItems().add(c.getCourseName());
        }



        Button signIn = new Button("Save & Sign student in");
        signIn.setStyle("-fx-background-color: #0495bd; -fx-text-fill: white; -fx-font-size:17; -fx-font-weight: bold");
        DBRegister dbRegister = new DBRegister();

        LocalDate currentDate = java.time.LocalDate.now();
        Date Date =java.sql.Date.valueOf(currentDate);
        signIn.setOnAction((event) -> { 
            Registration edittedRegistration = new Registration(Date, dbCourse.getCourse(courseChoice.getValue()), registration.getStudent(), registration.getRegistrationId());
            	dbRegister.editRegistration(edittedRegistration);
                GRegistration.showWindow(window, registration.getStudent());
        });

        vBox.getChildren().addAll(title, email, courseChoice, signIn);

        Scene scene = new Scene(vBox, 500, 300);
        window.setScene(scene);


    }
}