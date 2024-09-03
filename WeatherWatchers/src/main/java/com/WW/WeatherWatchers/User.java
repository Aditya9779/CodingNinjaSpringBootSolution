package com.WW.WeatherWatchers;

public interface User {
    public void setLocationDetails(String city,String state,String country);
    public void setUserDetails(String name,int age);


    public String getWeatherForecastForLocation();
}
