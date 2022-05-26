package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.excepciones.exception;
import edu.proyectofinal.tictactoe.model.dao.UserDao;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import javax.swing.*;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewLoginController implements Initializable {



    @FXML
    private  TextField txtUser;
    @FXML
    private TextField userRegister;

    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField PasswordRegister;

    @FXML
    private TextField textJoin;
    @FXML
    private TextField textLogin;



    private UserService userService;



    @FXML
    private void eventKey(ActionEvent event) throws exception, IOException, SQLException, ClassNotFoundException {
        String player_name = txtUser.getText();
        String password = txtPassword.getText();
        textLogin.setText("Insert your user name");


        if( userService.validateUser(player_name, password)){
            userService.newGame(player_name);
            App.setNamePlayer(player_name);
            textLogin.setText("CORRECT USER");
            App.setStage("prueba");


        }else{
            textLogin.setText("INCORRECT USER");
        }

    }

    @FXML
    private void eventKeyRegister(ActionEvent event) throws exception, IOException{
        String player_name = userRegister.getText();
        String password = PasswordRegister.getText();
        textJoin.setText("Insert a user name");


        try {
            int createdUser = userService.insertUserReg(player_name, password);
            if (createdUser > 0) {
                App.setNamePlayer(player_name);
                userService.newGame(player_name);
                textJoin.setText("Insert a user name");
                App.setStage("tictactoe");




            } else {

                textJoin.setText("User not registered correctly");
               System.out.println("user not registered correctly");
            }
        } catch ( ClassNotFoundException | SQLException e) {
        System.out.println("Error");
        }
    }




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            userService=new UserService(new UserManagerImpl());
    }



}

