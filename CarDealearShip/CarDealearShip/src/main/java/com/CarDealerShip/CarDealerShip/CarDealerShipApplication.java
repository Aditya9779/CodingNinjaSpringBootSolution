package com.CarDealerShip.CarDealerShip;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@Author(name = "Aditya Srivastava",date = "02-08-2024")
public class CarDealerShipApplication {

    public static void calldesign() {
        Scanner sc = new Scanner(System.in);

        /*This is spring container*/
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*It was as hard coded for the best method
        Car sC = (Car) context.getBean("sportsCar", Car.class);
        Car nC = (Car) context.getBean("familyCar", Car.class);
        Car tR = (Car) context.getBean("truck", Car.class); */

        Car carType = null;

        System.out.println("Hi, Please enter your name:");
        String name = sc.nextLine();

      /*  sC.setOwnerName(name);
        nC.setOwnerName(name);
        tR.setOwnerName(name);*/

        System.out.println("Please select your Car of Choice: \n1)Family Car \n2)Sports Car \n3)Truck \n0)Exit");

        int choice = sc.nextInt();
        int tyreChoise;
        switch (choice) {
            case 1:
                //This was hard coded
                /*  String ourReply=nC.getInfo();
                System.out.println(ourReply);*/
//                carType = context.getBean("familyCar", Car.class);  Provide with same tyre
                System.out.println("Enter with type of tyre you want \n1)Normal Tyre \n2)Sports Tyre \n3)Heavy Tyre "); //Povide with different tyre asking with the user
                tyreChoise = sc.nextInt();
                switch (tyreChoise) {
                    case 1:
                        carType = context.getBean("fcWithNormalTyre", Car.class);
                        break;
                    case 2:
                        carType = context.getBean("fcWithSportsTyre", Car.class);
                        break;
                    case 3:
                        carType = context.getBean("fcWithHeavyTyre", Car.class);
                        break;
                }
                break;
            case 2:
              /* String ourReply2= sC.getInfo();
               System.out.println(ourReply2);*/
                //carType = context.getBean("sportsCar", Car.class);
                System.out.println("Enter with type of tyre you want \n1)Normal Tyre \n2)Sports Tyre \n3)Heavy Tyre "); //Povide with different tyre asking with the user
                tyreChoise = sc.nextInt();
                switch (tyreChoise) {
                    case 1:
                        carType = context.getBean("sportsCarNt", Car.class);
                        break;
                    case 2:
                        carType = context.getBean("sportsCarSt", Car.class);
                        break;
                    case 3:
                        carType = context.getBean("sportsCarHt", Car.class);
                        break;
                }
                break;
            case 3:
              /* String ourRepl3= tR.getInfo();
                System.out.println(ourRepl3);*/
                //  carType = context.getBean("truckCar", Car.class);
                System.out.println("Enter with type of tyre you want \n1)Normal Tyre \n2)Sports Tyre \n3)Heavy Tyre "); //Povide with different tyre asking with the user
                tyreChoise = sc.nextInt();
                switch (tyreChoise) {
                    case 1:
                        carType = context.getBean("truckCarNt", Car.class);
                        break;
                    case 2:
                        carType = context.getBean("truckCarWithSt", Car.class);
                        break;
                    case 3:
                        carType = context.getBean("truckCarHt", Car.class);
                        break;
                }
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
        }

        if (carType != null) {
            carType.setOwnerName(name);
            String printInfo = carType.getInfo();
            System.out.println(printInfo);
        }
    }

    public static void main(String[] args) {

        calldesign();

    }

}
