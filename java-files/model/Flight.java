package com.skybook.models;

import java.util.Date;
import java.util.Random;

public class Flight {
    private String flightNumber;
    private Airline airline;
    private String origin;
    private String destination;
    private Date departureDate;
    private String zone;

    public Flight(Airline airline, String origin, String destination, Date departureDate) {
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.flightNumber = generateFlightNumber(airline.getCode());
        this.zone = generateZone();
    }

    private String generateFlightNumber(String airlineCode) {
        Random random = new Random();
        int number = 1000 + random.nextInt(9000);
        return airlineCode + number;
    }

    private String generateZone() {
        String[] zones = {"A", "B", "C"};
        Random random = new Random();
        return zones[random.nextInt(zones.length)];
    }

    // Getters and Setters
    public String getFlightNumber() { return flightNumber; }
    public Airline getAirline() { return airline; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public Date getDepartureDate() { return departureDate; }
    public String getZone() { return zone; }

    @Override
    public String toString() {
        return "Flight{number='" + flightNumber + "', from='" + origin + "', to='" + destination + "'}";
    }
}
