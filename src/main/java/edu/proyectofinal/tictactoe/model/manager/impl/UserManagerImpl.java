package edu.proyectofinal.tictactoe.model.manager.impl;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.connector.MySQLConnector;


import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.manager.UserManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements UserManager {

    @Override
    public boolean findUser(Connection con, String player_name, String password) {
        //prepare SQL statement
        String sql = "select * "
                + "from PLAYER "
                + "where PLAYER_NAME = ? and password=?";

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
            Player user = null;

            while(result.next()){
                 user=(new Player(result));
            }
            if(user!=null){
                return true;
            }else{return false;}



        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Player findByName(Connection con, String player_name) {
        //prepare SQL statement
        String sql = "select * "
                + "from PLAYER "
                + "where PLAYER_NAME = ?";

        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            //Add Parameters
            stmt.setString(1, player_name);

            // Queries the DB
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable
            Player user = null;
            while(result.next()){
                user=(new Player(result));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public int insertUser(Connection con, String player_name, String password, String mail) {
        //prepare SQL statement
        String sql = "Insert into player (PLAYER_NAME, PASSWORD, NUM_GAME , correo) VALUES (?,?, 0,?)";


        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            //Add Parameters
            stmt.setString(1, player_name);
            stmt.setString(2, password);
            stmt.setString(3, mail);
            int affectedRows = stmt.executeUpdate();
            if(affectedRows<=0){
                return 0;
            }else {
                ResultSet resultSet = stmt.getGeneratedKeys();
                // Set before first registry before going through it
                resultSet.beforeFirst();
                resultSet.next();


                // Queries the DB
                return resultSet.getInt(1);
                /*
                // Queries the DB
                ResultSet resultSet = stmt.getGeneratedKeys();
                // Set before first registry before going through it
                resultSet.beforeFirst();
                resultSet.next();
                Player player=null;

                while(resultSet.next()){player=(new Player(resultSet));
                }
                return player;
                */





            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;






        }
    }
    @Override
    public Player updateNumGame(Connection con) throws SQLException{

        //prepare SQL statement
        String sql="Update player set num_game= (num_game +1)where idPlayer=?";

        //prepare SQL statement
        try(PreparedStatement stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS )){

            //Add Parameters
            stmt.setInt(1, App.getUser().getIdPlayer());
            int affectedRows = stmt.executeUpdate();
            if(affectedRows<=0){
                return null;}else{


            // Queries the DB
            return findByName(con, App.getUser().getPlayerName());}

        }catch(SQLException e){
        return null;}

    }

    @Override
    public boolean deleteUser(Connection con) throws SQLException {
        //prepare SQL statement
        String sql = "DELETE from player WHERE idPlayer = ?";

        // Create general statement
        try (PreparedStatement stmt= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            //Add Parameters
            stmt.setInt(1, App.getUser().getIdPlayer());

            // Queries the DB
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    @Override
    public List ranking(Connection con) throws SQLException {
        //prepare SQL statement
        String sql = "select player_name  from PLAYER  order  by  num_game desc limit 10";

        // Create general statement
        try(Statement stmt=con.createStatement()){
            // Queries the DB
            ResultSet result = stmt.executeQuery(sql);
            // Set before first registry before going through it
            result.beforeFirst();

            // Initialize variable
            List players = new ArrayList();

            // Run through each result
            while (result.next()) {
               /* int a=1;
               String player=result;
                String aux= String.valueOf(a);
                */


                // Initializes a player per result
                players.add(result.getString(1));

            }

            return players;

        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Player updatePassword(Connection con, String contraseña) throws SQLException {
        //prepare SQL statement
        String sql="Update player set password= ?where idplayer=?";


        try {

            //Validate that the password is correct
            findUser(con,App.getUser().getPlayerName(), contraseña);

            // Create general statement
            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                //Add Parameters
                stmt.setString(1, contraseña);
                stmt.setInt(2, App.getUser().getIdPlayer());

                // Queries the DB

                int affectedRows = stmt.executeUpdate();
                if(affectedRows<=0){
                    return null;}else{


                    // Queries the DB
                    return findByName(con, App.getUser().getPlayerName());}

            } }  catch (SQLException e) {
                return null;

        }

    }




    @Override
    public MySQLConnector getConnector() {
        return new MySQLConnector();
    }










}