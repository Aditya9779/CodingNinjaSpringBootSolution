package com.WW.WeatherWatchers;

import java.util.Random;

public class myForecast implements WeatherForecast {
    private static final String[] WEATHER_CONDITIONS = {"sunny", "cloudy", "windy", "snowy", "rainy"};

    @Override
    public String getWeather() {
        return getRandomWeather();
    }

    private static String getRandomWeather() {
        Random random = new Random();
        int index = random.nextInt(WEATHER_CONDITIONS.length);
        return WEATHER_CONDITIONS[index];
    }
}
