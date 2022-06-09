package edu.proyectofinal.tictactoe.model.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class Suggestion {

    public void setIdSuggestion(int idSuggestion) {
        this.idSuggestion = idSuggestion;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    int idSuggestion;

    public int getIdSuggestion() {
        return idSuggestion;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getSuggestion() {
        return suggestion;
    }

    String player_name;
    String suggestion;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suggestion that = (Suggestion) o;
        return idSuggestion == that.idSuggestion && player_name.equals(that.player_name) && suggestion.equals(that.suggestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSuggestion, player_name, suggestion);
    }

    public Suggestion(){

    }

    public Suggestion(ResultSet result) {
        try {
            this.idSuggestion = result.getInt("idSuggestions");
            this.player_name = result.getString("player_name");
            this.suggestion = result.getString("suggestion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
