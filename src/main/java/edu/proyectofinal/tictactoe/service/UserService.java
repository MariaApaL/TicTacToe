package edu.proyectofinal.tictactoe.service;

import edu.proyectofinal.tictactoe.excepciones.exception;
import edu.proyectofinal.tictactoe.model.dao.UserDao;
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

    public int insertUserReg(String username, String password) throws SQLException,ClassNotFoundException{
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.insertUser(con, username, password);


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

    public List<UserDao> ranking() throws SQLException, ClassNotFoundException{
        try (Connection con = userManager.getConnector().getMySQLConnection()) {
            return userManager.ranking(con);
        }
    }

    }
