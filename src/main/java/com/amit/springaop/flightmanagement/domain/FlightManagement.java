package com.amit.springaop.flightmanagement.domain;

import com.amit.springaop.flightmanagement.dao.PassengerDao;
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

        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDaoImpl");
        passengerDao.getPassenger(1);

        passengerDao.getPassenger(1);

        Passenger passenger = new Passenger();
        passenger.setName("Mike");
        passenger.setCountry("RR");

        passengerDao.add(passenger);

        context.close();
    }
}
