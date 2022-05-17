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

    @Override
    public void start(Stage tictactoe) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tictactoe.fxml"));
        tictactoe.setTitle("Tictactoe");
        tictactoe.setScene(new Scene(root));
        tictactoe.show();
    }


    public static void main(String[] args) {
        launch();
    }

}