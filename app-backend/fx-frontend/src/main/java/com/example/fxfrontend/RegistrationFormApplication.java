package com.example.fxfrontend;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class RegistrationFormApplication extends Application {
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Login form window");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        Text welcomeText = new Text("Welcome");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        gridPane.add(welcomeText, 0,0);

        Label labelUser = new Label("Username");
        gridPane.add(labelUser, 0,1);

        TextField textField = new TextField();
        textField.setPromptText("username");
        gridPane.add(textField, 1, 1);

        Label labelPassword = new Label("Password");
        gridPane.add(labelPassword, 0,2);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("password");
        gridPane.add(passwordField, 1,2);

        Button loginButton = new Button("Login");
        gridPane.add(loginButton, 1,3);

        Scene scene = new Scene(gridPane, 500, 500);
        window.setScene(scene);
        window.show();




//        Parent root = FXMLLoader.load(getClass().getResource("registration_form.fxml"));
//        primaryStage.setTitle("Registration Form FXML Application");
//        primaryStage.setScene(new Scene(root, 800, 500));
//        primaryStage.show();
    }



}
