package edu.proyectofinal.tictactoe.controller;


import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

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
public class MenuController implements Initializable {

    @FXML
    private Text changingText;

    private UserService userService;

    /**
     * switch to tictactoe interface.
     * @param event switch to tictactoe interface.
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void switchToTictactoe(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        App.setUser(userService.newGame());
        App.setStage("tictactoe");

    }

    /**
     * switch to start interface.
     * @param event switch to start interface.
     * @throws IOException
     */
    public void switchToStart(ActionEvent event) throws IOException{
        App.setStage("start");
    }

    /**
     * switch to ranking interface.
     * @param event switch to ranking interface.
     * @throws IOException
     */
    public void switchToRanking(ActionEvent event) throws IOException{
        App.setStage("rankingInterface");
    }

    /**
     * switch to second menu interface
     * @param event switch to second menu interface
     * @throws IOException
     */
    public void switchToSecondMenu(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");
    }

    /**
     * switch to AI interface.
     * @param event switch to AI interface.
     * @throws IOException
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
        String name = App.getUser().getPlayerName();
        name.toUpperCase();
        changingText.setText("WELCOME "+ name.toUpperCase());

    }
    }



