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

        VBox leftSide = new VBox();
        leftSide.setPrefWidth(200);
        HBox bottomSide = new HBox();
        bottomSide.getStyleClass().add("bottomSide");
        bottomSide.setPrefHeight(180);

        root.setLeft(leftSide);
        root.setBottom(bottomSide);

        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("iMusic");
        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().add("stylesheet.css");
        stage.show();

        Button playButton = new Button("Play");
        playButton.setPrefSize(50, 50);
        playButton.getStyleClass().add("button");
        playButton.setOnAction((ActionEvent ae) -> playPop(ae));
        bottomSide.getChildren().add(playButton);

        ListView listPlaylists = new ListView();
        listPlaylists.setPrefSize(200, 600);
        listPlaylists.getStyleClass().add("listPlaylist-view");
        leftSide.getChildren().add(listPlaylists);
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