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

    private void updateLists(int selectedPlaylistID, int selectedSongID) {

        playlistsArrayList.clear();
        PlaylistService.selectAll(playlistsArrayList, database);

        listPlaylists.setItems(FXCollections.observableList(playlistsArrayList));

        songTable.getItems().clear();
        SongsService.selectAll(songTable.getItems(), database);

        if (selectedPlaylistID != 0) {
            for (int n = 0; n < listPlaylists.getItems().size(); n++) {
                if (listPlaylists.getItems().get(n).getPlaylistID() == selectedPlaylistID) {
                    listPlaylists.getSelectionModel().select(n);
                    listPlaylists.getFocusModel().focus(n);
                    listPlaylists.scrollTo(n);
                    break;
                }
            }
        }

        if (selectedSongID != 0) {
            for (int n = 0; n < songTable.getItems().size(); n++) {
                if (songTable.getItems().get(n).getSongID() == selectedSongID) {
                    songTable.getSelectionModel().select(n);
                    songTable.getFocusModel().focus(n);
                    songTable.scrollTo(n);
                    break;
                }
            }
        }
    }


}
