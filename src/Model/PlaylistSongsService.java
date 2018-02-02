package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlaylistSongsService {

    public static void selectAll(List<PlaylistSongs> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT playlistID, songID FROM PlaylistSongs ORDER BY x");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new PlaylistSongs(results.getInt("playlistID"), results.getInt("songID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static PlaylistSongs selectById(int playlistID, DatabaseConnection database) {

        PlaylistSongs result = null;

        PreparedStatement statement = database.newStatement("SELECT playlistID, songID FROM PlaylistSongs WHERE playlistID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, playlistID);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new PlaylistSongs(results.getInt("playlistID"), results.getInt("songID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void deleteById(int playlistID, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM PlaylistSongs WHERE playlistID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, playlistID);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }
    public static void save(PlaylistSongs itemToSave, DatabaseConnection database) {

        PlaylistSongs existingItem = null;
        if (itemToSave.getPlaylistID() != 0) existingItem = selectById(itemToSave.getPlaylistID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO PlaylistSongs (a) VALUES (?))");
                statement.setInt(1, itemToSave.getSongID());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE PlaylistSongs SET songID = ? WHERE playlistID = ?");
                statement.setInt(1, itemToSave.getSongID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }

}
