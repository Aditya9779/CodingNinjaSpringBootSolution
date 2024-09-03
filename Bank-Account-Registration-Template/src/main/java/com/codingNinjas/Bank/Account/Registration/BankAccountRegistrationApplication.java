package com.codingNinjas.Bank.Account.Registration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class BankAccountRegistrationApplication {

    public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		*/
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Scanner scanner = new Scanner(System.in);

        User user = context.getBean("myUser", User.class);
        System.out.println("Welcome to Account Registration Application!");
        System.out.println("Please enter Your name?");
        String name = scanner.nextLine();
        user.setUserDetails(name);
        System.out.println("Do you want to add account \n1. Yes\n2. No");
        int choice = scanner.nextInt();
        boolean quit = false;
        switch (choice) {
            case 1:
                quit = true;
                break;
            case 2:
                quit = false;
                break;
        }
        while (quit) {
            String id = "";
            System.out.println("Please select the account type\n1. Current\n2. Savings");
            int choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    id = "currentAccount";
                    break;
                case 2:
                    id = "savingsAccount";
                    break;
            }
            Account account = context.getBean(id, Account.class);
            user.addAccount(account);
            System.out.println("Enter the opening balance");
            double openingBalance = scanner.nextDouble();
            account.addBalance(openingBalance);
            System.out.println("Do you want to add more accounts\n1. Yes\n 2. No");
            int choice2 = scanner.nextInt();
            if (choice2 == 2) {
                quit = false;
            }
        }

        System.out.println("Hi " + user.getName() + ", here is the list of your accounts:");
        for (Account acc : user.getAllAccounts()) {
            System.out.println(acc.getAccountType() + ": opening balance - " + acc.getBalance() + ", Reference Id - @" + acc.hashCode());
        }
        scanner.close();
        context.close();


    }

}
