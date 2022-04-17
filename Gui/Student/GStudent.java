package Programmeren2.Gui.Student;

import javafx.event.EventHandler;
import javafx.geometry.Insets;

import java.util.List;

import javax.sound.sampled.SourceDataLine;
import javax.swing.table.JTableHeader;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import Programmeren2.Database.DBStudent;
import Programmeren2.Domain.Student;
import Programmeren2.Gui.Gui;
import Programmeren2.Gui.Course.GCourse;
import Programmeren2.Gui.Registration.GRegistration;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GStudent {
    public static void showWindow(Stage window) {
        window.setTitle("CodeCademy | Students");
        BorderPane layout = new BorderPane();

        DBStudent dbStudent = new DBStudent();
        List<Student> students = dbStudent.getStudents();
        TableView<Student> tableView = new TableView<>();
        layout.setCenter(tableView);
        TableColumn<Student, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("Name"));
        column1.prefWidthProperty().bind(tableView.widthProperty().divide(4));

        tableView.setStyle("-fx-background-color: linear-gradient(to bottom, #9CC0E7, #EEEEEE); -fx-background-radius: 7px 7px 0px 0px; -fx-padding: 0 0 5px 0;");
        column1.setStyle("-fx-background-color: #9CC0E7;");

        TableColumn<Student, String> column2 = new TableColumn<>("Email");
        column2.setCellValueFactory(new PropertyValueFactory<>("Email"));
        column2.prefWidthProperty().bind(tableView.widthProperty().divide(4));
        column2.setStyle("-fx-background-color: #9CC0E7;");

        TableColumn<Student, String> column3 = new TableColumn<>("Gender");
        column3.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        column3.prefWidthProperty().bind(tableView.widthProperty().divide(4));
        column3.setStyle("-fx-background-color: #9CC0E7;");

        TableColumn<Student, String> column4 = new TableColumn<>("Birthdate");
        column4.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
        column4.prefWidthProperty().bind(tableView.widthProperty().divide(4));
        column4.setStyle("-fx-background-color: #9CC0E7;");

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
        // tableView.getColumns().add(column5);
        // tableView.getColumns().add(column6);
        // tableView.getColumns().add(column7);

        for (Student s : students) {
            tableView.getItems().add(s);
        }

        final ContextMenu contextMenu = new ContextMenu();
        MenuItem edit = new MenuItem("Edit");
        MenuItem delete = new MenuItem("Delete");
        contextMenu.getItems().addAll(edit, delete);

        // Event on click
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                    contextMenu.hide();

                    event.consume();
                    Student selectedStudent = tableView.getSelectionModel().selectedItemProperty().get();

                    contextMenu.show(tableView, event.getScreenX(), event.getScreenY());

                    edit.setOnAction((e) -> {
                        // TODO ADD GUI FOR EDIT STUDENT
                    });
                    delete.setOnAction((e) -> {
                        dbStudent.deleteStudents(selectedStudent.getEmail());
                        tableView.getItems().remove(selectedStudent);
                        System.out.println("Deleted " + selectedStudent);

                    });

                }
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    Student clickedItem = tableView.getSelectionModel().selectedItemProperty().get();
                    GRegistration.showWindow(window, clickedItem);
                }
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    contextMenu.hide();
                }
            }
        });

        // Setting layout for buttons at bottom
        HBox lHBox = new HBox();
        lHBox.setStyle("-fx-background-color: #EEEEEE;");
        layout.setBottom(lHBox);
        Button backButton = new Button("< Back");
        backButton.setOnAction(e -> {
            try {
                Gui.showWindow(window);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            ;
        });
        backButton.setStyle("-fx-background-color: linear-gradient(to bottom, #0495bd, #9CC0E1); -fx-text-fill: white;-fx-font-weight: bold");
        Button createButton = new Button("Create");
        createButton.setStyle("-fx-background-color: linear-gradient(to bottom, #0495bd, #9CC0E1); -fx-text-fill: white;-fx-font-weight: bold");
        createButton.setOnAction(e -> {
            GCreateStudent.showWindow(window);
        });

        lHBox.setSpacing(10);
        lHBox.getChildren().addAll(backButton, createButton);
        Scene scene = new Scene(layout, 500, 250);
        window.setScene(scene);
    }
}