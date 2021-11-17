package com.careerdevs.apod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/apod")
public class APODController {

    @Autowired
    private Environment env;
//    private static final String MY_API_KEY = env.getProperty("api.key");

    @GetMapping("/apodtest")
    public String apodTest() {
        return "APOD TESTING!";
    }

    @GetMapping("/")
    public String rootRoute() {
        return "Welcome Home!";
    }

    @GetMapping("/nasa")
    public APOD apodInfo(RestTemplate restTemplate) {

        String URL = "https://api.nasa.gov/planetary/apod?api_key=" + env.getProperty("api.key");

        return restTemplate.getForObject(URL, APOD.class);
    }

    @PostMapping("/apod")
    public String postApod() {
        return "POST APOD";
    }
}
