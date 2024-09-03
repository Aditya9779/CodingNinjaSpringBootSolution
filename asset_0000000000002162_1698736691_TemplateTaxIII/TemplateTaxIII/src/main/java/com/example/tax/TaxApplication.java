/*
package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
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
                case 1 -> taxChoice = "incomeTax";
                case 2 -> taxChoice = "propertyTax";
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice");
                    return;
                }
            }
            Tax tax = (Tax) context.getBean(taxChoice);
			*/
/*
			1. Check if the tax is already paid, if yes print the message:
			    "You have already paid Income/Property(get this getTaxType() interface method) tax."
			2. If the tax is not paid:
				a. Take the input of taxableAmount from the user.
				b. Set the taxableAmount using setTaxableAmount() interface method.
				c. Calculate the taxAmount using calculateTaxAmount() interface method.
				d. Ask user if he wants to pay the tax. if yes call the payTax() method.
			 *//*

            boolean isPayed = tax.isTaxPayed();
            if (isPayed) {
                System.out.println("You have already paid Income/Property " + tax.getTaxType() + " tax.");
            } else {
                int input = scanner.nextInt();
                tax.setTaxableAmount(input);
                tax.calculateTaxAmount();
                String response = scanner.next();
                if (response.equals("yes")) {
                    tax.payTax();
                }
            }


        }
    }

}
*/
package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@Author(name = "Aditya Srivastava" ,date = "01-08-2024")
public class TaxApplication {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Welcome to the Tax Payment Application");

            while (true) {
                System.out.println("Please select which tax you want to pay:\n1. Income\n2. Property\n3. Exit");
                int userChoice = scanner.nextInt();
                String taxChoice;

                switch (userChoice) {
                    case 1 -> taxChoice = "incomeTax";
                    case 2 -> taxChoice = "propertyTax";
                    case 3 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> {
                        System.out.println("Invalid choice. Please select again.");
                        continue;
                    }
                }

                Tax tax = (Tax) context.getBean(taxChoice);

                if (tax.isTaxPayed()) {
                    System.out.println("You have already paid " + tax.getTaxType() + " tax.");
                } else {
                    System.out.println("Please enter your " + tax.getTaxType() + " value:");
                    int input = scanner.nextInt();
                    tax.setTaxableAmount(input);
                    tax.calculateTaxAmount();

                    System.out.println("You have selected " + tax.getTaxType() + " tax and your tax amount is: " + tax.getTaxAmount());
                    System.out.println("Do you want to pay the tax?\n1. Yes\n2. No");

                    int response = scanner.nextInt();
                    if (response == 1) {
                        tax.payTax();
                        System.out.println("Hi, your " + tax.getTaxType() + " tax is paid.");
                    } else {
                        System.out.println("Tax payment cancelled.");
                    }
                }
            }
        }
    }
}
