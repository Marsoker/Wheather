package org.marco.model;

public class Weather {
    
    private final String country;
    private final String city;
    private final double temperature;

    // Constructor
    public Weather(String city, double temperature, String country) {
        this.city = city;
        this.temperature = temperature;
        this.country = country;
    }

    protected String getCountry() {
        return country;
    }

    protected String getCity() {
        return city;
    }

    protected double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "Wheather{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
