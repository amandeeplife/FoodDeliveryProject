package com.edu.aspect;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.edu.domain.Order;

@Aspect
@Component
public class EmailAspect {
		 	  
	  	  
	  @Pointcut("execution(* com.edu.service..*(..))")
	  public void testEmail() {}
	  @Pointcut("args(od)")
	  public void argsMethod(Order od) {}

	  @Before("testEmail() && argsMethod(od)")           
	  public void testEmailExecution(JoinPoint joinPoint, Order od) {
		  
		  Logger log = Logger.getLogger("");
		  log.info("   **********    EMAIL ASPECT CLASS : " + joinPoint.getSignature().getName() + "    **********");
		  
		    System.out.println();
		    System.out.println( "**********    OREDER INFORMATION ************");
		    System.out.println("Order sent to :"+od.getEmail());
		    System.out.println("Order Name: " + od.getName());
		    System.out.println("Order Date: " + od.getOrderedDate());
		    System.out.println("Delivery Date: " + od.getDeliveryDate());
	  }

	  }

