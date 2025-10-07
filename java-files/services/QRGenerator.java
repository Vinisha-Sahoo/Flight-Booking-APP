package com.skybook.services;

import com.skybook.models.Booking;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class QRGenerator {
    
    public static String generateQRCode(Booking booking) {
        String qrData = buildQRData(booking);
        // In production, use a proper QR library like ZXing or QRGen
        // For this example, we'll create a simple base64 encoded string
        return encodeToBase64(qrData);
    }

    private static String buildQRData(Booking booking) {
        StringBuilder sb = new StringBuilder();
        sb.append("BOOKING_ID:").append(booking.getBookingId()).append("|");
        sb.append("PASSENGER:").append(booking.getPassengerName()).append("|");
        sb.append("FLIGHT:").append(booking.getFlight().getFlightNumber()).append("|");
        sb.append("FROM:").append(booking.getFlight().getOrigin()).append("|");
        sb.append("TO:").append(booking.getFlight().getDestination()).append("|");
        sb.append("SEAT:").append(booking.getSeat().getSeatNumber()).append("|");
        sb.append("ZONE:").append(booking.getFlight().getZone());
        return sb.toString();
    }

    private static String encodeToBase64(String data) {
        byte[] encodedBytes = Base64.getEncoder().encode(data.getBytes(StandardCharsets.UTF_8));
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }

    public static String decodeQRCode(String qrCode) {
        byte[] decodedBytes = Base64.getDecoder().decode(qrCode.getBytes(StandardCharsets.UTF_8));
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
