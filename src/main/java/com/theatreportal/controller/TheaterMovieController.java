package com.theatreportal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterMovieController {

    @GetMapping("/theater/{city}")
    public ResponseEntity theatersByCity(String city) {
        //List<String>
        return null;
    }
}
