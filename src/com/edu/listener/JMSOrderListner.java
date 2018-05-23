package com.edu.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.domain.Order;
import com.edu.service.EmailService;
import com.edu.service.OrderService;

 

public class JMSOrderListner implements MessageListener {
	@Autowired
	private OrderService orderService;
	private EmailService emailService;
	
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Order order = null;
		try {
			order = (Order) objectMessage.getObject();
			orderService.save(order);
			emailService.sendOrderPlacementEmail(order.getEmail(), order);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         

    }
}
