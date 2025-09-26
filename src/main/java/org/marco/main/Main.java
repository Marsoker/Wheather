package org.marco.main;

import org.marco.controller.Controller;
import org.marco.model.WeatherManager;
import org.marco.view.WeatherView;

public class Main {
    public static void main(String[] args) {
        // Application entry point

        WeatherManager weatherManager = new WeatherManager();
        WeatherView weatherView = new WeatherView();
        Controller controller = new Controller(weatherManager, weatherView);
        controller.updateView();
    }
}