package com.amit.springaop.flightmanagement.aspects;

import com.amit.springaop.flightmanagement.dao.PassengerDaoImpl;
import com.amit.springaop.flightmanagement.domain.Passenger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Order(3)
@Aspect
public class CachingAspect {

    @Around("execution(* com.amit.springaop.flightmanagement.dao.PassengerDaoImpl.getPassenger(..))")
    public void cachePassenger(ProceedingJoinPoint  joinPoint) throws Throwable {
        Object[] methodArgs = joinPoint.getArgs();
        Passenger passenger = (Passenger)joinPoint.proceed();
        int id = (Integer) methodArgs[0];
        if(!PassengerDaoImpl.getPassengerMap().containsKey(id))
            PassengerDaoImpl.getPassengerMap().put(id,passenger);
    }
}
