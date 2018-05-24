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
	
	
	@Before("appMethod()")
	public void doOrder(JoinPoint joinPoint) {
		System.out.println("*** ORDER ASPECT--->OrderAspect.doOrderService()  :" + joinPoint.getSignature().getDeclaringTypeName() + "." +
				joinPoint.getSignature().getName()+ " ***");
	}
}
