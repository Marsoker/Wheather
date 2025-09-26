package org.marco.controller;

import org.marco.model.WeatherManager;
import org.marco.view.WeatherView;

public class Controller {
    // This class will act as a bridge between the model and the view
    private final WeatherManager weatherManager;
    private final WeatherView weatherView;

    // constructor
    public Controller(WeatherManager weatherManager, WeatherView weatherView) {
        this.weatherManager = weatherManager;
        this.weatherView = weatherView;

        weatherManager.addWeather("New York", 22.5, "USA");
        weatherManager.addWeather("London", 18.3, "UK");
        weatherManager.addWeather("Tokyo", 25.0, "Japan");
        weatherManager.addWeather("Sydney", 15.4, "Australia");
        weatherManager.addWeather("Cairo", 30.2, "Egypt");
    }

    public void updateView() {
        StringBuilder weatherInfo = new StringBuilder();
        for (var weather : weatherManager.getWeatherList()) {
            weatherInfo.append(weather.toString()).append("\n");
        }
        weatherView.showWeather(weatherInfo.toString());
    }
    
}   