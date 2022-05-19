package edu.proyectofinal.tictactoe.controller;

import edu.proyectofinal.tictactoe.service.UserService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import javax.swing.*;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewLoginController<User> implements Initializable {


    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    //@FXML
    //private Label message;

    @FXML
    private Button btnLogin;

    private UserService userService;

    @FXML
    private void eventKey(KeyEvent event) {


        if (!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
            if (userService.validateUser(txtUser.getText(), txtPassword.getText())) {
                //  message.setText("Login successful.");
                System.out.println("MÉTODO VALIDATE");
            } /*else {
                //  message.setText("User not found.");
            }
        } else {
            lblMessage.setText("Fill in username and password.");*/
        }


    }



/*
        @FXML
        private void eventAction(ActionEvent event){

            Object evt = event.getSource();

            if(evt.equals(btnLogin)){

                if(!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()){

                    String player_name = txtUser.getText();
                    String password = txtPassword.getText();

                    int state = model.login(player_name, password);

                    if(state!=-1){

                        if(state == 1){

                            JOptionPane.showMessageDialog(null, "Datos correctos puede ingresar al sistema");

                            loadStage("/view/ViewPrincipal.fxml", event);

                        }else{
                            JOptionPane.showMessageDialog(null, "Error al iniciar sesión datos de acceso incorrectos",
                                    "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        }

                    }


                }else{
                    JOptionPane.showMessageDialog(null, "Error al iniciar sesión datos de acceso incorrectos",
                            "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }

            }

        }

*/

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void loadStage(String url, Event event) {

        try {

            //((Node)(event.getSource())).getScene().getWindow().hide();


            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            Window window = oldScene.getWindow();
            Stage stage = (Stage) window;
            stage.hide();

            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();

            newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });

        } catch (IOException ex) {
            System.out.println("Hola");
        }

    }


}
