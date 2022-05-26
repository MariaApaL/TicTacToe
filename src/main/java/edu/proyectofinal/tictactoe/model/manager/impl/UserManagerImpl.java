package edu.proyectofinal.tictactoe.model.manager.impl;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;
//import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.dao.UserDao;
import edu.proyectofinal.tictactoe.model.manager.UserManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements UserManager {


    public boolean findUser(Connection con, String player_name, String password) {
        //prepare SQL statement
        String sql = "select * "
                + "from PLAYER "
                + "where PLAYER_NAME = ? and PASSWORD = ?";

        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            //Add Parameters
            stmt.setString(1, player_name);
            stmt.setString(2, password);



            // Queries the DB
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable
            UserDao user = null;

            return result.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int insertUser(Connection con, String player_name, String password) {
        //prepare SQL statement
        String sql = "Insert into player (PLAYER_NAME, PASSWORD, NUM_GAME ) VALUES (?,?,0)";


        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            //Add Parameters
            stmt.setString(1, player_name);
            stmt.setString(2, password);
            int affectedRows = stmt.executeUpdate();
            if(affectedRows<=0){
                return 0;
            }

            ResultSet resultSet = stmt.getGeneratedKeys();
            resultSet.beforeFirst();
            resultSet.next();

            return resultSet.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

         /*   // Queries the DB
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable

*/


        }
    }
    @Override
    public boolean updateNumGame(Connection con, String name) throws SQLException{
        String sql="Update player set num_game= (num_game +1)where player_name=?";

        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1, name);
            return stmt.executeUpdate() > 0;

        }catch(SQLException e){
        return false;}

    }

    @Override
    public boolean deleteUser(Connection con) throws SQLException {
        String sql = "DELETE player WHERE player_name = ?";
        try (PreparedStatement stmt= con.prepareStatement(sql)){

            stmt.setString(1, App.getNamePlayer());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List ranking(Connection con) throws SQLException {
        String sql = "select *  from PLAYER  order  by  num_game desc limit 10";
        try(Statement stmt=con.createStatement()){
            ResultSet result = stmt.executeQuery(sql);
            result.beforeFirst();

            List players = new ArrayList();

            while (result.next()) {
                int a=0;
                players.add((result));

            }

            return players;

        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int numGame(Connection con) throws SQLException {
        String sql = "select num_game  from PLAYER  where player_name=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1, App.getNamePlayer());
            ResultSet result = stmt.executeQuery(sql);
            result.beforeFirst();

            return result.getInt(1);

        }catch(SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean updateSuggestions (Connection con, String suggestions){
        String sql="Update player set quejas= ? where player_name=?";

        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1, suggestions);
            stmt.setString(2, App.getNamePlayer() );
            return stmt.executeUpdate() > 0;

        }catch(SQLException e){
        return false;
        }
    }



    @Override
    public MySQLConnector getConnector() {
        return new MySQLConnector();
    }










}