package edu.proyectofinal.tictactoe.service;


import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.manager.UserManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserManager userManager;


    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean findUser(String username, String password) {
        try (Connection con = userManager.getConnector().getMySQLConnection()) {

            return userManager.findUser(con, username, password);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Player insertUserReg(String username, String password, String mail) throws SQLException,ClassNotFoundException{
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
           if(userManager.insertUser(con, username, password, mail)>0){
               return userManager.findByName(con, username);

           }
            return null;



        }}




    public Player newGame() throws SQLException, ClassNotFoundException{

        try(Connection con=userManager.getConnector().getMySQLConnection()){
            return userManager.updateNumGame(con);
        }


    }

    public boolean deleteUser() throws SQLException, ClassNotFoundException {

        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.deleteUser(con);
        }
    }

    public List ranking() throws SQLException, ClassNotFoundException{
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.ranking(con);
        }
    }




    public Player updatePassword( String contraseña) throws SQLException, ClassNotFoundException {
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.updatePassword(con, contraseña);
        }

    }




    public Player findByName( String player_name) throws SQLException, ClassNotFoundException {

        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.findByName(con, player_name);
        }
    }




}
