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

    @FXML
    void sendBtnOnAction(ActionEvent event) throws MessagingException
    {
        String recientEmail = txtEmail.getText();
        sendEmail(recientEmail);
    }

    Private void sendEmail(String recipientEmail) throws MessagingException 
    {
	Properties properties = new Properties();
	properties.put("mail.smtp.auth","true");
    properties.put("mail.smtp.starttls.enable","true");
    properties.put("mail.smtp.host","smtp.gmail.com");
    properties.put("mail.smtp.port","587");

	
	String myAccountEmail = "javaTester81@gmail.com";
	String password = "focm hctu qxun qcev";

	Session session = Session.getInstance(properties, new Authenticator()
    {
        @Override 
        Protected PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(myAccountEmail, password);
        }
    });

    Message message = prepareMessage(session.myAccountEmail,recipientEmail, txtMsgArea.getText());
    if (message!=null)
        {
        New Alert(Alert.AlertType.INFORMATION, "Send Email Succefully").show();
        } 
        else 
        {
        New Alert(Alert.AlertType.ERROR, "Please Try Again").show();
        }
        Transport.send(message);
    }

    Private Message prepareMessage(Session session, String myAccountEmail, String recipientEmail, String msg) {
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

