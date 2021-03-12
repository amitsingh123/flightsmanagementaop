package com.amit.springaop.flightmanagement.domain;

public class Ticket {
    private int number;
    private Passenger passenger;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String emittingCountry() {
        return passenger.getCountry();
    }

    @Override
    public String toString() {
        return "Ticket Number " + number;
    }
}
