package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartController {


    @FXML
    private Button startButton;

    public void switchToLogin(ActionEvent event) throws IOException {
        App.setStage("loginInterface");

    }

    public void switchToRegister(ActionEvent event) throws IOException {
        App.setStage("registerInterface");

    }
}
