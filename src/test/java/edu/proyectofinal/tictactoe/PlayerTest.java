package edu.proyectofinal.tictactoe;


import edu.proyectofinal.tictactoe.model.dao.Player;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.SQLException;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class PlayerTest {

    @Mock
    private ResultSet resultSet;



    @Test
    void player_ok() throws SQLException {

        Player player = new Player();

        player.setIdPlayer(1);
        player.setPlayerName("Maria");
        player.setPassword("12345");
        player.setNumGame(3);

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("player_name")){
                    return player.getPlayerName();
                } else if(invocationOnMock.getArgument(0).equals("password")) {
                    return player.getPassword();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {

            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("num_game")){
                    return player.getNumGame();
                } else if(invocationOnMock.getArgument(0).equals("idplayer")) {
                    return player.getIdPlayer();
                }else{
                    return null;
                }
            }
        });


        Player player1 = new Player(resultSet);
        assertEquals(player1,player);

    }





    }



