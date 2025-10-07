package com.skybook.models;

public class Seat {
    private String seatNumber;
    private String zone;
    private boolean isAvailable;
    private boolean isPremium;

    public Seat(String seatNumber, String zone, boolean isAvailable) {
        this.seatNumber = seatNumber;
        this.zone = zone;
        this.isAvailable = isAvailable;
        this.isPremium = false;
    }

    public void reserve() {
        this.isAvailable = false;
    }

    public void release() {
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    
    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }
    
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    
    public boolean isPremium() { return isPremium; }
    public void setPremium(boolean premium) { isPremium = premium; }

    @Override
    public String toString() {
        return "Seat{number='" + seatNumber + "', zone='" + zone + "', available=" + isAvailable + "}";
    }
}
