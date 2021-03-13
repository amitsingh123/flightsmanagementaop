package com.amit.springaop.flightmanagement.flyer;

import com.amit.springaop.flightmanagement.domain.Flight;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

public class FlyerTest {

    @Test
    public void flyerTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("flightsmanagement/aop.xml");

        Flight flight = (Flight) context.getBean("flight");

        FlyerAdvisor flyerAdvisor = new FlyerAdvisor();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(flight);
        proxyFactory.addAdvisor(flyerAdvisor);
        proxyFactory.setOptimize(true);

        Flight proxyFlight = (Flight) proxyFactory.getProxy();

        assertTrue(proxyFlight instanceof Flight);
        System.out.println(proxyFlight.getId());
        System.out.println(proxyFlight.getCompany());

        assertTrue(proxyFlight instanceof Flyer);
        ((Flyer)proxyFlight).takeoff();
        ((Flyer)proxyFlight).fly();
        ((Flyer)proxyFlight).land();

        context.close();

    }
}
