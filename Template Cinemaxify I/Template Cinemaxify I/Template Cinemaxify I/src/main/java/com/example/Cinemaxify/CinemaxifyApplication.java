/*
package com.example.Cinemaxify;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

// 1. Beginner Code Template is already provided to you.
// 2. Just follow the below task to complete the execution of main application.
@SpringBootApplication
public class CinemaxifyApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner scanner = new Scanner(System.in);
        User sp = context.getBean("spouse", User.class);
        User se = context.getBean("self", User.class);
        System.out.println("Welcome to the Cinemaxify Application");
        System.out.println("Please select the member you want the plan for:");
        System.out.println("1. Self\n2. Spouse");
        String userType = "";
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        switch (userChoice) {
            case 1 -> {
                // a. Set userType according to the userChoice.
                System.out.println("Please enter the your name:");
                String userName = scanner.nextLine();
                System.out.println("Please enter the your age:");
                int age = scanner.nextInt();
                System.out.println("Please enter the contact:");
                long contact = scanner.nextInt();
                System.out.println("Please enter the Text address:");
                String textAddress = scanner.nextLine();
                se.setUserDetails(userName, age, contact, textAddress);
                se.getUserDetails();
                break;

            }
            case 2 -> {
                // b. Set userType according to the userChoice.
                System.out.println("Please enter the your name:");
                String userName = scanner.nextLine();
                System.out.println("Please enter the your age:");
                int age = scanner.nextInt();
                System.out.println("Please enter the contact:");
                long contact = scanner.nextInt();
                System.out.println("Please enter the Text address:");
                String textAddress = scanner.nextLine();
                sp.setUserDetails(userName, age, contact, textAddress);
                sp.getUserDetails();
                break;
            }
            case 3 -> {
                // c. Print "Exiting..." and return
                System.out.println("Exiting...");
                return;
            }
            default -> {
                // d. Print "Invalid choice." and return
                // .
                System.out.println("Invalid choice");
                return;

            }
        }
        // e. Pick the user bean using context.getBean().
        User user = ;
        // f. Take input for User details i.e. name , age, address etc.

        // g. Set the above fetched details into the user by using appropriate method.

        // h. finally print the details by using appropriate method.
    }
}*/
/*This is the imp and more great method to write the code*/
package com.example.Cinemaxify;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
@Author(name = "Aditya Srivastava",date = "02-08-2024")
@SpringBootApplication
public class CinemaxifyApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Cinemaxify Application");
        System.out.println("Please select the member you want the plan for:");
        System.out.println("1. Self\n2. Spouse\n3. Exit");

        int userChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        User user = null;

        switch (userChoice) {
            case 1 :user = context.getBean("self", User.class);
            break;
            case 2 : user = context.getBean("spouse", User.class);
            break;
            case 3:
                System.out.println("Exiting...");
                return;

            default :
                System.out.println("Invalid choice.");
                return;
            
        }

        if (user != null) {
            System.out.println("Please enter your name:");
            String userName = scanner.nextLine();
            System.out.println("Please enter your age:");
            int age = scanner.nextInt();
            System.out.println("Please enter the contact:");
            long contact = scanner.nextLong();
            scanner.nextLine();  // Consume newline
            System.out.println("Please enter the address:");
            String address = scanner.nextLine();

            user.setUserDetails(userName, age, contact, address);
            user.getUserDetails();
        }

        scanner.close();
        context.close();
    }
}
