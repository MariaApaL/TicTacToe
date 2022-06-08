package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;

import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * PDF creator class
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 *
 */
public class PasswordController implements Initializable {


    // Password field for actual password
    @FXML
    private PasswordField ActualPassword;

    // Password field for new password

    @FXML
    private PasswordField newPassword;

    // Password field for repeat new password
    @FXML
    private PasswordField repeatPassword;


    // UserService object
    private UserService userService;

    /**
     * Method for change a password
     * @param event
     *
     */


    public void changePassword(ActionEvent event) throws IOException {
        String password = ActualPassword.getText();
        String password2 = newPassword.getText();
        String password3 = repeatPassword.getText();

        try{
            if( userService.validatePassword(password)){
                if(password2.equalsIgnoreCase(password3)){
                    if( userService.updatePassword(password2)) {
                        App.setStage("secondmenuInterface");
                        App.setPassword(password2);

                    }


                }}


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    /**
     * Switch to second menu interface
     * @param event
     *
     */
    public void back(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService=new UserService(new UserManagerImpl());

    }


}
