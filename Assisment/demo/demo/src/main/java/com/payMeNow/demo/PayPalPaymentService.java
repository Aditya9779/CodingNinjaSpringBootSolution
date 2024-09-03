package com.payMeNow.demo;

public class PayPalPaymentService implements PaymentService {
    private double amount;

    public void payAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return "PayPal";
    }

    @Override
    public void processPayment() {
        System.out.println("Processing " + getType() + " payment of $" + this.amount);
    }
}
