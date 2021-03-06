 package com.edu.main;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.edu.domain.Delivery;
import com.edu.domain.Order;
import com.edu.listener.JMSOrderListner;
import com.edu.service.DeliveryService;
import com.edu.service.EmailService;
import com.edu.service.OrderService;
import com.edu.service.impl.DeliveryServiceImpl;
import com.edu.service.impl.EmailServiceImpl;
import com.edu.service.impl.OrderServiceImpl;

@Component
@EnableScheduling
public class Main {
	
	@Autowired
 	private OrderService os = new OrderServiceImpl();
	EmailService es = new EmailServiceImpl();
 
	 
 	
	public static void main(String[] args)  {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		// Order od = (Order)ctx.getBean("testOrder");
		// System.out.println(od.getName());
		ctx.getBean(Main.class).mainInternal(ctx);
	}
	
	private void mainInternal(ApplicationContext ctx) {
		Order od1 = new Order();
		od1.setName("Bike2");
		od1.setAddress("This address");
		od1.setDeliveryDate(new Date());
		od1.setEmail("aman.yahway@gmail.com");
		od1.setLocation("Fairfield");
		od1.setOrderedDate(new Date());
		od1.setOrderStatus(false);
		
 
		es.sendOrderPlacementEmail(od1.getEmail(),od1);
 
		
		
		os.save(od1);
		
		es.sendOrderPlacementEmail("h@Gmail.com",od1);
		
 Delivery del = new Delivery();
  	//ds.save(del);
	 

	//	es.testAOP(od1);
		//es.sendOrderPlacementEmail(od1.getEmail(),od1);

 
 
	
	//	es.testAOP(od1);
		//es.sendOrderPlacementEmail(od1.getEmail(),od1);

	
	//	es.sendOrderPlacementEmail(od1.getEmail(),od1);
  
//		JMSOrderListner ol= new JMSOrderListner();
//		Message msg=null;
//		ol.onMessage(msg);
	}
}
