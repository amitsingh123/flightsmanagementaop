package com.amit.springaop.flightmanagement.aspects;

import com.amit.springaop.flightmanagement.exception.CountryDoesNotExistException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class CountryDoesNotExistAspect {

    private Logger logger = Logger.getLogger(CountryDoesNotExistAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* com.amit.springaop.flightmanagement.dao.PassengerDaoImpl.add(..))",
    throwing="ex")
    public void log(CountryDoesNotExistException ex){
        logger.severe("Attempt to insert a passenger with an unexisting country code : "+ex.getCountryCode());
    }
}
