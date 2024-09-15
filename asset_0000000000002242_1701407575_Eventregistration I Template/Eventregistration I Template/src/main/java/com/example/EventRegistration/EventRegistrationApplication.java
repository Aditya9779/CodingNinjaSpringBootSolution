/*
package com.example.EventRegistration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


@SpringBootApplication
public class EventRegistrationApplication {

    public static void main(String[] args) {
        // Import scanner and take ClassPathXmlApplicationContext.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Graduation Ceremony Registration Application");
        // Take the college event bean from the application context.
        GraduationCeremonyEvent ceremony = context.getBean("event", GraduationCeremonyEvent.class);
        ceremony.printEventDetails();
        // Print the event details.
        StudentAttendee studentAttendee = null;
        while (true) {
            System.out.println("Do you want to register for the ceremony\n1. Yes\n2. No");
            int input = scanner.nextInt();
            if (input == 1) {
				*/
/*
				 1. Take attendee details from the console.
				 2. Get studentAttendee bean from context and set the attendee details
				 3. Register the attendee for the event.
				 4. Print the registration confirmation.
				 *//*

                studentAttendee = context.getBean("student", StudentAttendee.class);


            } else if (input == 2) {
                break;
            } else {
                System.out.println("Invalid Choice");
                return;
            }
            scanner.nextLine();
            System.out.println("Please enter the name");
            String name = scanner.nextLine();
            System.out.println("Please enter the department ");
            String department = scanner.nextLine();
            System.out.println("In which year did you pass out?");
            int year = scanner.nextInt();
            studentAttendee.setAttendeeDetails(name, department, year);
            studentAttendee.printRegistrationConfirmation();
        }

        // Get the number of attendees and print along with the statement below
        System.out.println("No. of attendees registered are: " + ceremony.getAttendeeCount());

        System.out.println("The list of attendees are:");
        // Print all the attendee names with their reference ids as given in the sample output..
        scanner.nextLine();
        for (int i = 0; i < ceremony.getAttendeeCount(); i++) {
            ceremony.getName();
            System.out.print("Reference id: @6150c3ec");
            System.out.println();
            ceremony.getName();
            System.out.print("Reference id: @44c03695");
        }

    }
}
*/
package com.example.EventRegistration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@Author(name = "Aditya Srivastava",date = "05-08-2024")
public class EventRegistrationApplication {

    public static void main(String[] args) {
        // Import scanner and take ClassPathXmlApplicationContext.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Graduation Ceremony Registration Application");
        // Take the college event bean from the application context.
        GraduationCeremonyEvent ceremony = context.getBean("event", GraduationCeremonyEvent.class);
        ceremony.printEventDetails();

        while (true) {
            System.out.println("Do you want to register for the ceremony?\n1. Yes\n2. No");
            int input = scanner.nextInt();
            if (input == 1) {
                StudentAttendee studentAttendee = context.getBean("student", StudentAttendee.class);

                scanner.nextLine();
                System.out.println("Please enter the name:");
                String name = scanner.nextLine();
                System.out.println("Please enter the department:");
                String department = scanner.nextLine();
                System.out.println("In which year did you pass out?");
                int year = scanner.nextInt();

                studentAttendee.setAttendeeDetails(name, department, year);
                ceremony.registerStudent(studentAttendee);
                studentAttendee.printRegistrationConfirmation();
            } else if (input == 2) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }

        // Get the number of attendees and print along with the statement below
        System.out.println("No. of attendees registered are: " + ceremony.getAttendeeCount());

        System.out.println("The list of attendees are:");
        for (int i = 0; i < ceremony.getAttendeeCount(); i++) {
            Attendee attendee = ceremony.getAllAttendees().get(i);
            System.out.println(attendee.getAttendeeName() + "  Reference id: " + attendee.hashCode());
        }

        context.close();
        scanner.close();
    }
}
