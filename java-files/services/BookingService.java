package com.skybook.services;

import com.skybook.models.*;
import com.skybook.database.DatabaseManager;
import java.util.Date;
import java.util.Random;

public class BookingService {
    private DatabaseManager database;

    public BookingService() {
        this.database = DatabaseManager.getInstance();
    }

    public Booking createBooking(User user, Flight flight, String passengerName, 
                                int passengerAge, int passengerCount, 
                                double paymentAmount, boolean selectSeat) {
        // Determine if premium (seat selection) was paid
        boolean hasPremium = selectSeat;
        
        // Create payment
        Payment payment = new Payment(paymentAmount, "CARD", hasPremium);
        payment.processPayment();
        
        // Assign seat
        Seat seat;
        if (hasPremium) {
            seat = new Seat(generateSeatNumber(), flight.getZone(), false);
        } else {
            seat = new Seat(generateRandomSeat(), flight.getZone(), false);
        }
        seat.reserve();
        
        // Create booking
        Booking booking = new Booking(user, flight, passengerName, passengerAge, 
                                     passengerCount, seat, payment);
        
        // Generate QR code
        String qrCode = QRGenerator.generateQRCode(booking);
        booking.setQrCode(qrCode);
        
        // Save to database
        database.saveBooking(booking);
        
        return booking;
    }

    private String generateRandomSeat() {
        Random random = new Random();
        int row = 1 + random.nextInt(30);
        char col = (char) ('A' + random.nextInt(6));
        return row + String.valueOf(col);
    }

    private String generateSeatNumber() {
        return generateRandomSeat();
    }
}
