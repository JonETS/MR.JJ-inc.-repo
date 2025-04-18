package com.example;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * This Class handles all methods and event handlings pertaining towards sending an email
 * @author Jason Tran
 * @version 1.0
 */
public class EmailsFormController 
{
    @FXML
    private Button btnSend;

    @FXML
    private Label testLabel;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMsgArea;

    /**
     * This is the method for the button on Action that triggers the email to be sent
     * @param session
     * @param myAccountEmail
     * @param recipientEmail
     * @param msg
     */
    @FXML
    void sendBtnOnAction(ActionEvent event) throws MessagingException
    {
        String recientEmail = txtEmail.getText();
        sendEmail(recientEmail);
    }

    /**
     * This method handles the whole sending email process by taking in the recipient's email
     * and uses a provided email and send it through the gmail
     * @param recipientEmail
     */
    Private void sendEmail(String recipientEmail) throws MessagingException 
    {
        /**
         * Properties are the allowed port provided by google (587) for java email authentification
         * <code>
         * properties.put("mail.smtp.auth","true");
         * properties.put("mail.smtp.starttls.enable","true");
         * properties.put("mail.smtp.host","smtp.gmail.com");
         * properties.put("mail.smtp.port","587");
         * <code>
         */
	    Properties properties = new Properties();
	    properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

	
	    String myAccountEmail = "javaTester81@gmail.com";
	    String password = "focm hctu qxun qcev";

        /**
         * Authenticates the email using the google password port
         * @param myAccountEmail
         * @param password
         * @returns PasswordAuthentication
         */
	    Session session = Session.getInstance(properties, new Authenticator()
        {
            @Override 
            Protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        /**
         * This method checks whether or not the Email was sent Successfully
         * @param myAccountEmail
         * @param recipientEmail
         * @param textMsgArea
         */
        Message message = prepareMessage(session.myAccountEmail,recipientEmail, txtMsgArea.getText());
        if (message!=null)
            {
            New Alert(Alert.AlertType.INFORMATION, "Send Email Successfully").show();
            } 
            else 
            {
            New Alert(Alert.AlertType.ERROR, "Please Try Again").show();
            }
            Transport.send(message);
        

        
        /**
         * This method is the one that sends out the email with the provided text
         * @param session
         * @param myAccountEmail
         * @param recipientEmail
         * @param msg
         * @returns message
         */
        Private Message prepareMessage(Session session, String myAccountEmail, String recipientEmail, String msg) 
        {
            try
            {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail);
            message.setRecipients(Message.RecipientType.T0, new InternetAddress[]
            {
                new InternetAddress(recipientEmail)
            });

            message.setSubject("Messages");
            message.setText(msg);

            return message;
            }
            catch (Exception e)
            {
                Logger.getLogger(EmailsFormController.class.getName()).log(Level.SEVERE, null,e);
            }
            return null;
        }
    }
}
