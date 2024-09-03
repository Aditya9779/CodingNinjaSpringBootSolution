package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@Author(name = "Aditya Srivastava", date = "31-07-2024")
public class TaxApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Tax Payment Application");
        while (true) {
            System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property\n3. Exit");
            int userChoice = scanner.nextInt();
            String taxChoice = "";
            switch (userChoice) {
                case 1 -> {
                    // Set the taxChoice string as the Income tax bean id.
                    taxChoice = "incomeTax";
                    break;

                }
                case 2 -> {
                    // Set the taxChoice string as the Property tax bean id.
                    taxChoice = "propertyTax";
                    break;
                }
                case 3 -> {
                    // Print the message "Exiting..." and return.
                    System.out.println("Exiting...");
                    return;

                }
                default -> {
                    // Print the message "Invalid choice" and return.
                    System.out.println("Invalid choice");
                    return;
                }
            }
            // Pick the tax bean using context.getBean() method using taxChoice string.
            Tax tax = context.getBean(taxChoice, Tax.class);
            System.out.println(tax.getTaxType());
        }
    }

}
