package com.edu.main;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.edu.domain.Order;
import com.edu.service.OrderService;

@Component
public class Main {
	
	@Autowired
	private OrderService os;
	
	public static void main(String[] args)  {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		// Order od = (Order)ctx.getBean("testOrder");
		// System.out.println(od.getName());
		ctx.getBean(Main.class).mainInternal(ctx);
	}
	
	private void mainInternal(ApplicationContext ctx) {
		Order od1 = new Order();
		od1.setName("Bike");
		od1.setAddress("This address");
		od1.setDeliveryDate(new Date());
		od1.setEmail("foadegbulugbe@mum.edu");
		od1.setLocation("Fairfield");
		od1.setOrderedDate(new Date());
		od1.setOrderStatus(false);
		
		//OrderService os = new OrderServiceImpl();
		os.save(od1);
	}
}
