/**
 * This is TheaterMovie controller class.
 */
package com.theatreportal.controller;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.ScreenDetails;
import com.theatreportal.entities.TheaterDetails;
import com.theatreportal.exception.MovieNotFoundException;
import com.theatreportal.response.*;
import com.theatreportal.service.TheatreMovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TheaterMovieController {
    /**
     * TBD
     */
    @Autowired
    TheatreMovieService theatreMovieService;
    /*@GetMapping("/theater/{city}")
    public ResponseEntity theatersByCity(String city) {
        theatreMovieService.listTheatersRunningMovies(city, null);
        return null;
    }*/

    /**
     * This method will fetch the list of theaters running the movies in a given city.
     * @param city
     * @param movie
     * @return
     */
    @GetMapping("/city/{city}/movie/{movie}")
    public ResponseEntity<BaseResponse> moviesByCity(@PathVariable String city, @PathVariable String movie) {
        log.debug("In method moviesByCity with parameter- city: {}, movie: {}",city, movie);
        Set<ScreenDetails> screenDetails = null;
        try {
            screenDetails = theatreMovieService.listMoviesRunByTheaters(city, movie,null);
            Set<TheaterDetails> theaterDetails = screenDetails.parallelStream()
                    .map(screenDetails1 -> screenDetails1.getTheaterDetails())
                    .collect(Collectors.toSet());
            log.info("Fetching theater from response: {}", theaterDetails == null ? 0: theaterDetails.size());
            Set<MovieDetails> movieDetails = screenDetails.stream().findFirst().map(screenDetails1 -> screenDetails1.getMovieDetails())
                    .stream().collect(Collectors.toSet());
            log.info("Fetching movie from response: {}", movieDetails == null ? 0: movieDetails.size());
            Set<MovieDetailResponse> movieDetailResponses = new HashSet<>();
            Set<TheaterDetailResponse> theaterDetailResponses = new HashSet<>();
            log.info("Generating the response");
            theaterDetails.forEach( theater -> {
                TheaterDetailResponse theaterDetailResponse = new TheaterDetailResponse(theater.getTheaterId(), theater.getTheaterName());
                theaterDetailResponses.add(theaterDetailResponse);
            });

            movieDetails.forEach( movieDetail -> {
                MovieDetailResponse movieDetailResponse = new MovieDetailResponse(movieDetail.getMovieId(), movieDetail.getTitle());
                movieDetailResponses.add(movieDetailResponse);
            });
            log.info("Exit method moviesByCity with success");
            TheaterMovieResponse theaterMovieResponse = new TheaterMovieResponse(city, movieDetailResponses, theaterDetailResponses);
            return new ResponseEntity(theaterMovieResponse, HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            log.info("Exit method moviesByCity with error: {}", e.getMessage(), e.getStackTrace());
            ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode(), e.getMessage());
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }

    }
}
