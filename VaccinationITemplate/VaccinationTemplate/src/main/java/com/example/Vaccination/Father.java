package com.example.Vaccination;

import com.example.Vaccination.User;

/**
 * This class is an implementation of a User Interface based on the selection
 * in the console the user type is selected.You need to complete this class
 * based on the following tasks.
 * <p>
 * Tasks:
 * a.Override the methods of User Interface.
 * b.Adding common attributes:
 * 1. String name
 * 2. Integer age
 * 3. boolean isVaccinated
 * 4. TimeAndLocation(class), vaccine(interface), both are injected by the constructor method.
 * 5. The arguments of the constructor for all users should be like "public User(TimeAndLocation timeAndLocation, Vaccine vaccine)"
 * c.Build the logic for all the methods based on the description mentioned in the User Interface.
 **/
public class Father implements User {
    private String name;
    private int age;
    private boolean isVaccinated=false;

    public void setTimeAndLocation(TimeAndLocation timeAndLocation) {
        this.timeAndLocation = timeAndLocation;
    }

    TimeAndLocation timeAndLocation;

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    Vaccine vaccine;

   /* public Father(TimeAndLocation timeAndLocation, Vaccine vaccine) {
        this.timeAndLocation = timeAndLocation;
        this.vaccine = vaccine;
    }*/
    /*Making the use of setters*/


    @Override
    public Vaccine getVaccineDetails() {
        return vaccine;
    }

    @Override
    public void setUserDetails(String name, int age, TimeAndLocation timeAndLocation) {
        this.name = name;
        this.age = age;
        this.timeAndLocation = timeAndLocation;
        this.isVaccinated=true;
    }

    @Override
    public void setAppointment() {
        System.out.println("Hello " + this.name + " your appointment has been fixed for " + vaccine.getType() +
                " Vaccine on " + timeAndLocation.getDetails());
    }

    @Override
    public boolean IsVaccinated() {
        return isVaccinated;
    }
}
