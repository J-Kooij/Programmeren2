package Programmeren2.Gui.Course;

import java.util.ArrayList;
import java.util.List;

import Programmeren2.Database.DBCourse;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Difficulty;
import Programmeren2.Domain.Student;
import Programmeren2.Gui.ContentItem.GContentItem;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GCourse {
    public static void showWindow(Stage window) {
        window.setTitle("CodeCademy | Courses");

        DBCourse dbCourse = new DBCourse();
        List<Course> courses = new ArrayList<>();
        courses = dbCourse.getCourses();
        

        VBox vLayout = new VBox();

        TableView<Course> tableView = new TableView<>();

        TableColumn<Course, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        column1.prefWidthProperty().bind(tableView.widthProperty().divide(4));

        TableColumn<Course, String> column2 = new TableColumn<>("Subject");
        column2.setCellValueFactory(new PropertyValueFactory<>("subject"));
        column2.prefWidthProperty().bind(tableView.widthProperty().divide(4));

        TableColumn<Course, String> column3 = new TableColumn<>("introText");
        column3.setCellValueFactory(new PropertyValueFactory<>("introductionText"));
        column3.prefWidthProperty().bind(tableView.widthProperty().divide(4));

        TableColumn<Course, String> column4 = new TableColumn<>("Difficulty");
        column4.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDifficulty().getValue()));
        column4.prefWidthProperty().bind(tableView.widthProperty().divide(4));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        for (Course course : courses) {
            tableView.getItems().add(course);
            }

        // Event on double click item
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() ==2){

                    Course clickedItem = tableView.getSelectionModel().selectedItemProperty().get();
                                
                    GContentItem.showWindow(window, clickedItem);
                }
                
            }
            
        });



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


        Scene scene = new Scene(vLayout, 550, 350);
        window.setScene(scene);
    }

}