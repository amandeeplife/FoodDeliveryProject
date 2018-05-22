package com.edu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.edu.domain.Order;
import com.edu.service.OrderService;
import com.edu.service.impl.OrderServiceImpl;
@Component
public class Main {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
	//Order od = (Order)ctx.getBean("testOrder");
   //System.out.println(od.getName());
  
   
   Order od1 = new Order();
   od1.setName("Bike");
   OrderService os = new OrderServiceImpl();
   os.save(od1);
	
}
}
