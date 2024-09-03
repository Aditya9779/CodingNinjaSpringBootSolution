package com.payMeNow.demo;

public class CreditCardPaymentService implements PaymentService {
    private double amount;

    public void payAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return "Credit Card";
    }

    @Override
    public void processPayment() {
        System.out.println("Processing " + getType() + " payment of $" + this.amount);
    }
}
