package com.WW.WeatherWatchers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class WeatherWatchersApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Location location = (Location) context.getBean("myLocation");
        System.out.println("Welcome to Weather Application");
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your city: ");
        String city = sc.nextLine();
        System.out.println("Enter your state: ");
        String state = sc.nextLine();
        System.out.println("Enter your country: ");
        String country = sc.nextLine();
        User user = context.getBean("myUser", User.class);
        user.setUserDetails(name, age);
        user.setLocationDetails(city, state, country);
        System.out.println(user.getWeatherForecastForLocation());
        context.close();
        sc.close();


    }
}
