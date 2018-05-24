package com.edu.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderAspect {
	@Pointcut("execution(* com.edu.service..*(..))")
	public void appMethod() {}
	
	@Pointcut("args(Object)")
	public void argsMethod() {}
	
	@Before("appMethod()")
	public void doOrder(JoinPoint joinPoint) {
		  Logger log = Logger.getLogger("");
		  log.info("   **********     ORDER ASPECT CLASS : " + joinPoint.getSignature().getName() + "    **********");
		  System.out.println("In the order asppect class******************");
	}
}
