package com.emergency.project.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	Properties props = new Properties();
	private static final String SUB = "TEST";
	private static final String MSG = "YEBO";

	public Email() {

		// Get properties object
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				String from = "@gmail.com";
				String password = "";
				return new PasswordAuthentication(from, password);
			}
		});

		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			String to = "michael@devcon.biz";
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(SUB);
			message.setText(MSG);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
