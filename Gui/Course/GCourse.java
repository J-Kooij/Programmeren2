package Programmeren2.Gui.Course;

import java.util.ArrayList;
import java.util.List;

import Programmeren2.Database.Course.DBCourse;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Difficulty;
import Programmeren2.Domain.Student;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GCourse {
    public static void showWindow(Stage window) {
        DBCourse dbCourse = new DBCourse();
        List<Course> courses = new ArrayList<>();
        courses = dbCourse.getCourses();
        
        window.setTitle("CodeCademy | Courses");
        VBox vLayout = new VBox();

        TableView<Course> tableView = new TableView();

        TableColumn<Course, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("courseName"));

        TableColumn<Course, String> column2 = new TableColumn<>("Subject");
        column2.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<Course, String> column3 = new TableColumn<>("introText");
        column3.setCellValueFactory(new PropertyValueFactory<>("introductionText"));

        TableColumn<Course, String> column4 = new TableColumn<>("Level");
        column4.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDifficulty().getValue()));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);


        for (Course course : courses) {
        tableView.getItems().add(course);
        }


        column1.setSortType(TableColumn.SortType.ASCENDING);
        tableView.getSortOrder().add(column1);

        HBox buttons = new HBox();
        buttons.setSpacing(10);
        Button createButton = new Button("Create");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");

        createButton.setOnAction((event) -> {
            //CRUD of courses not needed for this exercise but already made.
            GCreateCourse.showWindow(window);
        });

        editButton.setOnAction((event) -> {
            //CRUD of courses not needed for this exercise 
        });

        deleteButton.setOnAction((event) -> {
            //CRUD of courses not needed for this exercise 
        });
        buttons.getChildren().addAll(createButton, editButton, deleteButton);

        vLayout.getChildren().addAll(tableView, buttons);


        Scene scene = new Scene(vLayout);
        window.setScene(scene);
    }

}