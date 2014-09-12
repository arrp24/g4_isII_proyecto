package com.ls.gestion.web.util;

import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	
	  public  Mail(){}
	  
	  
	  public void sendMail(String destino, String mensaje, String asunto){
	      // Recipient's email ID needs to be mentioned.
	      String to = destino;//change accordingly

	      // Sender's email ID needs to be mentioned
	      String from = "homenetnotificacion9@gmail.com";//change accordingly
	      final String username = "homenetnotificacion";//change accordingly
	      final String password = "homenet12345";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(asunto);

	         // Now set the actual message
	         message.setText(mensaje);

	         // Send message
	         Transport.send(message);

	         

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	   }

	
	
}
