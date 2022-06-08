package edu.proyectofinal.tictactoe.model.manager;

import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.dao.Suggestion;

public interface SuggestionsManager {
    /**
     * Insert a new suggestion on DB
     *
     * @param con DB connection
     * @param text the suggestion to insert
     * @return a {@link Boolean}
     */
    public Suggestion insertSuggestion(Connection con, String text)throws SQLException;

    public Suggestion findBySuggestion(Connection con, String queja);

    public MySQLConnector getConnector();

}
