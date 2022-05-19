package edu.proyectofinal.tictactoe.controller;


import edu.proyectofinal.tictactoe.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PruebaController implements Initializable {



    public void switchToTictactoe(ActionEvent event) throws IOException{
        App.setStage("tictactoe");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
