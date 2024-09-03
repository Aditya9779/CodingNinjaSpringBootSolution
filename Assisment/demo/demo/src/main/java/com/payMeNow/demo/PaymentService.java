package com.payMeNow.demo;

public interface PaymentService {
    void payAmount(double amount);

    void processPayment();

    String getType();
}
