package com.careerdevs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class APODController  {

    private static final String MY_API_KEY = "x6FD1kY09E9RFXrvNX6yBE72YC34rpaD7GzBxhMq";

    @GetMapping("/apodtest")
    public String apodTest() {
        return "APOD TESTING!";
    }

    @GetMapping("/")
    public String rootRoute() {
        return "Welcome Home!";
    }

    @GetMapping("/apod")
    public APOD apodInfo(RestTemplate restTemplate) {
        String URL = "https://api.nasa.gov/planetary/apod?api_key=" + MY_API_KEY;

        return restTemplate.getForObject(URL, APOD.class);
    }

    @PostMapping("/apod")
    public String postApod() {
        return "POST APOD";
    }
}
