package com.example.Cinemaxify;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@Author(name = "Aditya Srivastava" ,date = "03-08-2024")
public class CinemaxifyApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Cinemaxify Application");
        while (true) {
            System.out.println("Please select the member you want the plan for:");
            System.out.println("1. Self\n2. Spouse");
            String userType = "";
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1 -> userType = "self";
                case 2 -> userType = "spouse";
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice.");
                    return;
                }
            }

            /**
             a. Print the below message into console:

             Please select your plan:
             1. Normal
             2. Premium
             **/

            System.out.println("Please select your plan: \n1. Normal \n2. Premium");
            int planChoice = scanner.nextInt();
            scanner.nextLine();
            String myPlan = "";
            switch (planChoice) {
                case 1 -> {
                    // b. Set myPlan according to the planChoice.
                    myPlan = "Normal";

                }
                case 2 -> {
                    // c. Set myPlan according to the planChoice.
                    myPlan = "Premium";
                }
                default -> {
                    // d. Print "invalid choice" and return.
                    System.out.println("Invalid choice.");
                    return;
                }
            }
            /**  e. Pick the user bean using context.getBean() and use 'userType' + 'planChoice'
             in combination to call the required bean.                                 **/
            String response = userType + myPlan; //Its Was making the full id name selfNormal
            User user = context.getBean(response, User.class);


            /**

             f. Input details for selected user

             g. Take input for User details i.e. name , age, address etc.

             h. Set the above fetched details into the user by using appropriate method.

             i. Lastly print the following message into console

             Do you want to purchase plan for someone else
             1. Yes
             2. No
             **/

            System.out.println("Please enter your name:");
            String name = scanner.nextLine();
            System.out.println("Please enter your age:");
            int age = scanner.nextInt();
            System.out.println("Please enter your contact:");
            long contactNo = scanner.nextLong();
            scanner.nextLine();
            System.out.println("Please enter your address:");
            String address = scanner.nextLine();

            user.setUserDetails(name, age, contactNo, address);

            user.getUserDetails();

            System.out.println("Do you want to purchase plan for someone else \n1. Yes\n2. No");
            int input = scanner.nextInt();
            if (input == 2) break;
        }

    }

}
