package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class RankingController implements Initializable {

    private UserService userService;

    // Añadimos el boton 1
    @FXML
    private Button b1;

    @FXML
    private TableColumn<?,?> rank;

    @FXML
    private TableColumn<?,?> name;




   private TableView table = new TableView();


    public void start(Stage primaryStage) {

        Group group = new Group();

        TableColumn rank = new TableColumn("rank");
        TableColumn name = new TableColumn("Name");
        TableColumn wins = new TableColumn("Wins");

        table.getColumns().addAll(rank,name,wins);

        Scene scene = new Scene(group, 300,250);

        ((Group)scene.getRoot()).getChildren().add(table);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void switchToLogin(ActionEvent event) throws IOException{
        App.setStage("loginInterface");
    }


    public void switchToMenu(ActionEvent event) throws IOException{
        App.setStage("prueba");
    }

    public void rankingUsers () throws SQLException, ClassNotFoundException {


        userService.ranking();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService= new UserService(new UserManagerImpl());
    }
}
