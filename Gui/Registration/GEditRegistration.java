package Programmeren2.Gui.Registration;

import javafx.stage.Stage;
import Programmeren2.Domain.Student;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GEditRegistration {
    public static void showWindow(Stage window, Student student) {
        VBox vBox = new VBox();
        Label title = new Label("Sign" + student.getName() + "in for a course");
        Label email = new Label("Email: " + student.getEmail());
        ChoiceBox<String> courseChoice = new ChoiceBox<>();
        // Moet loop komen die alle courses add vanuit arraylist
        // niet vergeten type naar Course veranderen
        courseChoice.getItems().add("TestCourse1");
        courseChoice.getItems().add("TestCourse2");
        courseChoice.getItems().add("TestCourse3");

        Button signIn = new Button("Save & Sign student in");
        signIn.setStyle(
                "-fx-background-color: #0495bd; -fx-text-fill: white; -fx-font-size:17; -fx-font-weight: bold");

        vBox.getChildren().addAll(title, email, courseChoice, signIn);
    }
}