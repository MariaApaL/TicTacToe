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

    int id;
    String username;
    String password;

    public User() {

    }

    public User(ResultSet result) {
        try {
            this.id = result.getInt("id");
            this.username = result.getString("username");
            this.password = result.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User(int id, String username, String password) {
        this.id=id;
        this.username=username;
        this.password=password;
    }

}
