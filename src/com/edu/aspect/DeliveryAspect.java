package com.edu.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DeliveryAspect {
	
	
	@Pointcut("execution(* com.edu.service..save(..))")
	public void saveMethod() {}
	
	@Before("saveMethod()")
	public void doSaving(JoinPoint joinPoint) {
		System.out.println("********** DELIVERY ASPECT--->DeliveryAspect.doSaving()  :" + joinPoint.getSignature().getDeclaringTypeName() + "." +
				joinPoint.getSignature().getName()+ " **********");
	}
	

	@Before("execution(* com.edu.service..update(..))")
	public void doUpdating(JoinPoint joinPoint) {
		System.out.println("********** DELIVERY ASPECT--->DeliveryAspect.doUpdating()  :" + joinPoint.getSignature().getDeclaringTypeName() + "." +
				joinPoint.getSignature().getName()+ " **********");
	}
	
	@Pointcut("execution(* com.edu.service..delete(..))")
	public void deleteMethod() {}
	
	@Before("deleteMethod()")
	public void doDeleting(JoinPoint joinPoint) {
		System.out.println("********** DELIVERY ASPECT--->DeliveryAspect.doDeleting()  :" + joinPoint.getSignature().getDeclaringTypeName() + "." +
				joinPoint.getSignature().getName()+ " *********");
	}
}
