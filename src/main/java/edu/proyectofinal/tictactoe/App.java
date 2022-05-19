package edu.proyectofinal.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage login) throws IOException {

//para probar las interfaces , simplemente cambiar el nombre del fxml

        login.setTitle("Tictactoe");
        this.stage = login;
        setStage("loginInterface");


    }

    public static void setStage(String text) throws IOException {

        Parent root = FXMLLoader.load(App.class.getResource(text + ".fxml"));
        stage.hide();

        stage.setScene(new Scene(root));
        stage.show();


    }


    public static void main(String[] args) {
        launch();
    }

}