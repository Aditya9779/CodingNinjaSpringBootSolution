package com.payMeNow.demo;

public class BankTransferPaymentService implements PaymentService {
    private double amount;

    public void payAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return "Bank Transfer";
    }


    @Override
    public void processPayment() {
        System.out.println("Processing " + getType() + " payment of $" + this.amount);
    }
}
