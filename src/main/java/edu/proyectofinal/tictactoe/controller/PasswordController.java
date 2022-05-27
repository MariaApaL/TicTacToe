package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.excepciones.exception;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PasswordController implements Initializable {

    @FXML
    private PasswordField ActualPassword;


    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField repeatPassword;

    @FXML
    private Button doneButton;


    private UserService userService;

    public void changePassword(ActionEvent event) throws IOException {
        String password = ActualPassword.getText();
        String password2 = newPassword.getText();
        String password3 = repeatPassword.getText();

        try{
          if( userService.validatePassword(password)){
              if(password2.equalsIgnoreCase(password3)){
              try{
                 if( userService.updatePassword(password2)) {
                     App.setStage("secondmenuInterface");
                     App.setPassword(password2);

                 } } catch (exception e) {
                  e.printStackTrace();
              }


              }}


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService=new UserService(new UserManagerImpl());

    }


}