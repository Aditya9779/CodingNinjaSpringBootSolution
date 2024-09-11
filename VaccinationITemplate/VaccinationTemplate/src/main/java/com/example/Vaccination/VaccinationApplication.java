package com.example.Vaccination;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@Author(name = "Aditya Srivastava" , date = "04-08-2024")
public class VaccinationApplication {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Scanner scanner = new Scanner(System.in);
        boolean continueBooking = true;
        while (continueBooking) {
            System.out.println("Welcome to the Vaccination Application");
            System.out.println("Please choose your vaccine preference: \n1. Covid \n2. Polio \n3. Typhoid");
            int choiceVaccine = scanner.nextInt();
            String vaccineChoice = "";
            switch (choiceVaccine) {
                case 1:
                    vaccineChoice = "covid";
                    break;
                case 2:
                    vaccineChoice = "polio";
                    break;
                case 3:
                    vaccineChoice = "typhoid";
                    break;
            }
            System.out.println("Whom do you want to vaccinate \n1. Father" +
                    "\n2. Mother \n3. Self \n4. Spouse \n5. Exit");
            int choiceWhom = scanner.nextInt();
            String whomChoiceWithVac = "";
            String nameOfPatients = "";
            switch (choiceWhom) {
                case 1:
                    nameOfPatients = "Father";
                    if (vaccineChoice.equals("covid")) whomChoiceWithVac = "fatherCovid";
                    else if (vaccineChoice.equals("polio")) whomChoiceWithVac = "fatherPolio";
                    else if (vaccineChoice.equals("typhoid")) whomChoiceWithVac = "fatherTyphoid";
                    break;
                case 2:
                    nameOfPatients = "Mother";
                    if (vaccineChoice.equals("covid")) whomChoiceWithVac = "motherCovid";
                    else if (vaccineChoice.equals("polio")) whomChoiceWithVac = "motherPolio";
                    else if (vaccineChoice.equals("typhoid")) whomChoiceWithVac = "motherTyphoid";
                    break;
                case 3:
                    nameOfPatients = "Self";
                    if (vaccineChoice.equals("covid")) whomChoiceWithVac = "selfCovid";
                    else if (vaccineChoice.equals("polio")) whomChoiceWithVac = "selfPolio";
                    else if (vaccineChoice.equals("typhoid")) whomChoiceWithVac = "selfTyphoid";
                    break;
                case 4:
                    nameOfPatients = "Spouse";
                    if (vaccineChoice.equals("covid")) whomChoiceWithVac = "spouseCovid";
                    else if (vaccineChoice.equals("polio")) whomChoiceWithVac = "spousePolio";
                    else if (vaccineChoice.equals("typhoid")) whomChoiceWithVac = "spouseTyphoid";
                    break;
                case 5:
                    break;
            }
            //Very Imp how to take the input in scanner
            User user = context.getBean(whomChoiceWithVac, User.class);
            if (user.IsVaccinated()) {
                System.out.println("User is already Vaccinated");
            } else {
                System.out.println("Please enter " + nameOfPatients + " details:");
                System.out.print("Name: ");
                scanner.nextLine(); // Clear the buffer
                String nameDetails = scanner.nextLine();
                System.out.print("Age: ");
                int ageDetails = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                System.out.print("Appointment date (YYYY-MM-DD): ");
                String dateDetails = scanner.nextLine();
                System.out.print("Appointment time (HH:MM AM/PM): ");
                String timeDetails = scanner.nextLine();
                System.out.print("Appointment location: ");
                String locationDetails = scanner.nextLine();


                TimeAndLocation timeAndLocation = context.getBean("timeAndLocation", TimeAndLocation.class);
                timeAndLocation.setDetails(timeDetails, locationDetails, dateDetails);
                user.setUserDetails(nameDetails, ageDetails, timeAndLocation);
                user.setAppointment();
            }
            System.out.println(" Do you want to register for someone Else\n1. Yes \n2. No");
            int restartChoice = scanner.nextInt();
            continueBooking = (restartChoice == 1); //its returing true then you have to start
        }
    }

}
