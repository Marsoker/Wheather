package org.marco.model;
import java.util.ArrayList;

public class WeatherManager {
    // This class will manage weather data

    private final ArrayList<Weather> weatherList = new ArrayList<>();

    // Method to add a new Wheather object to the list
    private void addWeatherInList(Weather weather) {
        weatherList.add(weather);
    }

    // Method to create and add a new Wheather object
    public void addWeather(String city, double temperature, String country) {
        Weather weather = new Weather(city, temperature, country);
        addWeatherInList(weather);
    }

    public ArrayList<Weather> getWeatherList() {
        return weatherList;
    }
}