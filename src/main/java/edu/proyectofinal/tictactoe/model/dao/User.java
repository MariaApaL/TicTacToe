package edu.proyectofinal.tictactoe.model.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
public class User {
    int idplayer;
    String player_name;
    String password;

    public User() {

    }

    public User(ResultSet result) {
        try {
            this.idplayer = result.getInt("idplayer");
            this.player_name = result.getString("player_name");
            this.password = result.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User(int id, String username, String password) {
        this.idplayer=id;
        this.player_name=username;
        this.password=password;
    }

}
