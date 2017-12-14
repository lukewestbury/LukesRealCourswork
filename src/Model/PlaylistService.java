package Model;

import Model.Playlists;
import Model.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class PlaylistService {

    public static void selectAll(List<Playlists> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT playlistID, playlistName, playlistBio, " +
                "playlistLength FROM Playlists ORDER BY playlistID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Playlists(results.getInt("playlistID"), results.getString("playlistName"),
                                results.getString("playlistBio"), results.getInt("playlistLength")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static Playlists selectById(int id, DatabaseConnection database) {

        Playlists result = null;

        PreparedStatement statement = database.newStatement("SELECT playlistID, playlistName, playlistBio, " +
                "playlistLength FROM Playlists WHERE playlistID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Playlists(results.getInt("playlistID"), results.getString("playlistName"),
                            results.getString("playlistBio"), results.getInt("playlistLength"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Playlists WHERE playlistID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }
    public static void save(Playlists itemToSave, DatabaseConnection database) {

        Playlists existingItem = null;
        if (itemToSave.getPlaylistID() != 0) existingItem = selectById(itemToSave.getPlaylistID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Playlists (playlistName, playlistBio, playlistLength) VALUES (?, ?, ?))");
                statement.setString(1, itemToSave.getPlaylistName());
                statement.setString(2, itemToSave.getPlaylistBio());
                statement.setInt(3, itemToSave.getPlaylistLength());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Playlists SET playlistName = ?, playlistBio = ?, playlistLength = ? WHERE playlistID = ?");
                statement.setString(1, itemToSave.getPlaylistName());
                statement.setString(2, itemToSave.getPlaylistBio());
                statement.setInt(3, itemToSave.getPlaylistLength());
                statement.setInt(4, itemToSave.getPlaylistID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }






}
