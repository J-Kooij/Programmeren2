package Programmeren2.Gui.Course;

import Programmeren2.Domain.Student;
import Programmeren2.Gui.Course.Course;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GCreateCourse {

    public static void showWindow(Stage window) {

        window.setTitle("CodeCademy by Jonah[2191148]&Tony[2182138]");
        BorderPane layout = new BorderPane();
        layout.setPrefSize(500, 200);
        layout.setPadding(new Insets(10));

        VBox mLayout = new VBox();
        mLayout.setAlignment(Pos.CENTER);

        Label welcome = new Label("Create Course");
        welcome.setFont(new Font("Arial", 45));
        mLayout.setMargin(welcome, new Insets(0, 0, 50, 0));

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        // Button vStudentButton = new Button("View Students");
        // Button vCoursesButton = new Button("View Courses");

        buttons.getChildren().addAll(vStudentButton, vCoursesButton);
        mLayout.getChildren().addAll(welcome, buttons);
        layout.setCenter(mLayout);

        //Show HomePage
        Scene scene = new Scene(layout);
        window.setScene(scene);
    }

}
