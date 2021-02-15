package com.example.whereis.netflix;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/netflix")
public class NetflixController {

    @Autowired
    NetflixServices netflixServices;

    @RequestMapping("/country")
    public List<Netflix> getCountriesForMovie(@RequestParam String movie) {
        List<Netflix> result = new ArrayList<>();
        result.addAll(netflixServices.getCountriesForMovie(movie));
        return result;
    }
}
