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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * Ranking class.
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 */

public class RankingController implements Initializable {

    private UserService userService;


    // Ranking text to be fill

    @FXML
    private Text uno;
    @FXML
    private Text numeroDos;
    @FXML
    private Text numeroTres;
    @FXML
    private Text numeroCuatro;
    @FXML
    private Text numeroCinco;
    @FXML
    private Text ranking1;
    @FXML
    private Text ranking2;
    @FXML
    private Text ranking3;
    @FXML
    private Text ranking4;
    @FXML
    private Text ranking5;

    @FXML
    private Pane myPane;
    @FXML
    private ColorPicker myColorPicker;

    public void changeColor(ActionEvent event) {
        Color myColor = myColorPicker.getValue();
        myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
    }

    /**
     * switch to login interface.
     * @param event login interface
     *
     */
    public void switchToLogin(ActionEvent event) throws IOException{
        App.setStage("loginInterface");
    }

    /**
     * switch to menu interface
     * @param event switch to menu interface
     *
     */
    public void switchToMenu(ActionEvent event) throws IOException{
        App.setStage("menuInterface");
    }


    /**
     * Method for inicialize and fill text to make a ranking
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService= new UserService(new UserManagerImpl());
        try {
            String unoText = (String)("1 -        "+ userService.ranking().get(0));
            String dos= (String) ("2 -        "+ userService.ranking().get(1));
            String tres= (String) ("3 -        "+ userService.ranking().get(2));
            String cuatro = (String) ("4 -        "+ userService.ranking().get(3));
            String cinco= (String) ("5 -        "+ userService.ranking().get(4));
            String seis= (String) ("6 -        "+ userService.ranking().get(5));
            String siete= (String) ("7 -        "+ userService.ranking().get(6));
            String ocho = (String) ("8 -        "+ userService.ranking().get(7));
            String nueve= (String) ("9 -        "+ userService.ranking().get(8));
            String diez= (String) ("10 -        "+ userService.ranking().get(9));
            uno.setText(unoText);
            numeroDos.setText(dos);
            numeroTres.setText(tres);
            numeroCuatro.setText(cuatro);
            numeroCinco.setText(cinco);
            ranking1.setText(seis);
            ranking2.setText(siete);
            ranking3.setText(ocho);
            ranking4.setText(nueve);
            ranking5.setText(diez);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}