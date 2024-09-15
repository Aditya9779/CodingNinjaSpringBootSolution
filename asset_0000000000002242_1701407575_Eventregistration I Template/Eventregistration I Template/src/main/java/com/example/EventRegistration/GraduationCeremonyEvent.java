package com.example.EventRegistration;


import java.util.ArrayList;
import java.util.List;

public class GraduationCeremonyEvent implements CollegeEvent {

    /*
    1. Create the following attributes:
        a. name (initialize it as "Graduation Ceremony".
        b. address (String)
        c. time (String)
        d. date (String)
        e. count (int) (initially 0)
        f. eventAttendees (List of Attendee)
        NOTE: Initialize the address, time and date attributes with some values.
    2. Inject Attendee with attribute name "attendee" with setter injection.
    3. Make this class an implementation of CollegeEvent interface and override the interface methods.
    */

    private String name = "Graduation Ceremony";
    private String address;
    private String time;
    private String date;
    private int count = 0;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    Attendee attendee;

    List<Attendee> eventAttendees;

    public GraduationCeremonyEvent() {
        this.eventAttendees = new ArrayList<Attendee>();
    }


    @Override
    public void registerStudent(Attendee user) {
        count++;
        this.eventAttendees.add(user);
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return this.eventAttendees;
    }

    @Override
    public void printEventDetails() {
        System.out.println("The Graduation Ceremony details are as follows: " +
                "\nVenue: Auditorium \nTime: 10AM\nDate: 12 NOV 2023");
    }

    @Override
    public int getAttendeeCount() {
        return this.count;
    }

    @Override
    public void setAttendee(Attendee attendee) {
        eventAttendees.add(attendee);
    }
}
