package com.skybook.database;

import com.skybook.models.*;
import java.util.*;

public class DatabaseManager {
    private static DatabaseManager instance;
    private Map<String, User> users;
    private Map<String, Booking> bookings;
    private Map<String, Airline> airlines;
    private Map<String, Flight> flights;

    private DatabaseManager() {
        users = new HashMap<>();
        bookings = new HashMap<>();
        airlines = new HashMap<>();
        flights = new HashMap<>();
        initializeAirlines();
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    private void initializeAirlines() {
        airlines.put("1", new Airline("1", "Indigo", "6E", "#1c3a6e", 3500, ""));
        airlines.put("2", new Airline("2", "Air India", "AI", "#d32f2f", 4200, ""));
        airlines.put("3", new Airline("3", "SpiceJet", "SG", "#e31e24", 3200, ""));
        airlines.put("4", new Airline("4", "Vistara", "UK", "#6b3fa0", 4800, ""));
        airlines.put("5", new Airline("5", "AirAsia", "I5", "#ff0000", 2900, ""));
        airlines.put("6", new Airline("6", "GoAir", "G8", "#f58220", 3100, ""));
    }

    public void saveUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void saveBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public Booking getBooking(String bookingId) {
        return bookings.get(bookingId);
    }

    public Airline getAirline(String airlineId) {
        return airlines.get(airlineId);
    }

    public List<Airline> getAllAirlines() {
        return new ArrayList<>(airlines.values());
    }
}
