package edu.proyectofinal.tictactoe.controller;

import com.itextpdf.text.DocumentException;
import edu.proyectofinal.tictactoe.App;
import edu.proyectofinal.tictactoe.email.Senders;
import edu.proyectofinal.tictactoe.excepciones.Exceptions;
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


public class ComplainController implements Initializable {


    private UserService userService;
    private SuggestionsService suggestionsService;

    @FXML
    private TextField text;

    @FXML
    private Button submit;

    @FXML
    private Text status;

    public void switchToSecondMenu(ActionEvent event) throws IOException {
        App.setStage("secondmenuInterface");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        suggestionsService=new SuggestionsService(new SuggestionsManagerImpl());
        userService = new UserService(new UserManagerImpl());


    }

    public void submitSuggestions(ActionEvent event) throws IOException, Exceptions {

        String queja=text.getText();
        String nombre= App.getNamePlayer();
        String mail= App.getMail();
        status.setText("");
        try{
            if (!(queja.equals("") | nombre.equals("") | mail.equals(""))){

            int createSuggestion= suggestionsService.insertSuggestion(nombre,queja);

            if(createSuggestion  > 0){
                // App.setStage("secondmenuInterface");
                text.setText("");
                App.setSuggestion(queja);
                String namePdf= new PdfCreator().createPDF("Suggestions","Thank you for your suggestions. You can see a copy below: ",App.getSuggestion());
                email(mail,namePdf);



            }else{
                status.setText("Could not load suggestion");
                throw new Exceptions("Could not load suggestion");
            }
            }else{
                status.setText("You have to fill in all the fields");
                throw new Exceptions("You have to fill in all the fields");}

        } catch (SQLException | ClassNotFoundException | DocumentException | URISyntaxException e) {
            e.printStackTrace();
        }


    }

    public void email(String to, String pdf)  {

        try {
            new Senders().send("tictactoecustomservice",to,"Hey! Check your suggestions!","Thanks for your comments! This help us a lot to improve our game! Here you have an pdf with your suggestions write down",pdf);
        } catch (Exception e) {
            System.out.println("Error, email not found");
            e.printStackTrace();
        }
    }

}
