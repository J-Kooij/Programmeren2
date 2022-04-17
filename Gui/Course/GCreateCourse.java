package Programmeren2.Gui.Course;

import Programmeren2.Database.DBCourse;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Difficulty;
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

        layout.setCenter(mLayout);

        Label welcome = new Label("Create Course");
        welcome.setFont(new Font("Arial", 30));


        //Course name
        Label name = new Label("Name:... ");
        TextField nameTextField = new TextField();

        //Subject
        Label subject = new Label("Subject:...");
        TextField subjectTextField = new TextField();

        //Introduction text
        Label introTxt = new Label("Introduction text:...");
        TextArea introTxtTA = new TextArea();

        //Course difficulty 
        Label difficulty = new Label("Difficulty:...");
        ComboBox<String> diffCombobox = new ComboBox<>();
        diffCombobox.getItems().add(Difficulty.BEGINNER.getValue());
        diffCombobox.getItems().add(Difficulty.INTERMEDIATE.getValue());
        diffCombobox.getItems().add(Difficulty.EXPERT.getValue());


        
        //Create button
        Button button = new Button("Create");
        mLayout.setMargin(button, new Insets(10,0,10,0));

        //Button action on click
        button.setOnAction((event) -> {
            String contentName = nameTextField.getText();
            String contentSubject =subjectTextField.getText();
            String contentIntroTxt = introTxtTA.getText();
            Difficulty contentComboBox = Difficulty.convertToDiff(diffCombobox.getValue());

            Course course = new Course(contentName, contentSubject, contentIntroTxt, contentComboBox);
            DBCourse db = new DBCourse();
            db.createCourse(course);
        });

        mLayout.getChildren().addAll(welcome, name, nameTextField, subject, subjectTextField, introTxt, introTxtTA, difficulty, diffCombobox, button);
        //Show HomePage
        Scene scene = new Scene(layout);
        window.setScene(scene);
    }
}
