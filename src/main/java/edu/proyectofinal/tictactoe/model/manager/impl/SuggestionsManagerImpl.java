package edu.proyectofinal.tictactoe.model.manager.impl;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;
import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.dao.Suggestion;
import edu.proyectofinal.tictactoe.model.manager.SuggestionsManager;

import java.sql.*;

public class SuggestionsManagerImpl implements SuggestionsManager {
    @Override
    public Suggestion insertSuggestion(Connection con, String text, Player player) throws SQLException {
        //prepare SQL statement
        String sql = "Insert into Suggestions (PLAYER_NAME, suggestion) VALUES (?,?)";


        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            //Add Parameters
            stmt.setString(1, player.getPlayerName());
            stmt.setString(2, text);

            int affectedRows = stmt.executeUpdate();
            if(affectedRows<=0){

                return null;}else{


                // Queries the DB
                return findBySuggestion(con,text);}




            // Queries the DB


        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public Suggestion findBySuggestion(Connection con, String queja) {
        //prepare SQL statement
        String sql = "select * "
                + "from suggestions "
                + "where suggestion = ?";

        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            //Add Parameters
            stmt.setString(1,queja);

            // Queries the DB
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable
            Suggestion sugu = null;
            while(result.next()){
                sugu=(new Suggestion(result));
            }
            return sugu;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public MySQLConnector getConnector() {
        return new MySQLConnector();
    }
}
