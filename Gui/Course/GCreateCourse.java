package Programmeren2.Gui.Course;

import Programmeren2.Domain.Student;
import Programmeren2.Gui.Course.GCourse;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class GCreateCourse {

    public static void showWindow(Stage window) {

        window.setTitle("CodeCademy | Create Course");
        BorderPane layout = new BorderPane();
        layout.setPrefSize(500, 200);
        layout.setPadding(new Insets(10, 10, 10, 10));

        VBox mLayout = new VBox();
        mLayout.setAlignment(Pos.CENTER);

        Label welcome = new Label("Create Course");
        welcome.setFont(new Font("Arial", 45));
        layout.setCenter(mLayout);

        //Course name
        Label name = new Label("Name:... ");
        TextField nameTextField = new TextField();

        //Subject
        Label subject = new Label("Subject:...");
        TextField subjectTextField = new TextField();

        //Introduction text
        Label introTxt = new Label("Introduction text:...");
        TextArea introTxtTF = new TextArea();


        //Course difficulty 
        Label difficulty = new Label("Difficulty:...");
        ComboBox<String> diffCombobox = new ComboBox<>();
        // diffCombobox.getItems().add(Difficulty.BEGINNER.getValue());
        // diffCombobox.getItems().add(Difficulty.ADVANCED.getValue());
        // diffCombobox.getItems().add(Difficulty.EXPERT.getValue());


        mLayout.getChildren().addAll(welcome, name, nameTextField, subject, subjectTextField, introTxt, introTxtTF, difficulty, diffCombobox);
        //Show HomePage
        Scene scene = new Scene(layout);
        window.setScene(scene);
    }

}
