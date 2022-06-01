package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;

import edu.proyectofinal.tictactoe.excepciones.exceptions;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

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
    @FXML
    private Button back;

    @FXML
    private Text statusPassword;


    private UserService userService;

    public void changePassword(ActionEvent event) throws IOException, exceptions {
        String password = ActualPassword.getText();
        String password2 = newPassword.getText();
        String password3 = repeatPassword.getText();
        statusPassword.setText("");

        try {

            if (!(password2.equals("") | password.equals("") | password3.equals(""))) {
                if (userService.validatePassword(password)) {
                    if (password2.equalsIgnoreCase(password3)) {
                        if (userService.updatePassword(password2)) {
                            App.setStage("secondmenuInterface");
                            App.setPassword(password2);

                        }else{statusPassword.setText("Password could not be updated");
                            throw new exceptions("Password could not be updated");

                        }
                    }else{
                        statusPassword.setText("New passwords do not match");
                        throw new exceptions("New passwords do not match");
                    }
                }else{
                    statusPassword.setText("Incorrect password");
                    throw new exceptions("Incorrect password");
                }


            }else{  statusPassword.setText("You have to fill in all the fields");
                throw new exceptions("You have to fill in all the fields");}
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void back(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService=new UserService(new UserManagerImpl());

    }


}
