package com.edu.aspect;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSOrderListnerAspect {
	  
	  @Pointcut("execution(* com.edu.listener..onMessage(message))")
	  public void testOrderListner() {}

	  @Before("testOrderListner()")           
	  public void testOrderListnerExecution(JoinPoint joinPoint) throws Throwable {
	
		  Logger log = Logger.getLogger("");
		  log.info("   **********    JMS ORDER LISTNER ASPECT CLASS : " + joinPoint.getSignature().getName() + "    **********");
		  
	  }
}