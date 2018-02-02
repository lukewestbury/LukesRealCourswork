package Controller;

import javafx.scene.control.ListView;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.Optional;

public class MainController {

    private ListView<Playlists> listPlaylists;
    private TableView<Songs> songTable;

    private DatabaseConnection database;
    private ArrayList<Playlists> playlistsArrayList = new ArrayList<>();
    private ArrayList<Songs> songsArrayList = new ArrayList<>();

    public MainController(ListView<Playlists> listPlaylists, TableView<Songs> songTable){
        System.out.println("Initialising main controller...");

        this.listPlaylists = listPlaylists;
        this.songTable = songTable;

        database = new DatabaseConnection("PROJECT.db");
        updateLists(0, 0);
    }

    private void updateLists(int selectPlaylistID, int selectSongID) {

        playlistsArrayList.clear();
        PlaylistService.selectAll(playlistsArrayList, database);

        listPlaylists.setItems(FXCollections.observableList(playlistsArrayList));

        songTable.getItems().clear();
        Song
    }

}
