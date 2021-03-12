package com.amit.springaop.flightmanagement.domain;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlightManagement {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("flightsmanagement/aop.xml");
        Flight flight = (Flight)context.getBean("flight");
        flight.print();
        System.out.println(flight.getId());
        flight.setId("AIR1234");
        System.out.println(flight.getCompany());

        for (Passenger passenger: flight.getPassengers())
        {
            System.out.println(passenger.getName());
            passenger.print();
        }

        Ticket ticket = (Ticket)context.getBean("ticket");
        ticket.setNumber(995566120);
        System.out.println("ticket number.."+ticket.getNumber());

        context.close();
    }
}
