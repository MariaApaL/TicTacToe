package edu.proyectofinal.tictactoe;

import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class UserManagerImplTest {

    @Mock
    private Connection connection;

    @Mock
    private Statement statement;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;


    private UserManagerImpl userManager;

    @BeforeEach
    void init() {
        userManager = new UserManagerImpl();
    }

    @Test
    void findUser_ok() throws SQLException {

        Player expectedPlayer = new Player();
                expectedPlayer.setPlayerName("Maria");
                expectedPlayer.setIdPlayer(526236245);
                expectedPlayer.setPassword("123456");
                expectedPlayer.setNumGame(7);

        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                if(counter < 1){
                    counter++;
                    return true;
                } else {
                    return false;
                }
            }
        });

        boolean player = userManager.findUser(connection,"Maria","12345");


        MatcherAssert.assertThat(player, Matchers.is(true));


    }

    @Test
    void findByName_ok() throws SQLException{
        Player expectedPlayer = new Player();
        expectedPlayer.setPlayerName("Maria");
        expectedPlayer.setIdPlayer(526236245);
        expectedPlayer.setPassword("123456");
        expectedPlayer.setNumGame(7);


        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                if(counter < 1){
                    counter++;
                    return true;
                } else {
                    return false;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("player_name")){
                    return expectedPlayer.getPlayerName();
                } else if(invocationOnMock.getArgument(0).equals("password")) {
                    return expectedPlayer.getPassword();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {

            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("num_game")){
                    return expectedPlayer.getNumGame();
                } else if(invocationOnMock.getArgument(0).equals("idplayer")) {
                    return expectedPlayer.getIdPlayer();
                }else{
                    return null;
                }
            }
        });

        Player player = userManager.findByName(connection,"");

        MatcherAssert.assertThat(player, Matchers.is(expectedPlayer));


    }


    @Test
    void insertUser_ok() throws SQLException {

        Player expectedPlayer = new Player();
            expectedPlayer.setPlayerName("Maria");
            expectedPlayer.setIdPlayer(526236245);
            expectedPlayer.setPassword("123456");
            expectedPlayer.setNumGame(7);

        when(connection.prepareStatement(any(),eq(1))).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        when(resultSet.getInt(eq(1))).thenReturn(1);


        int player = userManager.insertUser(connection,"Maria","","");

        MatcherAssert.assertThat(player, Matchers.is(1));

    }


    @Test
    void updateNumGame_ok() throws SQLException {

        Player expectedPlayer = new Player();
        expectedPlayer.setPlayerName("Maria");
        expectedPlayer.setIdPlayer(526236245);
        expectedPlayer.setPassword("123456");
        expectedPlayer.setNumGame(7);

        when(connection.prepareStatement(any(),eq(1))).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                if(counter < 1){
                    counter++;
                    return true;
                } else {
                    return false;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("player_name")){
                    return expectedPlayer.getPlayerName();
                } else if(invocationOnMock.getArgument(0).equals("password")) {
                    return expectedPlayer.getPassword();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {

            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("num_game")){
                    return expectedPlayer.getNumGame();
                } else if(invocationOnMock.getArgument(0).equals("idplayer")) {
                    return expectedPlayer.getIdPlayer();
                }else{
                    return null;
                }
            }
        });

        Player player = userManager.updateNumGame(connection,expectedPlayer);

        MatcherAssert.assertThat(player, Matchers.is(expectedPlayer));

    }


    @Test
    void deleteUser_ok() throws SQLException {

        Player expectedPlayer = new Player();
        expectedPlayer.setPlayerName("Maria");
        expectedPlayer.setIdPlayer(526236245);
        expectedPlayer.setPassword("123456");
        expectedPlayer.setNumGame(7);

        when(connection.prepareStatement(any(),eq(1))).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);


        boolean player = userManager.deleteUser(connection, expectedPlayer);

        MatcherAssert.assertThat(player, Matchers.is(true));


    }
/*
    @Test
    void ranking_ok() throws SQLException {

        Player expectedPlayer = new Player();
        expectedPlayer.setPlayerName("Maria");
        expectedPlayer.setIdPlayer(526236245);
        expectedPlayer.setPassword("123456");
        expectedPlayer.setNumGame(7);

        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(any())).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                if(counter < 1){
                    counter++;
                    return true;
                } else {
                    return false;
                }
            }
        });



        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {

            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("num_game")){
                    return expectedPlayer.getNumGame();
                } else if(invocationOnMock.getArgument(0).equals("idplayer")) {
                    return expectedPlayer.getIdPlayer();
                }else{
                    return null;
                }
            }
        });


        List player = userManager.ranking(connection);

        MatcherAssert.assertThat(player, Matchers.is(expectedPlayer));


    }




    @Test
    void updatePassword_ok() throws SQLException {

        Player expectedPlayer = new Player();
        expectedPlayer.setPlayerName("Maria");
        expectedPlayer.setIdPlayer(526236245);
        expectedPlayer.setPassword("123456");
        expectedPlayer.setNumGame(7);

        when(connection.prepareStatement(any(),eq(1))).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                if(counter < 1){
                    counter++;
                    return true;
                } else {
                    return false;
                }
            }
        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("player_name")){
                    return expectedPlayer.getPlayerName();
                } else if(invocationOnMock.getArgument(0).equals("password")) {
                    return expectedPlayer.getPassword();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {

            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("num_game")){
                    return expectedPlayer.getNumGame();
                } else if(invocationOnMock.getArgument(0).equals("idplayer")) {
                    return expectedPlayer.getIdPlayer();
                }else{
                    return null;
                }
            }
        });



        Player player = userManager.updatePassword(connection, expectedPlayer, "");

        MatcherAssert.assertThat(player, Matchers.is(expectedPlayer));


    }


*/


}
