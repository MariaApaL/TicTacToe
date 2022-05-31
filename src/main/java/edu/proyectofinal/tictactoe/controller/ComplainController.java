package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ComplainController implements Initializable {

    @FXML
    private TextField text;

    private UserService userService;

    public void submitSuggestions(ActionEvent event) throws IOException {

        String queja=text.getText();
        String nombre= App.getNamePlayer();

        try{
            int createSuggestion= suggestionsService.insertSuggestion(nombre,queja);
            if(createSuggestion  > 0){
                // App.setStage("secondmenuInterface");
                text.setText("");
                App.setSuggestion(queja);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }


    public void switchToSecondMenu(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userService = new UserService(new UserManagerImpl());
    }
}
