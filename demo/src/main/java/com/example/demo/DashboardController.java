package com.example.demo;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class DashboardController extends Application implements Initializable {
    @FXML
    private static Button exitApplication;
    @FXML
    private static Button minimizeApplication;
    @FXML
    private static Button goToProfileView;
    @FXML
    private static Button editProfile;
    @FXML
    private static Button logOut;
    @FXML
    private static Button goToCreatePlan;
    @FXML
    private static Button goToSettings;
    @FXML
    private static Button goToDashboard;
    @FXML
    private static Button goToViewPlan;
    @FXML
    public Label upcoming_trips;
    @FXML
    public Label completed_trips;
    @FXML
    public Label interested_trips;
    @FXML
    private Label userName;
    @FXML
    private Label fullName;
    @FXML
    private ChoiceBox<String> sortStatsBy;
    private String[] byMonthCategories = {"Jan", "Feb", "Mar"};
    private String[] frequencyByYearCategories = {"2022", "2023", "2024"};
    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();
    @FXML
    private BarChart<String, Number> tripFrequencyBC = new BarChart<>(xAxis, yAxis);
    @FXML
    private LineChart<String, Number> rankHistoryLC = new LineChart<>(xAxis, yAxis);
    private XYChart.Series<String, Number> tripFrequencySeries = new XYChart.Series<>();
    private XYChart.Series<String, Number> rankHistorySeries = new XYChart.Series<>();
    @FXML
    private String[] sortOptions = {"Week", "Month", "Year"};
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

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
    protected void goToViewPlanFunc(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(Application.class.getResource("View_my_plans.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
    protected void goToCreatePlanFunc(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Application.class.getResource("Create_plan.fxml"));
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
    protected void editProfile(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Application.class.getResource("Profile_edit.fxml"));
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
    private Circle profileImageBorder;
    @FXML
    private Text name; // concatenate FirstName and LastName from DB
    @FXML
    private Text username;
    @FXML
    private Text email;
    @FXML
    private TextField searchBar;
    @FXML
    private ImageView profileIcon;
    @FXML
    private ImageView sidebarToggleOpen;
    @FXML
    private ImageView sidebarToggleClose;
    @FXML
    private Button sidebarLogoutButton;
    @FXML
    private AnchorPane sidebarAnchorPane;
    @FXML
    private AnchorPane profilePane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Default profile avatar
        profileImageBorder.setFill(new ImagePattern(UserInformation.profileImage));
//        fullName.setText("Shakib Akram Rumman");
        Session.UserData userdata = Session.getUserData();
        fullName.setText(userdata.getFullName());
        //this.userName.setText(UserInformation.username);
        SessionTrip.TripData tripdata = SessionTrip.getTripData();
          upcoming_trips.setText(tripdata.getUpcoming_trips());
           completed_trips.setText(tripdata.getCompleted_trips());
           interested_trips.setText(tripdata.getInterested_trips());
        userName.setText(UserInformation.username);
        searchBar.setStyle("-fx-text-fill: white; -fx-background-color: transparent");
        sortStatsBy.getItems().addAll(sortOptions);

        // tripFrequencyBarChart config
        xAxis.setCategories(FXCollections.observableArrayList(Arrays.asList(byMonthCategories)));
        tripFrequencyBC.setTitle("Trip Frequency");
        tripFrequencySeries.setName("Month");
        tripFrequencySeries.getData().add(new XYChart.Data<>("Jan", 10));
        tripFrequencySeries.getData().add(new XYChart.Data<>("Feb", 20));
        tripFrequencySeries.getData().add(new XYChart.Data<>("Mar", 30));
        tripFrequencyBC.getData().add(tripFrequencySeries);

        // rankFrequencyBarChar config
        rankHistoryLC.setTitle("Rank History");
        rankHistorySeries.setName("Month");
        rankHistorySeries.getData().add(new XYChart.Data<>("Jan", 500));
        rankHistorySeries.getData().add(new XYChart.Data<>("Feb", 1000));
        rankHistorySeries.getData().add(new XYChart.Data<>("Mar", 200));
        rankHistoryLC.getData().add(rankHistorySeries);

        // Sync username
//        userName.setText(STR."@\{UserInfo.userName}");
        // Sidebar toggling
        sidebarAnchorPane.setTranslateX(-163);
        sidebarToggleOpen.setOnMouseClicked(event -> {
            TranslateTransition tt1 = new TranslateTransition();
            tt1.setDuration(Duration.seconds(0.4));
            tt1.setNode(sidebarAnchorPane);

            tt1.setToX(0);
            tt1.play();

            sidebarAnchorPane.setTranslateX(-163);

            tt1.setOnFinished((ActionEvent eventAlpha) -> {
                sidebarToggleOpen.setVisible(false);
                sidebarToggleClose.setVisible(true);
            });
        });
        sidebarToggleClose.setOnMouseClicked(event -> {
            TranslateTransition tt2 = new TranslateTransition();
            tt2.setDuration(Duration.seconds(0.4));
            tt2.setNode(sidebarAnchorPane);

            tt2.setToX(-163);
            tt2.play();

            sidebarAnchorPane.setTranslateX(0);

            tt2.setOnFinished((ActionEvent eventBeta) -> {
                sidebarToggleOpen.setVisible(true);
                sidebarToggleClose.setVisible(false);
            });
        });
    }

}

