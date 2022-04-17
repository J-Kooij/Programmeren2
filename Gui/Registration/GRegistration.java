package Programmeren2.Gui.Registration;

import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.List;
import Programmeren2.Domain.Course;
import Programmeren2.Database.DBRegister;
import Programmeren2.Domain.Registration;
import Programmeren2.Domain.Student;
import Programmeren2.Gui.ContentItem.GContentItem;
import Programmeren2.Gui.Student.GStudent;
import javafx.beans.property.SimpleStringProperty;
import Programmeren2.Database.DBStudent;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GRegistration {
    public static void showWindow(Stage window, Student student){ 
        BorderPane layout = new BorderPane();
        DBRegister dbRegister = new DBRegister();
        List<Registration> registrations = new ArrayList<>();
        registrations = dbRegister.getRegistrations(student);
        VBox vBox = new VBox();
        Label title = new Label("Student: "+student.getName());
        title.setPadding(new Insets(0, 0, 5, 0));
        vBox.setAlignment(Pos.CENTER);
        title.setStyle("-fx-font-weight: bold; -fx-font-size:25");

        Label subtitle = new Label("Registrations of Student:");
        subtitle.setStyle("-fx-font-weight: bold; -fx-font-size:17");
        layout.setTop(vBox);
        vBox.getChildren().addAll(title, subtitle);


        TableView<Registration> tableView = new TableView<>();
        layout.setCenter(tableView);

        TableColumn<Registration, String> column1 = new TableColumn<>("Course name:");
        column1.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCourse().getCourseName()));
        column1.prefWidthProperty().bind(tableView.widthProperty().divide(3));

        TableColumn<Registration, String> column2 = new TableColumn<>("Student:");
        column2.setCellValueFactory((c -> new SimpleStringProperty(c.getValue().getStudent().getEmail())));
        column2.prefWidthProperty().bind(tableView.widthProperty().divide(3));

        TableColumn<Registration, String> column3 = new TableColumn<>("Registration Date: ");
        column3.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
        column3.prefWidthProperty().bind(tableView.widthProperty().divide(3));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);

        for(Registration r : registrations){
            tableView.getItems().add(r);
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
                    Registration selectedRegistration = tableView.getSelectionModel().selectedItemProperty().get();
                   

                    contextMenu.show(tableView, event.getScreenX(), event.getScreenY());
                    
                    edit.setOnAction((e) ->{
                        // TODO ADD GUI FOR EDIT REGISTER
                        GEditRegistration.showWindow(window, selectedRegistration);
                    });
                    delete.setOnAction((e) ->{
                        dbRegister.deleteRegistration(selectedRegistration.getRegistrationId());
                        tableView.getItems().remove(selectedRegistration);
                        System.out.println("Deleted "+selectedRegistration);
                    
                    });
                    
                }
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    Course clickedItem = tableView.getSelectionModel().selectedItemProperty().get().getCourse();
                    GContentItem.showWindow(window, clickedItem, student);
                    //.showWindow(window, clickedItem);
                }
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    contextMenu.hide();
                }
            }
        });

        

        HBox lHBox = new HBox();
        layout.setBottom(lHBox);
        Button backButton = new Button("< Back");
        backButton.setOnAction(e -> {try {
            GStudent.showWindow(window);
        } catch (Exception e1) {
            e1.printStackTrace();
        };});
        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {GCreateRegistration.showWindow(window, student);});
        Button infoButton = new Button("🛈 More info");
        lHBox.setMargin(infoButton, new Insets(0, 0, 0, 225));

        //Pop-up for more information about the student
        infoButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    final Stage dialog = new Stage();
                    DBStudent dbStudent = new DBStudent();
                    List<Student> students = dbStudent.getStudents();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(window);
                    VBox dialogVbox = new VBox(20);
                    Label title = new Label("More personal information: ");
                    title.setStyle("-fx-font-weight: bold; -fx-font-size:18");
                    dialogVbox.setAlignment(Pos.CENTER);

                    
                    TableView tableView = new TableView<>();
                    TableColumn<Student, String> column1 = new TableColumn<>("Address");
                    column1.setCellValueFactory(new PropertyValueFactory<>("Address"));
                    column1.prefWidthProperty().bind(tableView.widthProperty().divide(3));
            
                    TableColumn<Student, String> column2 = new TableColumn<>("City");
                    column2.setCellValueFactory(new PropertyValueFactory<>("City"));
                    column2.prefWidthProperty().bind(tableView.widthProperty().divide(3));
            
                    TableColumn<Student, String> column3 = new TableColumn<>("Country");
                    column3.setCellValueFactory(new PropertyValueFactory<>("Country"));
                    column3.prefWidthProperty().bind(tableView.widthProperty().divide(3));

                    tableView.getColumns().add(column1);
                    tableView.getColumns().add(column2);
                    tableView.getColumns().add(column3);

                    for (Student s : students) {
                        tableView.getItems().add(s);
                    }

                    dialogVbox.getChildren().addAll(title, tableView);
                    Scene dialogScene = new Scene(dialogVbox, 350, 225);
                    dialog.setTitle("Student info");
                    dialog.setScene(dialogScene);
                    dialog.show();
                }
             });
        
        lHBox.setSpacing(10);
        lHBox.getChildren().addAll(backButton, createButton, infoButton);
        window.setTitle("Codecademy | Students | Registrations");
        Scene scene = new Scene(layout, 550, 350);
        window.setScene(scene);


    }

    
}
