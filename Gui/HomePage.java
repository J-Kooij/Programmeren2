package Programmeren2.Gui;

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

public class HomePage {

    public static void showHomePage(Stage window){
        BorderPane layout = new BorderPane();
            layout.setPrefSize(500, 200);
            layout.setPadding(new Insets(10));

        VBox mLayout = new VBox();
            mLayout.setAlignment(Pos.CENTER);

            Label welcome = new Label("Welcome");
            welcome.setFont(new Font("Arial", 30));
            mLayout.setMargin(welcome, new Insets(0, 0, 50, 0));

            HBox buttons = new HBox();
                buttons.setAlignment(Pos.CENTER);
                buttons.setSpacing(10);

                Button vStudentButton = new Button("View Students");
                Button vCoursesButton = new Button("View Courses");
                // Button test = new Button("test");

                buttons.getChildren().addAll(vStudentButton, vCoursesButton);
            mLayout.getChildren().addAll(welcome, buttons);
        layout.setCenter(mLayout);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        
    }
    
}
