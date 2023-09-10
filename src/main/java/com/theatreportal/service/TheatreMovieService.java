package com.theatreportal.service;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.TheaterDetails;

import java.util.Date;
import java.util.List;

public interface TheatreMovieService {
    void releaesMovie(MovieDetails movieDetails, TheaterDetails theaterDetails, Date startDate, Date endDate);
    List<MovieDetails> runningMovies(String city, String theaterName, Date date);
    List<MovieDetails> runningMovies(String city, Date date);
}
