package Programmeren2.Gui.Course;

import java.util.ArrayList;

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

public class Course {
    public static void showCourse(Stage window){
        ArrayList<Course> courses;

        window.setTitle("CodeCademy | Courses");
        VBox vLayout = new VBox();


        TableView tableView = new TableView();

        TableColumn<String, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<String, String> column2 = new TableColumn<>("Subject");
        column2.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<String, String> column3 = new TableColumn<>("introText");
        column2.setCellValueFactory(new PropertyValueFactory<>("introText"));

        TableColumn<String, String> column4 = new TableColumn<>("Level");
        // column2.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue()));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        // for (Course course : courses) {
        // tableView.getItems().add(courses);
        // }


        column1.setSortType(TableColumn.SortType.ASCENDING);
        tableView.getSortOrder().add(column1);
        
        HBox buttons = new HBox();
        Button createButton = new Button();
        Button editButton = new Button();
        Button deleteButton = new Button();
        Scene scene = new Scene(tableView);
        window.setScene(scene);
        window.show();
    }
    
}
