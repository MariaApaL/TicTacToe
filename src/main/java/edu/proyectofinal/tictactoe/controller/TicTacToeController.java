package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TicTacToeController implements Initializable {

    // Añadimos los botones del 1 al 9
    @FXML
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9;

    @FXML
    private Button newGame;

    @FXML
    private Button backButton;

    @FXML
    private FlowPane buttonBoard;

    // Este texto irá cambiando entre el título y la victoria de uno de los jugadores.
    @FXML
    private Text changingText;

    // Estos dos textos nos informa de los jugadores.
    @FXML
    private Text playerX;

    @FXML
    private Text playerO;


    // Inicializamos el turno.
    private int turn = 0;

    //Inicializamos dos contadores de partidas ganadas de jugadores.
    //ESTO HABRIA QUE PONERLO COMO UN TEXTO Y QUE TE TRANSFORMARA EL TEXTO EN NUMERO. BICHEAR.
    private int pX = 0;
    private int pO = 0;

    //Creamos un ArrayList con los botones
    ArrayList<Button> buttons;

    private Stage stage;
    private Scene scene;
    private Parent root;



    public void switchToMenu(ActionEvent event) throws IOException{
        App.setStage("prueba");
    }








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>();
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);

        //Con esto hacemos los botones clickeables
        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });

    }


    @FXML
    public void restartGame(ActionEvent event) {
        buttons.forEach(this::restartButton);
        changingText.setText("TIC TAC TOE");

    }

    public void restartButton(Button button) {
        button.setDisable(false);
        button.setText("");
        buttonBoard.setDisable(false);


    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            choosePlayer(button);
            button.setDisable(true);
            checkGame(button);
        });
    }


    public void choosePlayer(Button button) {
        if (turn % 2 == 0) {
            button.setText("X");
            turn = 1;
        } else {
            button.setText("O");
            turn = 0;
        }
    }

    public void checkGame(Button button) {
        for (int i = 0; i < 8; i++) {
            String line = switch (i) {
                case 0 -> b1.getText() + b2.getText() + b3.getText();
                case 1 -> b4.getText() + b5.getText() + b6.getText();
                case 2 -> b7.getText() + b8.getText() + b9.getText();
                case 3 -> b1.getText() + b5.getText() + b9.getText();
                case 4 -> b3.getText() + b5.getText() + b7.getText();
                case 5 -> b1.getText() + b4.getText() + b7.getText();
                case 6 -> b2.getText() + b5.getText() + b8.getText();
                case 7 -> b3.getText() + b6.getText() + b9.getText();
                default -> null;
            };


            if (line.equals("XXX")) {
                changingText.setText("PLAYER X WON");
                pX++;
                playerX.setText("Player(X): " + pX);
                buttonBoard.setDisable(true);

            }


            else if (line.equals("OOO")) {
                changingText.setText("PLAYER O WON");
                pO++;
                playerO.setText("Player(O): " + pO);
                buttonBoard.setDisable(true);


            }
        }
    }



}










