import Controller.MainController;
import Model.Artists;
import Model.Songs;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    MainController controller;

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();
        Pane centrePane = new Pane();

        VBox leftSide = new VBox();
        leftSide.getStyleClass().add("leftSide");
        leftSide.setPrefWidth(200);

        HBox bottomSide = new HBox();
        bottomSide.getStyleClass().add("bottomSide");
        bottomSide.setPrefHeight(230);

        VBox songInfo = new VBox();
        songInfo.setPrefWidth(200);

        HBox playControls = new HBox();
        playControls.setPrefWidth(624);
        playControls.setAlignment(Pos.CENTER);
        playControls.setSpacing(60);

        HBox volumeControls = new HBox();
        volumeControls.setPrefWidth(200);
        volumeControls.setAlignment(Pos.CENTER);
        volumeControls.setSpacing(50);

        root.setLeft(leftSide);
        root.setBottom(bottomSide);
        root.setCenter(centrePane);
        bottomSide.getChildren().add(songInfo);
        bottomSide.getChildren().add(playControls);
        bottomSide.getChildren().add(volumeControls);

        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("iMusic");
        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().add("stylesheet.css");
        stage.show();


        ListView listPlaylists = new ListView();
        listPlaylists.setPrefSize(200, 550);
        listPlaylists.getStyleClass().add("listPlaylist-view");
        leftSide.getChildren().add(listPlaylists);


        TableView songTable = new TableView();
        songTable.setPrefSize(834, 539);
        songTable.getStyleClass().add("songTable-view");
        centrePane.getChildren().add(songTable);

        TableColumn<Songs, String> songNameColumn = new TableColumn<>("Name");
        songNameColumn.setCellValueFactory(new PropertyValueFactory<>("songName"));
        songNameColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.35));
        songNameColumn.setResizable(false);
        songTable.getColumns().add(songNameColumn);

        TableColumn<Songs, String> artistNameColumn = new TableColumn<>("Artist");
        artistNameColumn.setCellValueFactory(new PropertyValueFactory<>("artistName"));
        artistNameColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.31));
        artistNameColumn.setResizable(false);
        songTable.getColumns().add(artistNameColumn);

        TableColumn<Songs, String> songLengthColumn = new TableColumn<>("Length");
        songLengthColumn.setCellValueFactory(new PropertyValueFactory<>("songLength"));
        songLengthColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.31));
        songLengthColumn.setResizable(false);
        songTable.getColumns().add(songLengthColumn);

        Button skipBackButton = new Button("<<");
        skipBackButton.getStyleClass().add("button");
        skipBackButton.setPrefSize(125, 50);
        playControls.getChildren().add(skipBackButton);

        Button playButton = new Button("►");
        playButton.getStyleClass().add("button");
        playButton.setPrefSize(125, 50);
        playButton.setOnAction((ActionEvent ae) -> playPop(ae));
        playControls.getChildren().add(playButton);

        Button skipForwardButton = new Button(">>");
        skipForwardButton.getStyleClass().add("button");
        skipForwardButton.setPrefSize(125, 50);
        playControls.getChildren().add(skipForwardButton);

        Button volumeDown = new Button("-");
        volumeDown.getStyleClass().add("button");
        volumeDown.setPrefSize(50, 50);
        volumeControls.getChildren().add(volumeDown);

        Button volumeUp = new Button("+");
        volumeUp.getStyleClass().add("button");
        volumeUp.setPrefSize(50, 50);
        volumeControls.getChildren().add(volumeUp);

        controller = new MainController(listPlaylists, songTable);

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