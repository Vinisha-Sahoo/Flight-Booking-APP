package com.skybook.models;

import java.util.Date;
import java.util.UUID;

public class Payment {
    private String paymentId;
    private double amount;
    private Date paymentDate;
    private String paymentMethod;
    private boolean hasPremium;
    private PaymentStatus status;

    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED, REFUNDED
    }

    public Payment(double amount, String paymentMethod, boolean hasPremium) {
        this.paymentId = UUID.randomUUID().toString();
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.hasPremium = hasPremium;
        this.paymentDate = new Date();
        this.status = PaymentStatus.PENDING;
    }

    public void processPayment() {
        this.status = PaymentStatus.COMPLETED;
    }

    public void refund() {
        this.status = PaymentStatus.REFUNDED;
    }

    // Getters and Setters
    public String getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public Date getPaymentDate() { return paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public boolean hasPremium() { return hasPremium; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Payment{id='" + paymentId + "', amount=" + amount + ", status=" + status + "}";
    }
}
