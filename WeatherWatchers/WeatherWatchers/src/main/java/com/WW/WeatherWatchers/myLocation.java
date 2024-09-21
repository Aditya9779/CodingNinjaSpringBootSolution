package com.WW.WeatherWatchers;

public class myLocation implements Location {
    private String city;
    private String state;
    private String country;
    public void init(){
        System.out.println("The location bean has been Instantiated I am init() method");
    }

    @Override
    public String getLocation() {
        return this.city + "," + this.state + "," + this.country;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLocation(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }


}
