package Programmeren2.Gui.Overview;

import java.util.ArrayList;
import java.util.List;

import Programmeren2.Database.DBProgression;
import Programmeren2.Domain.Progression;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GWebcastStatistics {
    public static void showWindow(Stage window) {
        window.setTitle("CodeCademy | Overview");
        DBProgression dbProgression = new DBProgression();
        BorderPane layout = new BorderPane();
        Label statsTitle = new Label("The latest statistics: Top Three Webcasts");
        layout.setTop(statsTitle);

        TableView<Progression> wTableView = new TableView<>();

        TableColumn<Progression, String> wColumn1 = new TableColumn<>("Title");
        wColumn1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getContentItem().getTitle()));
        wColumn1.prefWidthProperty().bind(wTableView.widthProperty().divide(4));

        TableColumn<Progression, String> wColumn2 = new TableColumn<>("Description");
        wColumn2.setCellValueFactory(
                cell -> new SimpleStringProperty(cell.getValue().getContentItem().getDescription()));
        wColumn2.prefWidthProperty().bind(wTableView.widthProperty().divide(4));

        TableColumn<Progression, String> wColumn3 = new TableColumn<>("Publication Date");
        wColumn3.setCellValueFactory(
                cell -> new SimpleStringProperty(cell.getValue().getContentItem().getDescription()));
        wColumn3.prefWidthProperty().bind(wTableView.widthProperty().divide(4));

        TableColumn<Progression, String> wColumn4 = new TableColumn<>("Status");
        wColumn4.setCellValueFactory(
                cell -> new SimpleStringProperty(cell.getValue().getContentItem().getStatus().getValue()));
        wColumn4.prefWidthProperty().bind(wTableView.widthProperty().divide(4));

        wTableView.getColumns().add(wColumn1);
        wTableView.getColumns().add(wColumn2);
        wTableView.getColumns().add(wColumn3);
        wTableView.getColumns().add(wColumn4);

        List<Progression> webcasts = new ArrayList<>();
        webcasts = dbProgression.getTopThreeWebcasts();
        if (webcasts.size() <= 3) {
            for (Progression w : webcasts) {
                wTableView.getItems().add(w);
            }
        } if(webcasts.size() >= 0 && webcasts.size() < 3) {
            for (int i = 0; i < 3; i++) {
                wTableView.getItems().add(webcasts.get(i));
            }
        } else {
            System.out.println("Error empty list");
        }

        layout.setCenter(wTableView);
        Scene scene = new Scene(layout, 550, 350);
        window.setScene(scene);
    }
}