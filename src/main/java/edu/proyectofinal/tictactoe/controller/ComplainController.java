package edu.proyectofinal.tictactoe.controller;

import com.itextpdf.text.DocumentException;
import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.email.Senders;
import edu.proyectofinal.tictactoe.excepciones.TicTacToeException;
import edu.proyectofinal.tictactoe.model.manager.impl.SuggestionsManagerImpl;
import edu.proyectofinal.tictactoe.model.manager.impl.UserManagerImpl;
import edu.proyectofinal.tictactoe.pdfcreator.PdfCreator;
import edu.proyectofinal.tictactoe.service.SuggestionsService;
import edu.proyectofinal.tictactoe.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
/**
 * Complain class.
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 */


public class ComplainController implements Initializable {

    //UserService object
    private UserService userService;

    //SUggetsionsService object
    private SuggestionsService suggestionsService;


    // text field
    @FXML
    private TextField text;

    // text
    @FXML
    private Text status;


    /**
     * switch to second menu interface.
     * @param event change interfaces
     *
     */

    public void switchToSecondMenu(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");
    }


    /**
     * Method for initialize suggestion and userservice object
     * @param url
     * @param resourceBundle
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        suggestionsService=new SuggestionsService(new SuggestionsManagerImpl());
        userService = new UserService(new UserManagerImpl());


    }


    /**
     * Method for send an email with a pdf attach
     * and update a suggestion on the database
     * @param event
     *
     */

    public void submitSuggestions(ActionEvent event) throws TicTacToeException {

        String queja=text.getText();
        //String nombre= App.getNamePlayer();
        //String mail= App.getMail();
        try{


            if(!(queja.equalsIgnoreCase(""))){
                App.setSuggestion(suggestionsService.insertSuggestion(queja));
                 App.setStage("secondmenuInterface");
                status.setText("");

                String namePdf= new PdfCreator().createPDF("Suggestions","Thank you for your suggestions. You can see a copy below: ",App.getSuggestion().getSuggestion());
                email(App.getUser().getMail(),namePdf);


            }else{
                status.setText("Field shouldn't be empty");
                throw new TicTacToeException("Field shouldn't be empty");

            }

        } catch (SQLException | ClassNotFoundException | DocumentException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Method for send an email
     * @param to destination
     * @param pdf pdf file
     *
     */
    public void email(String to, String pdf)  {

        try {
            new Senders().send("tictactoecustomservice",to,"Hey! Check your suggestions!","Thanks for your comments! This help us a lot to improve our game! Here you have an pdf with your suggestions write down",pdf);
        } catch (Exception e) {
            System.out.println("Error, email not found");
            e.printStackTrace();
        }
    }

}