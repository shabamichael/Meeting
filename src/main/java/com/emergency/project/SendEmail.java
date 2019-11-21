package com.emergency.project;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public SendEmail() {
	// email ID of Recipient. 
    String recipient = "michael@devcon.biz"; 

    // email ID of  Sender. 
    String sender = "talk2shabaranks@gmail.com"; 

    // using host as localhost 
    String host = "smtp.gmail.com"; 

    // Getting system properties 
    Properties properties = System.getProperties(); 

    // Setting up mail server 
    properties.setProperty("mail.smtp.host", host); 

    // creating session object to get properties 
    Session session = Session.getDefaultInstance(properties); 

    try 
    { 
       // MimeMessage object. 
       MimeMessage message = new MimeMessage(session); 

       // Set From Field: adding senders email to from field. 
       message.setFrom(new InternetAddress(sender)); 

       // Set To Field: adding recipient's email to from field. 
       message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 

       // Set Subject: subject of the email 
       message.setSubject("This is Suject"); 

       // set body of the email. 
       message.setText("This is a test mail"); 

       // Send email. 
       Transport.send(message); 
       System.out.println("Mail successfully sent"); 
    } 
    catch (MessagingException mex)  
    { 
       mex.printStackTrace(); 
    } 
 } 
}

