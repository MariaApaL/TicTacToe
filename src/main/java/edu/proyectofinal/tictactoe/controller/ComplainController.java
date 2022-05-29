package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.manager.impl.SuggestionsManagerImpl;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.SuggestionsService;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ComplainController implements Initializable {
    private UserService userService;
    private SuggestionsService suggestionsService;

    @FXML
    private TextField text;

    @FXML
    private Button submit;




    public void submitSuggestions(ActionEvent event) throws IOException {

        String queja=text.getText();
        String nombre= App.getNamePlayer();

        try{
            int createSuggestion= suggestionsService.insertSuggestion(nombre,queja);
            if(createSuggestion  > 0){
            App.setStage("secondmenuInterface");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    public void  switchToSecondMenu(ActionEvent event) throws IOException {

     try{
         App.setStage("secondmenuInterface");
     } catch (IOException e) {
         e.printStackTrace();
     }


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService=new UserService(new UserManagerImpl());
        suggestionsService=new SuggestionsService(new SuggestionsManagerImpl());

    }
}
