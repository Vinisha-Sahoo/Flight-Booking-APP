package com.skybook.services;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PricingEngine {
    private static final double PRICE_PER_KM = 5.0;
    private static final double EARLY_BOOKING_DISCOUNT = 0.7; // 30% off
    private static final double LATE_BOOKING_PREMIUM = 1.3;   // 30% extra
    private static final int EARLY_BOOKING_DAYS = 60;
    private static final int LATE_BOOKING_DAYS = 7;

    public static double calculatePrice(double distance, Date flightDate, 
                                       double basePrice, int passengerCount) {
        double distancePrice = distance * PRICE_PER_KM;
        double dateMultiplier = calculateDateMultiplier(flightDate);
        double totalPrice = (basePrice + distancePrice) * dateMultiplier * passengerCount;
        return Math.round(totalPrice * 100.0) / 100.0;
    }

    private static double calculateDateMultiplier(Date flightDate) {
        Date today = new Date();
        long diffInMillis = flightDate.getTime() - today.getTime();
        long daysUntilFlight = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        if (daysUntilFlight >= EARLY_BOOKING_DAYS) {
            return EARLY_BOOKING_DISCOUNT;
        } else if (daysUntilFlight <= LATE_BOOKING_DAYS) {
            return LATE_BOOKING_PREMIUM;
        }
        return 1.0;
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Earth radius in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
