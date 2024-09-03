
package com.example.CustomerServicedemo;

import com.example.Author;
import com.example.Customers.CustomerCare;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@Author(name = "Aditya Srivastava" ,date = "01-08-2024")
public class CustomerServicedemoApplication {

    public static void main(String[] args) {
        // Load the beans from ApplicationContext.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        // Get beans for each department
        CustomerCare salesDepartment = context.getBean("salesDepartment", CustomerCare.class);
        CustomerCare queryDepartment = context.getBean("queryDepartment", CustomerCare.class);
        CustomerCare paymentDepartment = context.getBean("paymentDepartment", CustomerCare.class);

        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Welcome message and getting user input
        System.out.println("Welcome to our Customer Care application");
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Thanks for reaching us " + userName);

        // Set customer name for all departments
        salesDepartment.setCustomerName(userName);
        queryDepartment.setCustomerName(userName);
        paymentDepartment.setCustomerName(userName);

        // Display departments and get user choice
        System.out.println("Please select a department to connect to: \n1. Payment Department \n2. Query Department \n3. Sales Department \n0. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                paymentDepartment.getService();
                String problemPaymentDepartment = scanner.nextLine();
                paymentDepartment.setProblem(problemPaymentDepartment);
                paymentDepartment.getProblem();
                break;

            case 2:
                queryDepartment.getService();
                String problemQueryDepartment = scanner.nextLine();
                queryDepartment.setProblem(problemQueryDepartment);
                queryDepartment.getProblem();
                break;

            case 3:
                salesDepartment.getService();
                String problemSalesDepartment = scanner.nextLine();
                salesDepartment.setProblem(problemSalesDepartment);
                salesDepartment.getProblem();
                break;

            case 0:
                System.out.println("Exiting the application.");
                break;

            default:
                System.out.println("Invalid choice. Exiting the application.");
                break;
        }

        // Close the context
        context.close();
    }
}
