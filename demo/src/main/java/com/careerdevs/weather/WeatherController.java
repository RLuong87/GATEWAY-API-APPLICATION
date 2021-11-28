package com.careerdevs.weather;

import com.careerdevs.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @Autowired
    private Environment env;

    @GetMapping("/weathertest")
    public String weatherTest() {
        return "WEATHER TEST!";
    }

    @GetMapping("/forecast")
    public Weather weatherInfo(RestTemplate restTemplate) {

        String LOCATION = "Cranston";
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + env.getProperty("weather.key");

        return restTemplate.getForObject(URL, Weather.class);
    }
}
