package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SongsService {
    public static void selectAll(List<Songs> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT songID, artistID, albumID, " +
                "genreID, songName, trackNo, songLength FROM Songs ORDER BY songID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Songs(results.getInt("songID"), results.getInt("artistID"),
                                results.getInt("albumID"), results.getInt("genreID"),
                                results.getString("songName"), results.getInt("trackNo"),
                                results.getInt("songLength")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static Songs selectById(int id, DatabaseConnection database) {

        Songs result = null;

        PreparedStatement statement = database.newStatement("SELECT songID, artistID, albumID, genreID, " +
                "songName, trackNo, songLength FROM Songs WHERE songID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Songs(results.getInt("songID"), results.getInt("artistID"),
                            results.getInt("albumID"), results.getInt("genreID"),
                            results.getString("songName"), results.getInt("trackNo"),
                            results.getInt("songLength"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Songs WHERE songID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }
    public static void save(Songs itemToSave, DatabaseConnection database) {

        Songs existingItem = null;
        if (itemToSave.getSongID() != 0) existingItem = selectById(itemToSave.getSongID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Songs (artistID, albumID, " +
                        "genreID, songName, trackNo, songLength) VALUES (?, ?, ?, ?, ?, ?))");
                statement.setInt(1, itemToSave.getArtistID());
                statement.setInt(2, itemToSave.getAlbumID());
                statement.setInt(3, itemToSave.getGenreID());
                statement.setString(4, itemToSave.getSongName());
                statement.setInt(5, itemToSave.getTrackNo());
                statement.setInt(6, itemToSave.getSongLength());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Songs SET artistID = ?, albumID = ?, " +
                        "genreID = ?, songName = ?, trackNo = ?, songLength = ? WHERE songID = ?");
                statement.setInt(1, itemToSave.getArtistID());
                statement.setInt(2, itemToSave.getAlbumID());
                statement.setInt(3, itemToSave.getGenreID());
                statement.setString(4, itemToSave.getSongName());
                statement.setInt(5, itemToSave.getTrackNo());
                statement.setInt(6, itemToSave.getSongLength());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }