package edu.proyectofinal.tictactoe.controller;


import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PruebaController implements Initializable {
private UserService userService;


    public void switchToTictactoe(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String playerName=App.getNamePlayer();
        userService.newGame(playerName);
        App.setStage("tictactoe");

    }

    public void switchToLogin(ActionEvent event) throws IOException{
        App.setStage("loginInterface");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService= new UserService(new UserManagerImpl());
    }
}
