package edu.proyectofinal.tictactoe.model.manager;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.excepciones.exception;
import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserManager {
    public boolean findUser(Connection con, String player_name, String password);



    public MySQLConnector getConnector();

    public int insertUser(Connection con, String player_name, String password, String mail)throws SQLException;

    public boolean updateNumGame(Connection con, String name)throws SQLException;

    public boolean deleteUser(Connection con) throws SQLException;

    public List ranking(Connection con) throws SQLException;

    public int numGame(Connection con)throws SQLException;

    public boolean updateSuggestions (Connection con, String suggestions);

    public boolean updatePassword(Connection con, String contraseña) throws SQLException, exception;

    public boolean validatePassword(Connection con, String password) throws SQLException;

}

