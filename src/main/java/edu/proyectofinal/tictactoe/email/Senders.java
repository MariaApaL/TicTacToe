package edu.proyectofinal.tictactoe.email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import edu.proyectofinal.tictactoe.pdfcreator.PdfCreator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * Email Sender class
 *
 * @author MariaApa
 * @author Valentina
 * @author Julia
 *
 */

public class Senders {


    @Setter
    @Getter
    private Properties mailProp = new Properties();
    @Setter
    @Getter
    private Properties credentialProp = new Properties();

    /**
     * Constructor that loads the credential within CredentialsConstants.java
     */
    public Senders() {
        try {
            // Loads all the properties of file "mail.properties".
            mailProp.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
            credentialProp.load(getClass().getClassLoader().getResourceAsStream("credentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that create the email and send it
     *
     * @param from    - String (Emisor)
     * @param to      - String (Remitent)
     * @param subject - String (the subject of the email)
     * @param content - String (the text inside it)
     * @return <ol>
     * <li>boolean true - when is correctly send </li>
     * <li>boolean false - when can´t be send due to an error</li>
     * </ol>
     */
    public boolean send(String from, String to, String subject, String content) {
        // Get the Session object.// and pass username and password
        Session session = createSession();
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(subject);

            message.setContent(content, "text/html");

            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Method that creates the session for send the email
     *
     * @return session - Session
     */
    private Session createSession() {
        Session session = Session.getInstance(mailProp, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(credentialProp.getProperty(CredentialsConstants.USER),
                        credentialProp.getProperty(CredentialsConstants.PASSWD));
            }
        });
        session.setDebug(true);
        return session;
    }


}

