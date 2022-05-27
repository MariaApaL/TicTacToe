package edu.proyectofinal.tictactoe.controller;


import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    public void switchToStart(ActionEvent event) throws IOException{
        App.setStage("start");
    }

    public void switchToRanking(ActionEvent event) throws IOException{
        App.setStage("rankingInterface");
    }

    public void switchToSecondMenu(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");
    }
    public void switchToAI(ActionEvent event) throws IOException{
        App.setStage("tictactoeAI");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService= new UserService(new UserManagerImpl());
    }


}
