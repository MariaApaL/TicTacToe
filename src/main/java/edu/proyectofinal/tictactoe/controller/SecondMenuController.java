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

public class SecondMenuController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    private UserService userService;



    public void deleteUser(ActionEvent event) throws SQLException, ClassNotFoundException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete User");
        alert.setHeaderText("You're about to delete your user");
        alert.setContentText("ARE YOU SURE MAH BRU?");

        Stage stage;

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) anchorPane.getScene().getWindow();
            System.out.println("You successfully deleted it!");
            stage.close();
        }
        // userService.deleteUser();

    }

    public void logoutUser(ActionEvent event) throws SQLException, ClassNotFoundException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log out");
        alert.setHeaderText("You're about to log out");
        alert.setContentText("ARE YOU SURE MAH BRU?");

        Stage stage;

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) anchorPane.getScene().getWindow();
            System.out.println("You successfully logged out!");
            stage.close();
        }
        // userService.deleteUser();

    }


    public void switchToMenu(ActionEvent event) throws IOException {
        App.setStage("prueba");
    }

    public void switchToComplain(ActionEvent event) throws IOException {
        App.setStage("complainInterface");
    }

    public void switchToPassword(ActionEvent event) throws IOException {
        App.setStage("passwordInterface");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService= new UserService(new UserManagerImpl());
    }



}
