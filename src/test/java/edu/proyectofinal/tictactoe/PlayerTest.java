package edu.proyectofinal.tictactoe;


import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayerTest {



    @Test
    void getIdPlayer_ok() throws SQLException {

        ResultSet result = result.getInt("idplayer");
        assertEquals(result, );

    }

    @Test
    void getPlayerName_ok() throws SQLException, ClassNotFoundException {

        ResultSet result = result.getString("player_name")
        assertEquals(result, );

    }

    @Test
    void getPassword_ok() throws SQLException, ClassNotFoundException {

        ResultSet result = result.getString("password")
        assertEquals(result, );

    }

    @Test
    void getPassword_ok() throws SQLException, ClassNotFoundException {

        ResultSet result = result.getInt("num_game")
        assertEquals(result, );

    }






 @BeforeAll
    public static void initializeAll() throws ClassCastException, SQLException {


 }

 @BeforeEach
    public static void initialize(){

 }



 @AfterEach
 public static void destroy() throws ClassCastException,SQLException{

 }

 @AfterAll
    public static void destroyAll() throws ClassCastException, SQLException{

 }
}
