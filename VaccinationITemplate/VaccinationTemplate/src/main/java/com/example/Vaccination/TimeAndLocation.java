package com.example.Vaccination;

/**
  TimeAndLocation class is a class which a user can use to set its appointment details
  from the console.This class should be injected as a dependency into the selected user.
  To complete this class you need perform the following tasks:
   
        Tasks:
 1.Add common attributes as mentioned below:
  a. String timeSlot
  b. String location
  c. String date
 2. Implement below function based on the given description:
    a. setDetails(String timeSlot, String location, String date): This method takes timeSlot, location, and date as input parameters.
    b. getDetails(): This method returns a string containing the timeslot, location, and date for example: "12:00 AM at New Delhi on 2023-05-22". 

**/ 
public class TimeAndLocation {
    private String timeSlot;
    private String location;
    private String date;

    public void setDetails(String timeSlot, String location, String date) {
        this.timeSlot = timeSlot;
        this.location = location;
        this.date = date;
    }
    public String getDetails() {
        return timeSlot + " at " + location + " on " + date;
    }

}
