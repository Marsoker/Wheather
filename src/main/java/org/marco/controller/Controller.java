package org.marco.controller;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import org.marco.model.WeatherManager;
import org.marco.view.WeatherView;

import com.google.gson.Gson;

public class Controller {
    // This class will act as a bridge between the model and the view
    private final WeatherManager weatherManager;
    private final WeatherView weatherView;

    // constructor
    public Controller(WeatherManager weatherManager, WeatherView weatherView) {
        this.weatherManager = weatherManager;
        this.weatherView = weatherView;
        catchWeather();    
    }

    public void updateView() {
        StringBuilder weatherInfo = new StringBuilder();
        for (var weather : weatherManager.getWeatherList()) {
            weatherInfo.append(weather.toString()).append("\n");
        }
        weatherView.showWeather(weatherInfo.toString());
    }


    // This method can be used to fetch weather data from an external API
    private void catchWeather() {
        
        // 1. Create an HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // 2. Create an HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create("https://api.openweathermap.org/data/2.5/weather?q=Rome&appid=24d20df71defa2674c3e641582bc1cab&units=metric"))
                .GET() // GET request
                .build();

        // 3. Send the request asynchronously and handle the response
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            String json = response.body();

            Gson gson = new Gson();

            Map<String, Object> weathers = gson.fromJson(json, java.util.Map.class);

            String city = (String) weathers.get("name");
            Map<String, Object> main = (Map<String, Object>) weathers.get("main");
            double temp = ((Number) main.get("temp")).doubleValue();
            Map<String, Object> sys = (Map<String, Object>) weathers.get("sys");
            String country = (String) sys.get("country");
            
            System.out.println("City: " + city);

            weatherManager.addWeather(city, temp, country);

            
        } catch (java.io.IOException | InterruptedException e) {
            System.err.println("Error fetching weather data: " + e.getMessage());
        }

        
       
        
    }
    
}   