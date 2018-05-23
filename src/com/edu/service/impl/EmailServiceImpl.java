package com.edu.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.edu.domain.Order;
import com.edu.service.EmailService;

public class EmailServiceImpl implements EmailService {
public static final String MAIL_SERVER = "smtp.gmail.com";
public static final String USERNAME = "foodeliverypro@gmail.com";
public static final String PASSWORD = "1234Food";


public static void main(String[] args) {
 	
}

public void testAOP(Order od) {
	System.out.println("****************Test AOP*****************");
}
public void sendOrderPlacementEmail(String to,Order od) {
	String toAddr = to;
	sendOrder(od);
	String subject = "Order Placement Confirmation";
	
	String message = "Dear Customer, This is to let you know that "
			+ "Your Item :"+od.getName()+" ordered on "+od.getOrderedDate()+""
			+ "has been placed in our order schedule. Thanks. ";
	
	Properties properties = System.getProperties();
	properties.put("mail.smtps.host", MAIL_SERVER);
	properties.put("mail.smtps.auth", "true");
	
	Session session = Session.getInstance(properties);
	MimeMessage msg = new MimeMessage(session);
	
	try {
		msg.setFrom(new InternetAddress(USERNAME));
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

public void sendOrder(Order od){
	
}
public void sendDeliveryConfirmationEmail(String to,Order od) {
	String toAddr = to;
	
	String subject = "Order Placement Confirmation";
	
	String message = "Dear Customer, This is to let you know that "
			+ "Your Item :"+od.getName()+" ordered on "+od.getOrderedDate()+""
			+ "has been successfuly delivered to "+od.getLocation();
	
	Properties properties = System.getProperties();
	properties.put("mail.smtps.host", MAIL_SERVER);
	properties.put("mail.smtps.auth", "true");
	
	Session session = Session.getInstance(properties);
	MimeMessage msg = new MimeMessage(session);
	
	try {
		msg.setFrom(new InternetAddress(USERNAME));
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
