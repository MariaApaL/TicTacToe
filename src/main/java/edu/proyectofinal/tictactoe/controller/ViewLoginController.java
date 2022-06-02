package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;

import edu.proyectofinal.tictactoe.excepciones.Exceptions;
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
    private void eventKey(ActionEvent event) throws IOException, SQLException, ClassNotFoundException, Exceptions {
        String player_name = txtUser.getText();
        String password = txtPassword.getText();
       textLogin.setText("Insert your user name");
try{

    if (!(player_name.equals("") ) && !(password.equals(""))){
        if ((userService.findUser(player_name, password))) {
            App.setNamePlayer(player_name);



                App.setMail(userService.getMail());
                textLogin.setText("CORRECT USER");
                App.setStage("menuInterface");



            } else {
                textLogin.setText("Incorrect user");
                throw new Exceptions("Incorrect user");
            }



    }else{textLogin.setText("You have to fill in all the fields");
        throw new Exceptions("You have to fill in all the fields");}
}catch(SQLException e){
    e.printStackTrace();
}

    }

    /**
     * switch to menu interface.
     * @throws {@code IOException}
     */
    public void switchToStart(ActionEvent event) throws IOException{
        App.setStage("start");
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        userService=new UserService(new UserManagerImpl());
    }



}

