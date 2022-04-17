package Programmeren2.Gui.Overview;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GWebcastStatistics {
    public static void showWindow(Stage window){ 
        window.setTitle("CodeCademy | Overview");
        BorderPane layout = new BorderPane();
        Label statsTitle = new Label("The latest statistics:");
        layout.setTop(statsTitle);

        Scene scene = new Scene(layout, 550, 350);
        window.setScene(scene);
    }
}