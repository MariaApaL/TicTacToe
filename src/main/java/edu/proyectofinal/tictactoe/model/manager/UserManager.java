package edu.proyectofinal.tictactoe.model.manager;

import edu.proyectofinal.tictactoe.App;

import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;
import edu.proyectofinal.tictactoe.model.dao.Player;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserManager {
    /**
     * Validates that the user exist.
     *
     * @param con DB connection
     * @param player_name The entity to check
     * @return a {@link Boolean}
     */
    public boolean findUser(Connection con, String player_name, String password);



    public MySQLConnector getConnector();

   public Player findByName(Connection con, String player_name);

    /**
     * Insert a new user on DB
     *
     * @param con DB connection
     * @param player_name The entity to check
     * @param password The entity to create
     * @return a {@link Boolean}
     */
    public int insertUser(Connection con, String player_name, String password, String mail)throws SQLException;
    /**
     * player update num_game on DB
     *
     * @param con DB connection
     * @return a {@link Boolean}
     */
    public Player updateNumGame(Connection con)throws SQLException;
    /**
     * Delete a user using their names.
     *
     * @param con DB connection
     * Using App.getPlayerName to delete.
     * @return a {@link Boolean}
     */
    public boolean deleteUser(Connection con) throws SQLException;
    /**
     * Show the top ten users with the most games played
     *
     * @param con DB connection
     * @return a {@link List}
     */
    public List ranking(Connection con) throws SQLException;


    /**
     * Update password on DB.
     *
     * @param con DB connection
     * @param contraseña Entities password to delete.
     * @return a {@link Boolean}
     */
    public Player updatePassword(Connection con, String contraseña) throws SQLException;




}

