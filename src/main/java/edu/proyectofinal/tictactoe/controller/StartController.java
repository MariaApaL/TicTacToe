package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import javafx.event.ActionEvent;

import java.io.IOException;

/**
 * Start class.
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 */
public class StartController {



    /**
     * Switch to login interface
     * @param event
     *
     */
    public void switchToLogin(ActionEvent event) throws IOException {
        App.setStage("loginInterface");

    }

    /**
     * Switch to register interface
     * @param event
     *
     */
    public void switchToRegister(ActionEvent event) throws IOException {
        App.setStage("registerInterface");

    }
}
