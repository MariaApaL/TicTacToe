package edu.proyectofinal.tictactoe.model.manager;

import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;

import java.sql.Connection;

public interface UserManager {
    public boolean findUser(Connection con, String player_name, String password);

    public MySQLConnector getConnector();

    public int insertUser(Connection con, String player_name, String password);
}
