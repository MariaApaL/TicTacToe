package edu.proyectofinal.tictactoe.service;

import edu.proyectofinal.tictactoe.model.manager.SuggestionsManager;

import java.sql.Connection;
import java.sql.SQLException;
import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;

public class SuggestionsService {

    private final SuggestionsManager suggestionManager;


    public SuggestionsService(SuggestionsManager suggestionManager) {
        this.suggestionManager = suggestionManager;
    }


    public int insertSuggestion( String text) throws SQLException,ClassNotFoundException{
        SuggestionsManager.getConnectorSuggestion();
        try (Connection con = MySQLConnector.getMySQLConnection()) {
            return suggestionManager.insertSuggestion(con, text);


        }

    }
}
