package edu.proyectofinal.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    private static String namePlayer;
    private static String password;




    public static String mail;



    public static String suggestion;


    private static List RankingName;
    private static List RankingNumGame;

    public static List getRankingName() {
        return RankingName;
    }

    public static List getRankingNumGame() {
        return RankingNumGame;
    }
    public static void setRankingName(List rankingName) {
        RankingName = rankingName;
    }

    public static void setRankingNumGame(List rankingNumGame) {
        RankingNumGame = rankingNumGame;
    }


    public static String getMail() {
        return mail;
    }

    public static void setMail(String mail) {
        App.mail = mail;
    }
    public static String getNamePlayer(){

        return namePlayer;
    }
    public static void setNamePlayer(String name){
        namePlayer=name;
    }
    public static String getSuggestion() {
        return suggestion;
    }
    public static void setSuggestion(String suggestion) {
        App.suggestion = suggestion;
    }

    public static String getPassword(){

        return password;
    }
    public static void setPassword(String pass){

        password=pass;
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

       Image image = new Image("/static/img/icon.png");
       stage.getIcons().add(image);


    }


    public static void main(String[] args) {
        launch();
    }

}