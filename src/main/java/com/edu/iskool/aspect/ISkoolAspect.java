package com.edu.iskool.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ISkoolAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Before("execution(* com.edu.iskool.service.*.*(..))")
	public void getServiceAdviceBefore(JoinPoint joinPoint){
		
		logger.info("Executing Before Advice on Calling Service");
		logger.info(joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.edu.iskool.service.*.*(..))")
	public void getServiceAdviceAfter(JoinPoint joinPoint){
		logger.info("Executing After Advice on Calling Service");
		logger.info(joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.edu.iskool.service.*.*(..))")
	public void getServiceAdviceAfterReturning(JoinPoint joinPoint){
		logger.info("Executing After Advice on Calling Service Successfully");
		logger.info(joinPoint.getSignature().getName());
	}
	
	@Around("execution(* com.edu.iskool.service.*.*(..))")
	public void logTimeForMethods(ProceedingJoinPoint joinPoint) throws Throwable{
		logger.info("Executing Logging Time");
		long start=System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - start;
		logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
	}
	
	
	

}
