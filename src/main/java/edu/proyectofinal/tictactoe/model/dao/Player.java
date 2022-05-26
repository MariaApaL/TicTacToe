package edu.proyectofinal.tictactoe.model.dao;

import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Getter
@Setter
@ToString
public class Player {
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

    int idPlayer;
     String playerName;
     String password;
     int numGame;










    public Player(ResultSet result) {
        try {
            this.idPlayer = result.getInt("idplayer");
            this.playerName = result.getString("player_name");
            this.password = result.getString("password");
            this.numGame=result.getInt("num_game");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/*
    public UserDao( String username, String password) {

        this.player_name=username;
        this.password=password;
    }
    public static int login(String user, String password){

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        int state = -1;

        try{

            connection = MySQLConnector.getMySQLConnection();

            if(connection!=null){

                String sql = "SELECT * FROM player WHERE playername=? AND password=?";

                pst = connection.prepareStatement(sql);
                pst.setString(1, user);
                pst.setString(2, password);

                rs = pst.executeQuery();

                if(rs.next()){
                    state = 1;
                }else{
                    state = 0;
                }

            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al conectarse con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Hubo un error de ejecución, posibles errores:\n"
                    + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{

            try{
                if(connection != null){
                    connection.close();

                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }

        }


        return state;

    }
    */


}
