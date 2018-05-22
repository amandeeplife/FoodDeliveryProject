package com.edu.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.edu.domain.Order;

 

public class JMSListner implements MessageListener {
 
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Order item = null;
		try {
			item = (Order) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         

    }
}
