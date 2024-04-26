package com.example.demo;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditProfileController extends Application implements Initializable {
    @FXML
    private FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG Files (*.jpg)", "*.JPG");
    FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG Files (*.png)", "*.PNG");
    @FXML
    private static ImageView profileIcon;
    @FXML
    private static Button profilePreview;
    @FXML
    private static Button goToDashboard;
    @FXML
    private static Button goToSettings;
    @FXML
    private Button editProfileImage;
    @FXML
    private static Button exitApplication;
    @FXML
    private static Button logOut;
    @FXML
    private static Button minimizeApplication;
    @FXML
    private Circle profileImageBorder;
    @FXML
    private ImageView sidebarToggleOpen;
    @FXML
    private ImageView sidebarToggleClose;
    @FXML
    private AnchorPane sidebarAnchorPane;
    @FXML
    private Button sidebarLogoutButton;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private TextField searchBar;
    @FXML
    protected void setExitApplication(ActionEvent event){
        System.exit(0);
    }
    @FXML
    protected void setMinimizeApplication(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    protected void setGoToSettings(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Application.class.getResource("Settings.fxml"));
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
    @FXML
    protected void logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Application.class.getResource("Login_view.fxml"));
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
    @FXML
    private void siphonResource(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(jpgFilter, pngFilter);
        fileChooser.setInitialDirectory(null);
        File resource = fileChooser.showOpenDialog(null);
        if (resource != null){
            Image profileImage = new Image(resource.toURI().toString());
            profileImageBorder.setFill(new ImagePattern(profileImage));
        }
    }
    @FXML
    protected void viewProfile(ActionEvent event) throws IOException{
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
    }
    @FXML
    protected void goToDashboardFunc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Application.class.getResource("Dashboard.fxml"));
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Default profile avatar
        profileImageBorder.setFill(new ImagePattern(UserInformation.profileImage));

        searchBar.setStyle("-fx-text-fill: white; -fx-background-color: transparent");

        // Sidebar toggling
        sidebarAnchorPane.setTranslateX(-191);
        sidebarToggleOpen.setOnMouseClicked(event -> {
            TranslateTransition tt1 = new TranslateTransition();
            tt1.setDuration(Duration.seconds(0.4));
            tt1.setNode(sidebarAnchorPane);

            tt1.setToX(0);
            tt1.play();

            sidebarAnchorPane.setTranslateX(-191);

            tt1.setOnFinished((ActionEvent eventAlpha) -> {
                sidebarToggleOpen.setVisible(false);
                sidebarToggleClose.setVisible(true);
            });
        });
        sidebarToggleClose.setOnMouseClicked(event -> {
            TranslateTransition tt2 = new TranslateTransition();
            tt2.setDuration(Duration.seconds(0.4));
            tt2.setNode(sidebarAnchorPane);

            tt2.setToX(-191);
            tt2.play();

            sidebarAnchorPane.setTranslateX(0);

            tt2.setOnFinished((ActionEvent eventBeta) -> {
                sidebarToggleOpen.setVisible(true);
                sidebarToggleClose.setVisible(false);
            });
        });
    }
}
