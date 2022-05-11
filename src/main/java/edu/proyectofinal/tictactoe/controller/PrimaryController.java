package edu.proyectofinal.tictactoe.controller;

import java.io.IOException;

import edu.proyectofinal.tictactoe.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
