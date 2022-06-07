package edu.proyectofinal.tictactoe.model.dao;


import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


@ToString
public class Player {


    public Player() {

    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPassword() {
        return password;
    }

    public int getNumGame() {
        return numGame;
    }

    public String getMail() { return mail;}


    int idPlayer;
     String playerName;
     String password;
     int numGame;



    String mail;


    public Player(ResultSet result) {
        try {
            this.idPlayer = result.getInt("idplayer");
            this.playerName = result.getString("player_name");
            this.password = result.getString("password");
            this.numGame=result.getInt("num_game");
            this.mail=result.getString("correo");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumGame(int numGame) {
        this.numGame = numGame;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public void setMail(String mail) { this.mail = mail; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return idPlayer == player.idPlayer && numGame == player.numGame && playerName.equals(player.playerName) && password.equals(player.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer, playerName, password, numGame);
    }



}
