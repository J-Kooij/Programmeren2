package Programmeren2.Gui;

import Programmeren2.Domain.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage window) throws Exception {

        // Main layout-------------------------------------------------------------------

        BorderPane layout = new BorderPane();
        layout.setPrefSize(500, 200);
        layout.setPadding(new Insets(10));

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        Button createButton = new Button("Create");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        // Button test = new Button("test");

        buttons.getChildren().addAll(createButton, updateButton, deleteButton);

        layout.setTop(buttons);

        TableView tableView = new TableView();

        TableColumn<String, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<String, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        // GetItem------------------------------------------------------------------------------------------------------------

        // test.setOnAction((event)-> {
        // Object word= ((TableColumn<Student, String>)
        // tableView.getColumns().get(1)).getCellObservableValue(0).getValue();
        // System.out.println(word);
        // });

        // --------------------------------------------------------------------------------------------------------------------
        tableView.getItems().add(new Student("John", "Doe", "John", "Doe", "John", "Doe", "John", "Doe", 1));
        tableView.getItems().add(new Student("apehn", "anoe", "John", "Doe", "John", "Doe", "John", "Doe", 1));
        column1.setSortType(TableColumn.SortType.ASCENDING);
        tableView.getSortOrder().add(column1);

        layout.setCenter(tableView);
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.setTitle("CodeCademy Management");
        window.show();
    }

}
