package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;

/**
 * Start class.
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 */
public class StartController {

    @FXML
    private Pane myPane;
    @FXML
    private ColorPicker myColorPicker;

    public void changeColor(ActionEvent event) {
        Color myColor = myColorPicker.getValue();
        myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
    }

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
