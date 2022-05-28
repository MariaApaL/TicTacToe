package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;

import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TicTacToeController implements Initializable {

    // Add 9 buttons
    @FXML
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9;


    @FXML
    private FlowPane buttonBoard;

    // Changing test. It'll change depending on the winners.
    @FXML
    private Text changingText;

    // Player text
    @FXML
    private Text playerX;

    @FXML
    private Text playerO;


    //Players turn.
    private int turn = 0;

    //Counter for wins.

    private int pX = 0;
    private int pO = 0;

    ArrayList<Button> buttons;



    private UserService userService;


    /**
     * switch to second menu interface.
     * @throws {@code IOException}
     */
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

        userService= new UserService(new UserManagerImpl());

    }


    @FXML
    public void restartGame(ActionEvent event) throws SQLException, ClassNotFoundException {
        buttons.forEach(this::restartButton);
        changingText.setText("TIC TAC TOE");
        String playerName=App.getNamePlayer();
        userService.newGame(playerName);
               /* if(usuario.getTxtUser()!=null) {
                    playerName = usuario.getUser();
                }if(usuario.getUserRegister()!=null){playerName=usuario.getUserRegister();}

      */


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










