package edu.proyectofinal.tictactoe;

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

    private static Scene scene;
    private static Stage stage;
    private static String namePlayer;

    public static String getNamePlayer(){
        return namePlayer;
    }
    public static void setNamePlayer(String name){
        namePlayer=name;
    }

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

       // Image image = new Image(src/main/resources/static/img/icon.png);

    }


    public static void main(String[] args) {
        launch();
    }

}