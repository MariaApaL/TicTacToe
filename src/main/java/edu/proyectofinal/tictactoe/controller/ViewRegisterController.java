package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.excepciones.exception;
import edu.proyectofinal.tictactoe.excepciones.exception;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * Register class
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 *
 */

public class ViewRegisterController implements Initializable {

   //PasswordField object
    @FXML
    private PasswordField PasswordRegister;

    //Text object
    @FXML
    private Text textJoin;

    //TextField object
    @FXML
    private TextField userRegister;

    //User service object
    private UserService userService;


    /**
     * Method for register a new user
     * @param event make possible to realize register action.
     */

    @FXML
    private void eventKeyRegister(ActionEvent event) throws  IOException {
        String player_name = userRegister.getText();
        String password = PasswordRegister.getText();
        textJoin.setText("Insert a user name");


        try {
            int createdUser = userService.insertUserReg(player_name, password);
            if (createdUser > 0) {
                App.setNamePlayer(player_name);
                userService.newGame(player_name);
                textJoin.setText("Insert an user name");
                App.setStage("prueba");

            } else {

                textJoin.setText("User not registered correctly");
                System.out.println("user not registered correctly");
            }
        } catch ( ClassNotFoundException | SQLException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService=new UserService(new UserManagerImpl());
    }
}
