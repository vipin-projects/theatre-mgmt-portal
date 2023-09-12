package com.theatreportal.service;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.ScreenDetails;
import com.theatreportal.entities.TheaterDetails;
import com.theatreportal.exception.MovieNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * This is contract.
 */
public interface TheatreMovieService {
    void releaseMovie(MovieDetails movieDetails, TheaterDetails theaterDetails, Date startDate, Date endDate);
    Set<ScreenDetails> listMoviesRunByTheaters(String city, String movieName, Date date) throws MovieNotFoundException;

}
