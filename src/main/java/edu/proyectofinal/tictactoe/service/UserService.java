package edu.proyectofinal.tictactoe.service;


import edu.proyectofinal.tictactoe.model.manager.UserManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserManager userManager;


    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean validateUser(String username, String password) {
        try (Connection con = userManager.getConnector().getMySQLConnection()) {

            return userManager.findUser(con, username, password);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    public int insertUserReg(String username, String password, String mail) throws SQLException,ClassNotFoundException{
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.insertUser(con, username, password, mail);


        }

    }


    public boolean newGame(String name) throws SQLException, ClassNotFoundException{

        try(Connection con=userManager.getConnector().getMySQLConnection()){
            return userManager.updateNumGame(con, name);
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

    public int numGame() throws SQLException, ClassNotFoundException{
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.numGame(con);
        }
    }


    public boolean updatePassword( String contraseña) throws SQLException, ClassNotFoundException {
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.updatePassword(con, contraseña);
        }

    }
    public boolean validatePassword( String password) throws SQLException, ClassNotFoundException {
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.validatePassword(con, password);
        }

    }

    public String getMail() throws SQLException, ClassNotFoundException {
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.getMail(con);
        }

    }

}
