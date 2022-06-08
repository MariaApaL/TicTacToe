package edu.proyectofinal.tictactoe;
import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.dao.Suggestion;
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
public class SuggestionTest {

    @Mock
    private ResultSet resultSet;

    @Test
    void suggestion_ok() throws SQLException {

        Suggestion suggestion = new Suggestion();

            suggestion.setIdSuggestion(1);
            suggestion.setPlayer_name("Maria");
            suggestion.setSuggestion("patata");


        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("player_name")){
                    return suggestion.getPlayer_name();
                } else if(invocationOnMock.getArgument(0).equals("suggestion")) {
                    return suggestion.getSuggestion();
                }else{
                    return null;
                }
            }
        });

        when(resultSet.getInt(any())).thenReturn(1);


        Suggestion suggestion1 = new Suggestion(resultSet);
        assertEquals(suggestion1,suggestion);

    }


}
