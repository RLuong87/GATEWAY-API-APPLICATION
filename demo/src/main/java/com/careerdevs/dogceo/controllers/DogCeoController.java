package com.careerdevs.dogceo.controllers;

import com.careerdevs.dogceo.models.DogCeoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/dogceo")
public class DogCeoController {

    @Autowired
    private Environment env;

    @GetMapping("/env")
    public String envTest() {
        return env.getProperty("test.name");
    }

    @GetMapping("/test")
    public String testRoute() {
        return "Dog Test";
    }

    @GetMapping("/random")
    public DogCeoModel randomImage(RestTemplate restTemplate) {

        return restTemplate.getForObject("https://dog.ceo/api/breeds/image/random", DogCeoModel.class);
    }
}
