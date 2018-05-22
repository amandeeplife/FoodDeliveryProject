package com.edu.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
public static final String MAIL_SERVER = "smtp.gmail.com";
public static final String USERNAME = "foodeliverypro@gmail.com";
public static final String PASSWORD = "1234Food";


public static void main(String[] args) {
	new Mail().mail_send("foodeliverypro@gmail.com","aman.yahway@gmail.com");
	
}


private void mail_send(String from, String to) {
	String fromAddr = from;
	String toAddr = to;
	
	String subject = "This is test";
	
	String message = "This is for trial test";
	
	Properties properties = System.getProperties();
	properties.put("mail.smtps.host", MAIL_SERVER);
	properties.put("mail.smtps.auth", "true");
	
	Session session = Session.getInstance(properties);
	MimeMessage msg = new MimeMessage(session);
	
	try {
		msg.setFrom(new InternetAddress(from));
		msg.addRecipients(Message.RecipientType.TO, toAddr);
		msg.setSubject(subject);
		msg.setText(message);
		
		Transport tr = session.getTransport("smtps");
		tr.connect(MAIL_SERVER,USERNAME,PASSWORD);
		tr.sendMessage(msg, msg.getAllRecipients());
		tr.close();
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	// TODO Auto-generated method stub
	
}
}
