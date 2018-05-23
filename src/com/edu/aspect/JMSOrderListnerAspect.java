package com.edu.aspect;

import javax.jms.Message;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSOrderListnerAspect {
	  
	  @Pointcut("execution(* com.edu.listener..*(..))")
	  public void testOrderListner() {}

	  @Pointcut("args(message)")
	  public void argsMethod(Message message) {}
	  
	  @Before("testOrderListner() && argsMethod(message)")           
	  public void testOrderListnerExecution(JoinPoint joinPoint, Message message) {
	
		  Logger log = Logger.getLogger("");
		  log.info("   **********    JMS ORDER LISTNER ASPECT CLASS : " + joinPoint.getSignature().getName() + "    **********");
		  
	  }
}