package com.careerdevs.weather.controllers;

import com.careerdevs.weather.models.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private Environment env;

    @GetMapping("/weathertest")
    public String weatherTest() {
        return "WEATHER TEST!";
    }

    @GetMapping("/forecast") // Works but weather key and value not present
    public Object weatherInfo(RestTemplate restTemplate) {

        String LOCATION = "Cranston";
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + env.getProperty("weather.key");

        return restTemplate.getForObject(URL, WeatherModel.class);
    }


    @GetMapping("/forecastv2") // WORKS!!
    public Object weatherInfo2(RestTemplate restTemplate) {

        String LOCATION = "Cranston";
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + env.getProperty("weather.key");

        return restTemplate.getForObject(URL, WeatherModel.class).getWeather();
    }


}
