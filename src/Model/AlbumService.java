package Model;

import Model.Albums;
import Model.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlbumService {

    public static void selectAll(List<Albums> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT albumID, artistID, albumName, " +
                "albumYear, albumLength, genreID FROM Albums ORDER BY albumID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Albums(results.getInt("albumID"), results.getInt("artistID"),
                                results.getString("albumName"), results.getInt("albumYear"),
                                results.getInt("albumLength"), results.getInt("genreID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static Albums selectById(int id, DatabaseConnection database) {

        Albums result = null;

        PreparedStatement statement = database.newStatement("SELECT albumID, artistID, albumName, " +
                "albumYear, albumLength, genreID FROM Albums WHERE albumID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Albums(results.getInt("albumID"), results.getInt("artistID"),
                            results.getString("albumName"), results.getInt("albumYear"),
                            results.getInt("albumLength"), results.getInt("genreID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Albums WHERE albumID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }
    public static void save(Albums itemToSave, DatabaseConnection database) {

        Albums existingItem = null;
        if (itemToSave.getAlbumID() != 0) existingItem = selectById(itemToSave.getAlbumID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Table (artistID, albumName, albumYear, albumLength, genreID) VALUES (?, ?, ?, ?, ?))");
                statement.setInt(1, itemToSave.getArtistID());
                statement.setString(2, itemToSave.getAlbumName());
                statement.setInt(3, itemToSave.getAlbumYear());
                statement.setInt(4, itemToSave.getAlbumLength());
                statement.setInt(5, itemToSave.getGenreID());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Table SET artistID = ?, artistName = ?, albumYear = ?, albumLength = ?, genreID = ? WHERE albumID = ?");
                statement.setInt(1, itemToSave.getArtistID());
                statement.setString(2, itemToSave.getAlbumName());
                statement.setInt(3, itemToSave.getAlbumYear());
                statement.setInt(4, itemToSave.getAlbumLength());
                statement.setInt(3, itemToSave.getGenreID());
                statement.setInt(6, itemToSave.getAlbumID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }

}
