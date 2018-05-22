package com.edu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.domain.Order;

public class Main {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
	Order od = (Order)ctx.getBean("testOrder");
   System.out.println(od.getName());
	
}
}
