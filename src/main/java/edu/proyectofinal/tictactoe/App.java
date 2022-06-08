package edu.proyectofinal.tictactoe;

import edu.proyectofinal.tictactoe.model.dao.Player;
import edu.proyectofinal.tictactoe.model.dao.Suggestion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {


    private static Stage stage;


    public static void setUser(Player user) {
        App.user = user;
    }

    public static void setSuggestion(Suggestion suggestion) {
        App.suggestion = suggestion;
    }

    public static Player getUser() {
        return user;
    }

    public static Suggestion getSuggestion() {
        return suggestion;
    }

    protected static Player user;
    protected static Suggestion suggestion;






    @Override
    public void start(Stage login) throws IOException {

        //para probar las interfaces , simplemente cambiar el nombre del fxml



        login.setTitle("TicTacToe");
        this.stage = login;
        setStage("start");


    }


    public static void setStage(String text) throws IOException {

        Parent root = FXMLLoader.load(App.class.getResource(text + ".fxml"));
        stage.hide();

        stage.setScene(new Scene(root));
        stage.show();

       Image image = new Image("/static/img/icon.png");
       stage.getIcons().add(image);


    }


    public static void main(String[] args) {
        launch();
    }

}