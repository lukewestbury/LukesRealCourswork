import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();
        Pane centrePane = new Pane();

        VBox leftSide = new VBox();
        leftSide.getStyleClass().add("leftSide");
        leftSide.setPrefWidth(200);
        HBox bottomSide = new HBox();
        bottomSide.getStyleClass().add("bottomSide");
        bottomSide.setPrefHeight(180);

        root.setLeft(leftSide);
        root.setBottom(bottomSide);
        root.setCenter(centrePane);

        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("iMusic");
        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().add("stylesheet.css");
        stage.show();


       ListView listPlaylists = new ListView();
       listPlaylists.setPrefSize(200, 600);
       listPlaylists.getStyleClass().add("listPlaylist-view");
       leftSide.getChildren().add(listPlaylists);


       TableView songTable = new TableView();
       songTable.setPrefSize(834, 599);
       songTable.getStyleClass().add("songTable-view");
       centrePane.getChildren().add(songTable);

        Button playButton = new Button("Play");
        playButton.getStyleClass().add("button");
        playButton.setLayoutY(90);
       // playButton.setOnAction((ActionEvent ae) -> playPop(ae));
        bottomSide.getChildren().add(playButton);
    }


    public static void playPop(ActionEvent ae) {
        Alert playAlert = new Alert(Alert.AlertType.INFORMATION);
        playAlert.setTitle("Hello Title");
        playAlert.setHeaderText("Header");
        playAlert.setContentText("Wow, Hello!!");
        playAlert.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}