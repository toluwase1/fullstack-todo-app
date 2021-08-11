package com.example.testfx;

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

public class SignUp extends Application {
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Signup form window");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        Text welcomeText = new Text("SignUp Window");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        gridPane.add(welcomeText, 0,0);

        //Email
        Label labelEmail = new Label("Email Address");
        gridPane.add(labelEmail, 0,1);
        TextField textField = new TextField();
        textField.setPromptText("email");
        gridPane.add(textField, 1, 1);

        //Username
        Label labelUser = new Label("Username");
        gridPane.add(labelUser, 0,2);
        TextField textUser = new TextField();
        textUser.setPromptText("username");
        gridPane.add(textUser, 1, 2);

        //FirstName
        Label labelFirstName = new Label("firstName");
        gridPane.add(labelFirstName, 0,3);
        TextField textFirstName = new TextField();
        textField.setPromptText("firstName");
        gridPane.add(textFirstName, 1, 3);

        //LastName
        Label labelLastName = new Label("lastName");
        gridPane.add(labelLastName, 0,4);
        TextField textLastName = new TextField();
        textField.setPromptText("lastName");
        gridPane.add(textLastName, 1, 4);

        //Password
        Label labelPassword = new Label("Password");
        gridPane.add(labelPassword, 0,5);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("password");
        gridPane.add(passwordField, 1,5);

        //Phone
        Label labelPhone = new Label("Phone");
        gridPane.add(labelPhone, 0,6);
        TextField Phone = new TextField();
        Phone.setPromptText("Phone");
        gridPane.add(Phone, 1,6);

        Button loginButton = new Button("Login");
        gridPane.add(loginButton, 1,7);

        Scene scene = new Scene(gridPane, 500, 500);
        window.setScene(scene);
        window.show();

    }



}
