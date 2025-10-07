package com.skybook;

import com.skybook.models.*;
import com.skybook.services.*;
import com.skybook.database.DatabaseManager;
import java.util.Date;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SkyBook Flight Booking System ===\n");

        // Initialize database
        DatabaseManager db = DatabaseManager.getInstance();

        // Create a user
        User user = new User("John Doe", "john@example.com", "+91-9876543210", "password123");
        db.saveUser(user);
        System.out.println("User created: " + user);

        // Get an airline
        Airline airline = db.getAirline("1"); // Indigo
        System.out.println("Selected airline: " + airline);

        // Create flight date (30 days from now)
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date flightDate = cal.getTime();

        // Create a flight
        Flight flight = new Flight(airline, "DEL", "BOM", flightDate);
        System.out.println("Flight created: " + flight);

        // Calculate price
        double distance = PricingEngine.calculateDistance(28.7041, 77.1025, 19.0760, 72.8777);
        double price = PricingEngine.calculatePrice(distance, flightDate, airline.getBasePrice(), 1);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Calculated price: ₹" + price);

        // Create booking
        BookingService bookingService = new BookingService();
        Booking booking = bookingService.createBooking(user, flight, "John Doe", 30, 1, price + 1000, true);
        System.out.println("\nBooking created: " + booking);
        System.out.println("Seat: " + booking.getSeat());
        System.out.println("Payment: " + booking.getPayment());
        System.out.println("QR Code: " + booking.getQrCode());

        System.out.println("\n=== Booking Complete ===");
    }
}
