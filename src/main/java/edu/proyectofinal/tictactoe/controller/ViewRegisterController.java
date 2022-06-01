package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;

import edu.proyectofinal.tictactoe.excepciones.exceptions;
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
 * Register Class.
 * @author MariaApa
 * @author Valentina
 * @author Julia
 */

public class ViewRegisterController implements Initializable {
    @FXML
    private PasswordField PasswordRegister;

    @FXML
    private Text textJoin;

    @FXML
    private TextField mail;

    @FXML
    private TextField userRegister;

    private UserService userService;

    /**
     * Register the user and login
     * @throws {@code IOException}
     */
    @FXML
    private void eventKeyRegister(ActionEvent event) throws IOException, exceptions {
        String player_name = userRegister.getText();
        String password = PasswordRegister.getText();
        String email= mail.getText();
        textJoin.setText("Insert a user name");


        try {

            if (!(player_name.equals("") | password.equals("") | email.equals(""))) {

                if (!(userService.validateUser(player_name))) {
                    int createdUser = userService.insertUserReg(player_name, password, email);
                    if (createdUser > 0) {
                        App.setNamePlayer(player_name);
                        App.setMail(email);

                        textJoin.setText("Insert an user name");
                        App.setStage("prueba");

                    } else {

                        textJoin.setText("User not registered correctly");
                        throw new exceptions("user not registered correctly");
                    }
                }else {
                    textJoin.setText("user already registered");
                    throw new exceptions("user already registered");
                }
            }else{
                textJoin.setText("You have to fill in all the fields");
                throw new exceptions("You have to fill in all the fields");
            }

        }catch ( ClassNotFoundException | SQLException e) {
            System.out.println("Error");
        }
    }

    public void switchToStart(ActionEvent event) throws IOException{
        App.setStage("start");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService=new UserService(new UserManagerImpl());
    }
}
