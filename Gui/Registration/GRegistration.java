package Programmeren2.Gui.Registration;

import javafx.event.EventHandler;
import Programmeren2.Domain.Student;
import Programmeren2.Gui.Gui;
import Programmeren2.Gui.Student.GCreateStudent;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GRegistration {
    public static void showWindow(Stage window, Student student){ 
        BorderPane layout = new BorderPane();
        VBox vBox = new VBox();
        Label title = new Label("Student: xxx");
        title.setPadding(new Insets(0, 0, 5, 0));
        vBox.setAlignment(Pos.CENTER);
        title.setStyle("-fx-font-weight: bold; -fx-font-size:25");

        Label subtitle = new Label("Registrations of Student:");
        subtitle.setStyle("-fx-font-weight: bold; -fx-font-size:17");
        layout.setTop(vBox);
        vBox.getChildren().addAll(title, subtitle);


        TableView<Student> tableView = new TableView<>();
        layout.setCenter(tableView);

        TableColumn<Student, String> column1 = new TableColumn<>("Course name:");
        column1.setCellValueFactory(new PropertyValueFactory<>("Name"));
        column1.prefWidthProperty().bind(tableView.widthProperty().divide(3));

        TableColumn<Student, String> column2 = new TableColumn<>("Student:");
        column2.setCellValueFactory(new PropertyValueFactory<>("Email"));
        column2.prefWidthProperty().bind(tableView.widthProperty().divide(3));

        TableColumn<Student, String> column3 = new TableColumn<>("Registration Date: ");
        column3.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        column3.prefWidthProperty().bind(tableView.widthProperty().divide(3));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);

        // for(Student s : students){
        //     tableView.getItems().add(s);
        // }
        HBox lHBox = new HBox();
        layout.setBottom(lHBox);
        Button backButton = new Button("< Back");
        backButton.setOnAction(e -> {try {
            Gui.showWindow(window);
        } catch (Exception e1) {
            e1.printStackTrace();
        };});
        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {GCreateRegistration.showWindow(window);});
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        Button infoButton = new Button("🛈 More info");
        lHBox.setMargin(infoButton, new Insets(0, 0, 0, 225));

        //Pop-up for more information about the student
        infoButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(window);
                    VBox dialogVbox = new VBox(20);
                    Label title = new Label("More personal information: ");
                    title.setStyle("-fx-font-weight: bold; -fx-font-size:18");
                    dialogVbox.setAlignment(Pos.CENTER);
                    dialogVbox.getChildren().add(title);
                    

                    Scene dialogScene = new Scene(dialogVbox, 350, 225);
                    dialog.setTitle("Student info");
                    dialog.setScene(dialogScene);
                    dialog.show();
                }
             });
        
        lHBox.setSpacing(10);
        lHBox.getChildren().addAll(backButton, createButton, editButton, deleteButton, infoButton);
        window.setTitle("Codecademy | Students | Registrations");
        Scene scene = new Scene(layout, 550, 350);
        window.setScene(scene);


    }
}
