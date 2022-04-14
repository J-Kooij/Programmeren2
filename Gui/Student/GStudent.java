package Programmeren2.Gui.Student;

import Programmeren2.Gui.Gui;
import Programmeren2.Gui.Course.GCourse;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GStudent {
    public static void showWindow(Stage window) {
        window.setTitle("CodeCademy | Students");
        BorderPane Layout = new BorderPane();
        Label label1 = new Label("test");

        Layout.getChildren().addAll(label1);

        //Setting layout for buttons at bottom
        HBox lHBox = new HBox();
        Layout.setBottom(lHBox);
        Button backButton = new Button("< Back");
        backButton.setOnAction(e -> {GCourse.showWindow(window);;});
        Button createButton = new Button("Create");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        
        lHBox.setSpacing(10);
        lHBox.getChildren().addAll(backButton, createButton, editButton, deleteButton);
        Scene scene = new Scene(Layout, 500, 250);
        window.setScene(scene);
    }
}