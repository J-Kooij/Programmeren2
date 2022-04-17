package Programmeren2.Gui;

import Programmeren2.Gui.Course.GCourse;
import Programmeren2.Gui.Overview.GWebcastStatistics;
import Programmeren2.Gui.Student.GStudent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage scene) throws Exception {
        // Show HomePage
        showWindow(scene);
        scene.show();

    }

    public static void showWindow(Stage window) throws Exception {

        // HomePagelayout-------------------------------------------------------------------
        window.setTitle("CodeCademy by Jonah[2191148]&Tony[2182138]");
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));

        VBox mLayout = new VBox();
        mLayout.setAlignment(Pos.CENTER);

        Label welcome = new Label("Welcome to Codecademy!");
        welcome.setFont(new Font("Arial", 30));
        mLayout.setMargin(welcome, new Insets(0, 0, 50, 0));

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        Button vStudentButton = new Button("View Students");
        vStudentButton.setStyle(
                "-fx-background-color: #0495bd; -fx-text-fill: white; -fx-font-size:17; -fx-font-weight: bold");
        Button vCoursesButton = new Button("View Courses");
        vCoursesButton.setStyle(
                "-fx-background-color: #0495bd; -fx-text-fill: white; -fx-font-size:17; -fx-font-weight: bold");
        Button vLatestStatistics = new Button("View Overview");
        vLatestStatistics.setStyle(
                "-fx-background-color: #0495bd; -fx-text-fill: white; -fx-font-size:17; -fx-font-weight: bold");

        buttons.getChildren().addAll(vStudentButton, vCoursesButton, vLatestStatistics);
        mLayout.getChildren().addAll(welcome, buttons);
        layout.setCenter(mLayout);

        vCoursesButton.setOnAction((event) -> {
            GCourse.showWindow(window);
        });

        vStudentButton.setOnAction(e -> {
            GStudent.showWindow(window);
        });

        vLatestStatistics.setOnAction(e -> {
            GWebcastStatistics.showWindow(window);
        });
        Scene scene = new Scene(layout, 550, 250);
        window.setScene(scene);

    }
}