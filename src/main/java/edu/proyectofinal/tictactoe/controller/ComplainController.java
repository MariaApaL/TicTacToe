package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ComplainController implements Initializable {


    public void switchToSecondMenu(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
