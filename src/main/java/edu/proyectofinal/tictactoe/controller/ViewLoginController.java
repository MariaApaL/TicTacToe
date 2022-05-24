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

private UserDao model=new UserDao();

    @FXML
    private TextField txtUser;
    @FXML
    private TextField userRegister;

    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField PasswordRegister;

    //@FXML
    //private Label message;

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnRegister;



    private UserService userService;



    @FXML
    private void eventKey(ActionEvent event) throws exception, IOException {
        String player_name = txtUser.getText();
        String password = txtPassword.getText();
        if( userService.validateUser(player_name, password)){
            App.setStage("tictactoe");
        }

/*
        if (!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
            if (userService.validateUser(txtUser.getText(), txtPassword.getText())) {
                String player_name = txtUser.getText();
                String password = txtPassword.getText();
                if( player_name != null && password != null){



                    int state = model.login(player_name,password);

                    if(state!=-1){

                        if(state == 1){



                            App.setStage("tictactoe");

                        }else{
                            JOptionPane.showMessageDialog(null, "Error al iniciar sesión datos de acceso incorrectos",
                                    "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        }

                    }


                }else{
                    JOptionPane.showMessageDialog(null, "Error al iniciar sesión datos de acceso incorrectos",
                            "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }


            } else {
                System.out.println("User not found.");
            }
        } else {
            System.out.println("Fill in username and password.");
        }
*/
    }

    @FXML
    private void eventKeyRegister(ActionEvent event) throws exception, IOException{
        String player_name = userRegister.getText();
        String password = PasswordRegister.getText();


        try {
            int createdUser = userService.insertUserReg(player_name, password);
            if (createdUser > 0) {
                App.setStage("tictactoe");
            } else {
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

    private void loadStage(String url, Event event) {

        try {

            ((Node)(event.getSource())).getScene().getWindow().hide();




            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();

            newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });

        } catch (IOException ex) {
            System.out.println("Hola");
        }

    }


}

