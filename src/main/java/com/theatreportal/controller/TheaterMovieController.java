package com.theatreportal.controller;

import com.theatreportal.service.TheatreMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TheaterMovieController {
    @Autowired
    TheatreMovieService theatreMovieService;
    @GetMapping("/theater/{city}")
    public ResponseEntity theatersByCity(String city, Date date) {
        theatreMovieService.runningMovies(city, date);
        return null;
    }
}
