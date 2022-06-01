package edu.proyectofinal.tictactoe.controller;


import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Menu class.
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 */
public class PruebaController implements Initializable {

    @FXML
    private Text changingText;

    private UserService userService;

    /**
     * switch to tictactoe interface.
     * @throws {@code IOException}
     */
    public void switchToTictactoe(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String playerName=App.getNamePlayer();
        userService.newGame(playerName);
        App.setStage("tictactoe");

    }

    /**
     * switch to start interface.
     * @throws {@code IOException}
     */
    public void switchToStart(ActionEvent event) throws IOException{
        App.setStage("start");
    }

    /**
     * switch to ranking interface.
     * @throws {@code IOException}
     */
    public void switchToRanking(ActionEvent event) throws IOException{
        App.setStage("rankingInterface");
    }

    /**
     * switch to second menu interface.
     * @throws {@code IOException}
     */
    public void switchToSecondMenu(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");
    }

    /**
     * switch to AI interface.
     * @throws {@code IOException}
     */
    public void switchToAI(ActionEvent event) throws IOException{
        App.setStage("tictactoeAI");
    }



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService= new UserService(new UserManagerImpl());
        String name = App.getNamePlayer();
        name.toUpperCase();
        changingText.setText("WELCOME "+ name.toUpperCase());

    }
    }



