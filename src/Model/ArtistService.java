package Model;

import Model.Artists;
import Model.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArtistService {
    public static void selectAll(List<Artists> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT artistID, artistName, bio, " +
                "genreID FROM Artists ORDER BY artistID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Artists(results.getInt("artistID"), results.getString("artistName"),
                                results.getString("bio"), results.getInt("genreID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }


    public static Artists selectById(int id, DatabaseConnection database){
        Artists result = null;

        PreparedStatement statement = database.newStatement("SELECT artistID, artistName, bio, genreID FROM Artists WHERE id = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Artists(results.getInt("artistID"), results.getString("artistName"), results.getString("bio"), results.getInt("genreID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Artists WHERE id = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }

    public static void save(Artists itemToSave, DatabaseConnection database) {

        Artists existingItem = null;
        if (itemToSave.getArtistID() != 0) existingItem = selectById(itemToSave.getArtistID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Artists (artistName, artistBio, genreID) VALUES (?, ?, ?))");
                statement.setString(1, itemToSave.getName());
                statement.setString(2, itemToSave.getBio());
                statement.setInt(3, itemToSave.getGenreID());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Artists SET artistName = ?, artistBio = ?, genreID = ? WHERE id = ?");
                statement.setString(1, itemToSave.getName());
                statement.setString(2, itemToSave.getBio());
                statement.setInt(3, itemToSave.getGenreID());
                statement.setInt(4, itemToSave.getArtistID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}



