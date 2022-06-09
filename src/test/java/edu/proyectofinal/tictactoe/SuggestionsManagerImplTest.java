package edu.proyectofinal.tictactoe;

import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.dao.Suggestion;
import edu.proyectofinal.tictactoe.model.manager.impl.SuggestionsManagerImpl;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@ExtendWith({MockitoExtension.class})

public class SuggestionsManagerImplTest {

    @Mock
    private Connection connection;

    @Mock
    private Suggestion suggestion;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;


    private SuggestionsManagerImpl suggestionsManager;

    @BeforeEach
    void init() {
        suggestionsManager = new SuggestionsManagerImpl();
    }

    @Test
    void insertSuggestion_ok() throws SQLException {

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


        Suggestion expectedSuggestion = suggestionsManager.insertSuggestion(connection,"",expectedPlayer);

        MatcherAssert.assertThat(suggestion.getPlayer_name(), Matchers.is(expectedSuggestion.getPlayer_name()));

    }

    @Test
    void findBySuggestion_ok() throws SQLException {

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


        Suggestion expectedSuggestion = suggestionsManager.findBySuggestion(connection,"");

        MatcherAssert.assertThat(expectedSuggestion.getPlayer_name(), Matchers.is(suggestion.getPlayer_name()));

    }

}

