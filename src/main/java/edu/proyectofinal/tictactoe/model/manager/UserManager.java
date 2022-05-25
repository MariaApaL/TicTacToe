package edu.proyectofinal.tictactoe.model.manager;

import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserManager {
    public boolean findUser(Connection con, String player_name, String password);

    public MySQLConnector getConnector();

    public int insertUser(Connection con, String player_name, String password);

    public boolean updateNumGame(Connection con, String name);

    public boolean deleteUser(Connection con) throws SQLException;

    public List ranking(Connection con) throws SQLException;
}

