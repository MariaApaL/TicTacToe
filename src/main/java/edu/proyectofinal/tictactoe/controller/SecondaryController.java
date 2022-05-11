package edu.proyectofinal.tictactoe.controller;

import java.io.IOException;

import edu.proyectofinal.tictactoe.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}