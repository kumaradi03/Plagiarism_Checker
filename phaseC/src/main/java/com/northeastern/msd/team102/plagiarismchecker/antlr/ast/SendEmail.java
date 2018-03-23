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
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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

    public static final Logger logger = Logger.getLogger(SendEmail.class.getName());

    private static SendEmail emailInstance = null;

    private SendEmail() {
        //Default constructor
    }

    public static SendEmail getInstance (String errorMessage) {
        if(emailInstance == null)
            emailInstance = new SendEmail();
        email(errorMessage);
        return emailInstance;
    }

	private static void email (String errorMessage) {
		
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
		final String pass = "msd@team102";
		
		try {
			Session session = Session.getDefaultInstance(props, new Authenticator() {
			    @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, pass);
				}
			});
			
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username, false));
		msg.setSubject("Attention !! Error during implementation of Plagiarism checker");
		msg.setText(errorMessage);
		msg.setSentDate(new Date());
		Transport.send(msg);
		logger.log(Level.INFO,"Message sent.");
		} catch (MessagingException e1) {
			email(e1.getMessage());
		}
	}
}
