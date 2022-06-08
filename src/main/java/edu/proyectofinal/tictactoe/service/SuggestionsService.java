package edu.proyectofinal.tictactoe.service;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.dao.Suggestion;
import edu.proyectofinal.tictactoe.model.manager.SuggestionsManager;

import java.sql.Connection;
import java.sql.SQLException;
import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;

public class SuggestionsService {

    private final SuggestionsManager suggestionsManager;


    public SuggestionsService(SuggestionsManager suggestionManager) {
        this.suggestionsManager = suggestionManager;
    }


    public Suggestion insertSuggestion( String text) throws SQLException,ClassNotFoundException{

        try (Connection con = suggestionsManager.getConnector().getMySQLConnection()) {
            return suggestionsManager.insertSuggestion(con, text, App.getUser());


        }

    }

    public Suggestion findBySuggestion(String queja)throws SQLException,ClassNotFoundException{

        try (Connection con = suggestionsManager.getConnector().getMySQLConnection()) {
            return suggestionsManager.findBySuggestion(con,queja);


        }

    }

}
