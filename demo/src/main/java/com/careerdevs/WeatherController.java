package com.careerdevs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    private final static String MY_WEATHER_API_KEY = "d76c20b9d4dba9f9925bc410ca269444";
    String LOCATION = "Cranston";

    @GetMapping("/weathertest")
    public String weatherTest() {
        return "WEATHER TEST!";
    }

    @GetMapping("/weather")
    public Weather weatherInfo(RestTemplate restTemplate) {
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + MY_WEATHER_API_KEY;

        return restTemplate.getForObject(URL, Weather.class);

//        return "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + MY_WEATHER_API_KEY;
    }
}
