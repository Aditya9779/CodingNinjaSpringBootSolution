package com.CoverMate.CoverMate;


import org.apache.catalina.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@Author(name = "Aditya Srivastava",date = "04-08-2024")
public class CoverMateApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Insurance Application");
        System.out.println("What is your name? ");
        String name = sc.nextLine();
        System.out.println("What is your age? ");
        int age = sc.nextInt();

        System.out.println("Which Insurance do you want?");
        System.out.println("Select 1 or 2 from the Below Options \n1 - Health Insurance" +
                "\n2 - Term Insurance");
        int option = sc.nextInt();
        String insuranceData = "";
        String insuranceId = "";
        String insuranceName = "";
        switch (option) {
            case 1:
                insuranceName = "Health Insurance";
                insuranceData = "cHi";
                insuranceId = "hI";
                break;
            case 2:
                insuranceName = "Term Insurance";
                insuranceData = "cTi";
                insuranceId = "tI";
                break;
        }

        System.out.println("You have chossen " + insuranceName + ".");
        sc.nextLine();
        if (option == 1) {
            System.out.println("Are you Drinker? Y or N");
            String drinkerData = sc.nextLine();
            System.out.println("Are you Smoker? Y or N");
            String smokerData = sc.nextLine();
            System.out.println("Do you have prior health contions? Y or N ");
            String priorHealthContionsData = sc.nextLine();
            boolean convertDrinkerData = (drinkerData.equals("Y"));
            boolean convertSmokerData = (smokerData.equals("Y"));
            boolean convertPriorHealthContions = (priorHealthContionsData.equals("Y"));
            Customer customer = context.getBean(insuranceData, Customer.class);
            Insurance insurance = context.getBean(insuranceId, Insurance.class);
            customer.setCustomerDetails(name, age);
            insurance.setInsurenceDetails(convertDrinkerData, convertSmokerData, convertPriorHealthContions);
            customer.getDeatils();
        } else {
            System.out.println("Are you a Married? Y or N");
            boolean married = sc.next().charAt(0) == 'Y' ? true : false;
            System.out.println("Do you have children? Y or N");
            boolean children = sc.next().charAt(0) == 'Y' ? true : false;
            System.out.println("Are you salaried? Y or N");
            boolean isSalaried = sc.next().charAt(0) == 'Y' ? true : false;
            Customer customer = context.getBean(insuranceData, Customer.class);
            Insurance insurance = context.getBean(insuranceId, Insurance.class);
            customer.setCustomerDetails(name, age);
            insurance.setInsurenceDetails(married, children, isSalaried);
            customer.getDeatils();
        }


    }

}
