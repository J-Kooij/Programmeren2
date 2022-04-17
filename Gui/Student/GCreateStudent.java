package Programmeren2.Gui.Student;

import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.Date;
import Programmeren2.Database.DBStudent;
import Programmeren2.Domain.Gender;
import Programmeren2.Domain.Student;
import Programmeren2.Gui.Gui;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GCreateStudent {
    public static void showWindow(Stage window) {
        DBStudent dbStudent = new DBStudent();

        BorderPane mHBox = new BorderPane();
        VBox lVBox = new VBox();
        VBox rVBox = new VBox();
        mHBox.setPadding(new Insets(10, 35, 10, 35));
        lVBox.setSpacing(5);
        rVBox.setSpacing(5);

        Label createStudent = new Label("Create a student");
        createStudent.setStyle("-fx-font-weight: bold; -fx-font-size:17");
        mHBox.setTop(createStudent);
        mHBox.setLeft(lVBox);
        mHBox.setRight(rVBox);
        mHBox.setAlignment(createStudent, Pos.CENTER);

        Label name = new Label("Name:");
        TextField nameTextField = new TextField();

        Label email = new Label("Email:");
        TextField emailTextField = new TextField();

        Label gender = new Label("Gender: ");
        ComboBox<String> genderChoice = new ComboBox<>();
        genderChoice.getItems().add(Gender.MALE.getValue());
        genderChoice.getItems().add(Gender.FEMALE.getValue());
        genderChoice.getItems().add(Gender.NONE.getValue());
        // Tijdelijk een choicebox wellicht binnenkort checkbox ipv choiceboix?

        Label birthDate = new Label("Birthdate:");
        DatePicker birthDatePicker = new DatePicker();

        Label address = new Label("Address:");
        TextField addressTextField = new TextField();
        addressTextField.setPromptText("Examplestreet 123 ");

        Label city = new Label("City:");
        TextField cityTextField = new TextField();
        cityTextField.setPromptText("New York");

        Label country = new Label("Country:");
        TextField countryTextField = new TextField();
        countryTextField.setPromptText("Netherlands ");

        Button createStudentButton = new Button("Save & Create");
        createStudentButton.setStyle(
                "-fx-background-color: #0495bd; -fx-text-fill: white; -fx-font-size:17; -fx-font-weight: bold");
        rVBox.setMargin(createStudentButton, new Insets(15, 0, 0, 0));

        createStudentButton.setOnAction((event) -> {
            System.out.println(birthDatePicker.getValue().toString());
            String studentName = nameTextField.getText();
            String studentEmail = emailTextField.getText();
            Gender studentGender = Gender.convertToGender(genderChoice.getValue());
            String studentAddress = addressTextField.getText();
            String studentCity = cityTextField.getText();
            String studentCountry = countryTextField.getText();

            LocalDate pickedDate = birthDatePicker.getValue();
            Date studentBirthDate =java.sql.Date.valueOf(pickedDate);

            Student student = new Student(studentName, studentEmail, studentGender, studentBirthDate, studentAddress,
                    studentCity, studentCountry);
            dbStudent.createStudents(student);
        });

        Button backButton = new Button("< Back");
        backButton.setOnAction(e -> {
            try {
                Gui.showWindow(window);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        mHBox.setBottom(backButton);

        lVBox.getChildren().addAll(name, nameTextField, email, emailTextField, gender, genderChoice, birthDate,
                birthDatePicker);
        rVBox.getChildren().addAll(address, addressTextField, city, cityTextField, country, countryTextField,
                createStudentButton);

        Scene scene = new Scene(mHBox, 500, 300);
        window.setScene(scene);
    }

}
