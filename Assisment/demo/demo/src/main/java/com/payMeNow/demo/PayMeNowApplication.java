package com.payMeNow.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@Author(name = "Aditya Srivastava", date = "02-08-2024")
public class PayMeNowApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Payment Amount");

        //Setting the beans id for calling the function
        PaymentService bankT = context.getBean("bank", PaymentService.class);
        PaymentService creditT = context.getBean("credit", PaymentService.class);
        PaymentService payT = context.getBean("pal", PaymentService.class);
        int amount = sc.nextInt();

        //Setting the amount
        bankT.payAmount(amount);
        creditT.payAmount(amount);
        payT.payAmount(amount);

        //Moving to the new line of the for taking the input
        sc.nextLine();
        System.out.println("Enter payment method (CreditCard, PayPal, or Bank Transfer)");
        String method = sc.nextLine();
        if (method.equals("CreditCard")) {
            creditT.processPayment();
        } else if (method.equals("PayPal")) {
            payT.processPayment();
        } else if (method.equals("BankTransfer")) {
            bankT.processPayment();
        } else {
            System.out.println("Invalid Method");
        }
    }

}
