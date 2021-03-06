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
	  
	  @Pointcut("target(com.edu.listener.JMSOrderListner)")
	  
	  public void testOrderListner() {}

	  @Before("testOrderListner()")    
	  
	  public void testOrderListnerExecution(JoinPoint joinPoint) throws Throwable {
	
		  Logger log = Logger.getLogger("");
		  log.info("   **********    JMS ORDER LISTNER ASPECT CLASS : " + joinPoint.getSignature().getName() + "    **********");
		  System.out.println();
		  System.out.println("********** --->JMSOrderListnerAspect()  :" + joinPoint.getSignature().getDeclaringTypeName() + "." +
					joinPoint.getSignature().getName()+  " **********");
	  }
}