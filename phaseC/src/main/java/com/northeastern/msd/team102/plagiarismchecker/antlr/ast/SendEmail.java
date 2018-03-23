package com.northeastern.msd.team102.plagiarismchecker.antlr.ast;


import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * This code is refenrenced from :
 * https://www.tutorialspoint.com/java/java_sending_email.htm
 * 
 * https://stackoverflow.com/questions/19493904
 * /javax-mail-messagingexception-could-not-connect-to-smtp-host-localhost-port
 *
 */
public class SendEmail {

	public static void email(String Errormessage) {
		
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		final String username = "msdAtTeam102@gmail.com";
		final String password = "msd@team102";
		
		try {
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			
		Message msg = new MimeMessage(session);
			
		msg.setFrom(new InternetAddress("msdAtTeam102@gmail.com"));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("msdAtTeam102@gmail.com", false));
		msg.setSubject("Attention !! Error during implementation of Plagiarism checker");
		msg.setText(Errormessage);
		msg.setSentDate(new Date());
		Transport.send(msg);
		System.out.println("Message sent.");	
		} catch (MessagingException e1) {
			email(e1.getMessage());
		}
	}
}
