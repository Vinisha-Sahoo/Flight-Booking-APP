package com.skybook.models;

import java.util.UUID;
import java.util.Date;

public class Booking {
    private String bookingId;
    private User user;
    private Flight flight;
    private String passengerName;
    private int passengerAge;
    private int passengerCount;
    private Seat seat;
    private Payment payment;
    private Date bookingDate;
    private String qrCode;

    public Booking(User user, Flight flight, String passengerName, int passengerAge, 
                   int passengerCount, Seat seat, Payment payment) {
        this.bookingId = UUID.randomUUID().toString();
        this.user = user;
        this.flight = flight;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.passengerCount = passengerCount;
        this.seat = seat;
        this.payment = payment;
        this.bookingDate = new Date();
    }

    // Getters and Setters
    public String getBookingId() { return bookingId; }
    public User getUser() { return user; }
    public Flight getFlight() { return flight; }
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String name) { this.passengerName = name; }
    public int getPassengerAge() { return passengerAge; }
    public void setPassengerAge(int age) { this.passengerAge = age; }
    public int getPassengerCount() { return passengerCount; }
    public Seat getSeat() { return seat; }
    public Payment getPayment() { return payment; }
    public Date getBookingDate() { return bookingDate; }
    public String getQrCode() { return qrCode; }
    public void setQrCode(String qrCode) { this.qrCode = qrCode; }

    @Override
    public String toString() {
        return "Booking{id='" + bookingId + "', passenger='" + passengerName + "', flight=" + flight + "}";
    }
}
