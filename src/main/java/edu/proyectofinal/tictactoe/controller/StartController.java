package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {


    @FXML
    private Button startButton;


    private UserService userService;

    public void switchToLogin(ActionEvent event) throws IOException {
        App.setStage("loginInterface");

    }

    public void switchToRegister(ActionEvent event) throws IOException {
        App.setStage("registerInterface");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService=new UserService(new UserManagerImpl());
    }
}
