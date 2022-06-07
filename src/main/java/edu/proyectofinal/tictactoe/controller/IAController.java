package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.IA.ArtificialIntelligence;
import edu.proyectofinal.tictactoe.IA.State;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * IA Controller Class.
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 */

public class IAController implements Initializable {

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

    Random random = new Random();


    //players turns.
    private int turn = 0;

    //Counter for wins.
    private int pX = 0;
    private int pO = 0;

    //Add buttons in an ArrayList
    ArrayList<Button> buttons;

    //Initialize an ArtificialIntelligence object
    ArtificialIntelligence AI = new ArtificialIntelligence();

    //UserService object
    private UserService userService;


    /**
     * switch to second menu interface.
     * @param event switch to second menu interface.
     * @throws IOException
     */
    public void switchToMenu(ActionEvent event) throws IOException {
        App.setStage("menuInterface");
    }

    /**
     * Setting in buttons
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String name= App.getNamePlayer();
        playerO.setText(name+"(O): ");
        playerX.setText("AI(X): ");


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

        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });

        userService= new UserService(new UserManagerImpl());
        pickButton(random.nextInt(9));
    }


    /**
     * Method for make AI moves.
     *
     */
    public void makeAIMove(){
        int move = AI.minMaxDecision(getBoardState());
        pickButton(move);
    }

    /**
     * Method for restart game
     * @param event make possible to realize restart action.
     */
    @FXML
    public void restartGame(ActionEvent event) throws SQLException, ClassNotFoundException {
        buttons.forEach(this::restartButton);
        changingText.setText("TIC TAC TOE");
        String playerName=App.getNamePlayer();
        userService.newGame(playerName);
        pickButton(random.nextInt(9));

    }

    /**
     * Method for reset buttons.
     * @param button Set text to " " to start over.
     */

    public void restartButton(Button button) {
        button.setDisable(false);
        button.setText("");
        buttonBoard.setDisable(false);


    }

    /**
     * Method for setting up buttons.
     * @param button Set up text "O" when it is player's turn.
     */

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {

            button.setText("O");
            button.setDisable(true);
            makeAIMove();
            checkGame(button);
        });
    }

    /**
     * Method for AI moves.
     * @param index Get button number to put "X" in.
     */
    private void pickButton(int index) {
        buttons.get(index).setText("X");
        buttons.get(index).setDisable(true);
    }

    /**
     * Method for AI random moves.
     * @return State object.
     */
    public State getBoardState(){
        String[] board = new String[9];

        for (int i = 0; i < buttons.size(); i++) {
            board[i] = buttons.get(i).getText();
        }

        return new State(0,board);
    }

    /**
     * Method for decide who wins.
     * @param button Set "X" or "O" and choose winner
     */
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
                changingText.setText("AI WON");
                pX++;
                playerX.setText("AI(X): " + pX);
                buttonBoard.setDisable(true);

            }


            else if (line.equals("OOO")) {
                changingText.setText("PLAYER O WON");
                pO++;
                playerO.setText(App.getNamePlayer()+"(O): " + pO);
                buttonBoard.setDisable(true);


            }
        }
    }

}
