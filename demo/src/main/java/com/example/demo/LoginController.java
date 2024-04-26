package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginController extends Application{
    @FXML
    private static Button exitApplication;
    @FXML
    private Button signInButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label failedLoginMessage;
    @FXML
    private Hyperlink signUpLink;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private void exitApplication(ActionEvent event){
        System.exit(0);
    }
    @FXML
    private void login(ActionEvent event) throws IOException {
        if(usernameField.getText().isBlank() == false && passwordField.getText().isBlank() == false){
            boolean token = validateLogin(); // checks DB for valid credentials
            if (token) {
                // Assigns user attributes
                UserInformation.username = STR."@\{usernameField.getText()}";

                // Proceeds to Profile screen
                Parent root = FXMLLoader.load(Application.class.getResource("Profile_view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                root.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
                    @Override
                    public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        xOffset = mouseEvent.getSceneX();
                        yOffset = mouseEvent.getSceneY();
                    }
                });
                root.setOnMouseDragged(new EventHandler<javafx.scene.input.MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        stage.setX(mouseEvent.getScreenX() - xOffset);
                        stage.setY(mouseEvent.getScreenY() - yOffset);
                    }
                });
                stage.setTitle("Tourmate");
                stage.setScene(scene);
                stage.show();
            } else {
                failedLoginMessage.setText("Invalid Login. Please try again.");
            }
        } else{
            failedLoginMessage.setText("Please enter an username and password.");
        }
    }
    @FXML
    private void registerAccount(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Application.class.getResource("Reg_view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        root.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setX(mouseEvent.getScreenX() - xOffset);
                stage.setY(mouseEvent.getScreenY() - yOffset);
            }
        });
        stage.setTitle("Tourmate");
        stage.setScene(scene);
        stage.show();
    }
    public boolean validateLogin(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        String verifyLogin = "SELECT * FROM registration WHERE UserName = ? AND Pass_word = ?";
        System.out.println(verifyLogin);

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLogin);
            preparedStatement.setString(1, this.usernameField.getText());
            preparedStatement.setString(2, this.passwordField.getText());
            ResultSet queryResult = preparedStatement.executeQuery();
            if (queryResult.next()) {
                String username = queryResult.getString("UserName");
                String first_name = queryResult.getString("first_name");
                String last_name = queryResult.getString("last_name");
                String var10000 = queryResult.getString("first_name");
                String fullName = var10000 + " " + queryResult.getString("last_name");
                String emailID = queryResult.getString("emailID");
                String dateOfBirth = queryResult.getString("birthDate");
                String gender = queryResult.getString("gender");
                String bio = queryResult.getString("bio");
                String nationality = queryResult.getString("nationality");
                String address = queryResult.getString("address");
                System.out.println("Username : " + username);
                Session.setUserData(username, first_name, last_name, fullName, emailID, dateOfBirth, gender, bio, nationality, address);
                Dashboard dashboardSession = new Dashboard();
                dashboardSession.fetchAndSetTripData(username);
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}