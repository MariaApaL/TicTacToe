package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Complain Controller Class.
 *
 * Register Class.
 * @author MariaApa
 * @author Valentina
 * @author Julia
 */
public class ComplainController implements Initializable {



    /**
     * switch to second menu interface.
     * @throws {@code IOException}
     */
    public void switchToSecondMenu(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
