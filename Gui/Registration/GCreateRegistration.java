package Programmeren2.Gui.Registration;

import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import Programmeren2.Database.DBStudent;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Gender;
import Programmeren2.Domain.Student;
import Programmeren2.Gui.Gui;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.PromptData;

public class GCreateRegistration {
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