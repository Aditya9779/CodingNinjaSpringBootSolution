package com.WW.WeatherWatchers;

public class myUser implements User {
    private String name;
    private int age;
    Location location;

    public void setLocation(Location location) {
        this.location = location;
    }

    public void destroy() {
        System.out.println("The user bean has been destroy() method");
    }

    public void init() {
        System.out.println("The user bean has been Instantiated I am init() method");
    }


    public void setWeatherForecast(WeatherForecast weatherForecast) {
        this.weatherForecast = weatherForecast;
    }

    WeatherForecast weatherForecast;


    @Override
    public void setUserDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void setLocationDetails(String city, String state, String country) {
        this.location.setLocation(city, state, country);
    }

    @Override
    public String getWeatherForecastForLocation() {
        return "Hi " + this.name + " weather in your city " + location.getLocation() + " is " + weatherForecast.getWeather();
    }
}
