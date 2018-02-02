package Model;

import Model.Genres;
import Model.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GenreService {

    public static void selectAll(List<Genres> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT genreID, genreName FROM Albums ORDER BY genreID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Genres(results.getInt("genreID"), results.getString("genreName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static Genres selectById(int genreID, DatabaseConnection database) {

        Genres result = null;

        PreparedStatement statement = database.newStatement("SELECT genreID, genreName FROM Genres WHERE genreID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, genreID);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Genres(results.getInt("genreID"), results.getString("genreName"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
    public static void deleteById(int genreID, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Genres WHERE genreID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, genreID);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }
    public static void save(Genres itemToSave, DatabaseConnection database) {

        Genres existingItem = null;
        if (itemToSave.getGenreID() != 0) existingItem = selectById(itemToSave.getGenreID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Genres (genreName) VALUES (?))");
                statement.setString(1, itemToSave.getGenreName());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Genres SET genreName = ? WHERE genreID = ?");
                statement.setString(1, itemToSave.getGenreName());
                statement.setInt(2, itemToSave.getGenreID());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }

}
