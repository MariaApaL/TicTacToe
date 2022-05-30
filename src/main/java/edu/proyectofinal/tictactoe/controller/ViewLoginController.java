package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import javax.swing.*;


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

public class ViewLoginController implements Initializable {



    @FXML
    private  TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Text textLogin;


    private UserService userService;


    /**
     * Validate the user and login
     * @throws {@code IOException, SQLException, ClassNotFoundException}
     */
    @FXML
    private void eventKey(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String player_name = txtUser.getText();
        String password = txtPassword.getText();
       textLogin.setText("Insert your user name");


        if( userService.validateUser(player_name, password)){


           textLogin.setText("CORRECT USER");
            App.setStage("prueba");
            App.setNamePlayer(player_name);
            App.setMail(userService.getMail());


        }else{
            textLogin.setText("INCORRECT USER");
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

