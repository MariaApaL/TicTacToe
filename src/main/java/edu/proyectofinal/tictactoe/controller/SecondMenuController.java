package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 *
 * Second Menu controller class
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 *
 */

public class SecondMenuController implements Initializable {

    //Anchor pane Object
    @FXML
    private AnchorPane anchorPane;

    //UserService Object

    private UserService userService;



    /**
     *
     *  Method for delete an user
     *  @param event make possible to delete an user
     */
    public void deleteUser(ActionEvent event) throws SQLException, ClassNotFoundException {

        //create an alert to confirm if you want to delete the user.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete User");
        alert.setHeaderText("You're about to delete your user");
        alert.setContentText("ARE YOU SURE MAH BRU?");

        Stage stage;

        if(alert.showAndWait().get() == ButtonType.OK){
            userService.deleteUser();
            stage = (Stage) anchorPane.getScene().getWindow();
            System.out.println("You successfully deleted it!");
            stage.close();
            userService.deleteUser();
        }else{

        }


    }

    /**
     *
     *  Method for log out an user
     *  @param event make possible to log out an user
     */
    public void logoutUser(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {

        //create an alert to confirm the log out.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log out");
        alert.setHeaderText("You're about to log out");
        alert.setContentText("ARE YOU SURE MAH BRU?");


        if(alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You successfully logged out!");
            App.setStage("start");
        }

    }

    /**
     * switch to menu interface.
     * @param event switch to menu interface.
     * @throws IOException
     */
    public void switchToMenu(ActionEvent event) throws IOException {
        App.setStage("menuInterface");
    }

    /**
     * switch to complain interface
     * @param event switch to complain interface
     * @throws IOException
     */
    public void switchToComplain(ActionEvent event) throws IOException {
        App.setStage("complainInterface");
    }

    /**
     * switch to password interface
     *
     * @param event switch to password interface
     * @throws IOException
     */
    public void switchToPassword(ActionEvent event) throws IOException {
        App.setStage("passwordInterface");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService= new UserService(new UserManagerImpl());
    }



}
