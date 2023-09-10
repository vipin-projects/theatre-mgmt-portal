package com.theatreportal.service.impl;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.TheaterDetails;
import com.theatreportal.repository.MovieDetailsRepository;
import com.theatreportal.service.TheatreMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TheaterMovieServiceImpl implements TheatreMovieService {
    @Autowired
    MovieDetailsRepository movieDetailsRepository;
    @Override
    public void releaesMovie(MovieDetails movieDetails, TheaterDetails theaterDetails, Date startDate, Date endDate) {

    }

    @Override
    public List<MovieDetails> runningMovies(String city, String theaterName, Date date) {
        return null;
    }

    @Override
    public List<MovieDetails> runningMovies(String city, Date date) {
        return null;
    }
}
