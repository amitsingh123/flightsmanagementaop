package com.amit.springaop.flightmanagement.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect2 {

    private Logger logger = Logger.getLogger(LoggingAspect2.class.getName());

    @Pointcut("execution(* com.amit.springaop.flightmanagement.domain.*.*set*(..))")
    public void allSetters() {

    }

    @Around("allSetters()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        logger.severe("call method "+methodName+ " with args "+ methodArgs[0]);
        Object result = joinPoint.proceed();
        logger.severe("Method "+methodName+" returns "+result);
        return result;
    }
}
