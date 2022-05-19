package edu.proyectofinal.tictactoe.model.manager.impl;

import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;
import edu.proyectofinal.tictactoe.model.dao.User;
import edu.proyectofinal.tictactoe.model.manager.UserManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManagerImpl implements UserManager {

    public boolean findUser(Connection con, String name, String pass) {
        //prepare SQL statement
        String sql = "select * "
                + "from users "
                + "where username = ? and password = ?";

        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            //Add Parameters
            stmt.setString(1, name);
            stmt.setString(2, pass);
            // Queries the DB
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable
            User user = null;

            return result.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public MySQLConnector getConnector() {
        return new MySQLConnector();
    }

}