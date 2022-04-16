package Programmeren2.Gui.Student;

import java.util.List;

import Programmeren2.Database.DBStudent;
import Programmeren2.Domain.Student;
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
        BorderPane layout = new BorderPane();
        Label label1 = new Label("test");

        layout.getChildren().addAll(label1);

        DBStudent dbStudent = new DBStudent();
        List<Student> students = dbStudent.getStudents();
        TableView<Student> tableView = new TableView<>();
        layout.setCenter(tableView);

        TableColumn<Student, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("Name"));
        column1.prefWidthProperty().bind(tableView.widthProperty().divide(7));

        TableColumn<Student, String> column2 = new TableColumn<>("Email");
        column2.setCellValueFactory(new PropertyValueFactory<>("Email"));
        column2.prefWidthProperty().bind(tableView.widthProperty().divide(7));

        TableColumn<Student, String> column3 = new TableColumn<>("Gender");
        column3.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        column3.prefWidthProperty().bind(tableView.widthProperty().divide(7));

        TableColumn<Student, String> column4 = new TableColumn<>("Birthdate");
        column4.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
        column4.prefWidthProperty().bind(tableView.widthProperty().divide(7));

        TableColumn<Student, String> column5 = new TableColumn<>("Address");
        column5.setCellValueFactory(new PropertyValueFactory<>("Address"));
        column5.prefWidthProperty().bind(tableView.widthProperty().divide(7));

        TableColumn<Student, String> column6 = new TableColumn<>("City");
        column6.setCellValueFactory(new PropertyValueFactory<>("City"));
        column6.prefWidthProperty().bind(tableView.widthProperty().divide(7));

        TableColumn<Student, String> column7 = new TableColumn<>("Country");
        column7.setCellValueFactory(new PropertyValueFactory<>("Country"));
        column7.prefWidthProperty().bind(tableView.widthProperty().divide(7));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);

        for(Student s : students){
            tableView.getItems().add(s);
        }

        //Setting layout for buttons at bottom
        HBox lHBox = new HBox();
        layout.setBottom(lHBox);
        Button backButton = new Button("< Back");
        backButton.setOnAction(e -> {try {
            Gui.showWindow(window);
        } catch (Exception e1) {
            e1.printStackTrace();
        };});
        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {GCreateStudent.showWindow(window);});
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        
        lHBox.setSpacing(10);
        lHBox.getChildren().addAll(backButton, createButton, editButton, deleteButton);
        Scene scene = new Scene(layout, 500, 250);
        window.setScene(scene);
    }
}