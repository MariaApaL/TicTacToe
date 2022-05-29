package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import javafx.event.ActionEvent;

import java.io.IOException;

/**
 *
 * Start controller class
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 *
 */
public class StartController {



    /**
     * switch to login interface.
     * @throws {@code IOException}
     */
    public void switchToLogin(ActionEvent event) throws IOException {
        App.setStage("loginInterface");

    }

    /**
     * switch to register interface.
     * @throws {@code IOException}
     */
    public void switchToRegister(ActionEvent event) throws IOException {
        App.setStage("registerInterface");

    }
}
