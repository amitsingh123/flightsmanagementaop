package com.amit.springaop.flightmanagement.dao;

import com.amit.springaop.flightmanagement.domain.Passenger;

public interface PassengerDao {

    Passenger getPassenger(int id);
    void add(Passenger passenger);
}
