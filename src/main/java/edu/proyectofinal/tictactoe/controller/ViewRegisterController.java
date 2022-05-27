package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
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

    @FXML
    private void eventKeyRegister(ActionEvent event) throws exception, IOException {
        String player_name = userRegister.getText();
        String password = PasswordRegister.getText();
        String email= mail.getText();
        textJoin.setText("Insert a user name");


        try {
            int createdUser = userService.insertUserReg(player_name, password, email);
            if (createdUser > 0) {
                App.setNamePlayer(player_name);

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
