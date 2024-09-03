package com.example.Vaccination;

public class Self implements User {
    private String name;
    private int age;
    private boolean isVaccinated = false;
    TimeAndLocation timeAndLocation;
    Vaccine vaccine;

  /*  public Self(TimeAndLocation timeAndLocation, Vaccine vaccine) {
        this.timeAndLocation = timeAndLocation;
        this.vaccine = vaccine;
    }*/
  public void setTimeAndLocation(TimeAndLocation timeAndLocation) {
      this.timeAndLocation = timeAndLocation;
  }


    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    @Override
    public Vaccine getVaccineDetails() {
        return vaccine;
    }

    @Override
    public void setUserDetails(String name, int age, TimeAndLocation timeAndLocation) {
        this.name = name;
        this.age = age;
        this.timeAndLocation = timeAndLocation;
        this.isVaccinated = true;
    }

    @Override
    public void setAppointment() {
        System.out.println("Hello " + this.name + ", your appointment has been fixed for " + vaccine.getType() +
                " Vaccine on " + timeAndLocation.getDetails());
    }

    @Override
    public boolean IsVaccinated() {
        return isVaccinated;
    }
}
