/**
 * This is implementation for TheaterMovieServie contract.
 */
package com.theatreportal.service.impl;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.ScreenDetails;
import com.theatreportal.entities.TheaterDetails;
import com.theatreportal.exception.MovieNotFoundException;
import com.theatreportal.repository.MovieDetailsRepository;
import com.theatreportal.repository.ScreenDetailsRepository;
import com.theatreportal.repository.TheaterDetailsRepository;
import com.theatreportal.service.TheatreMovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TheaterMovieServiceImpl implements TheatreMovieService {
    @Autowired
    MovieDetailsRepository movieDetailsRepository;
    @Autowired
    TheaterDetailsRepository theaterDetailsRepository;
    @Autowired
    ScreenDetailsRepository screenDetailsRepository;

    /**
     * TBD
     * @param movieDetails
     * @param theaterDetails
     * @param startDate
     * @param endDate
     */
    @Override
    public void releaseMovie(MovieDetails movieDetails, TheaterDetails theaterDetails, Date startDate, Date endDate) {

    }

    /**
     * This will fetch movies and theaters.
     * @param city
     * @param movieName
     * @param date
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public Set<ScreenDetails> listMoviesRunByTheaters(String city, String movieName, Date date) throws MovieNotFoundException {
        log.debug("In method listMoviesRunByTheaters with parameter- city: {}, movieName: {}",city, movieName);
        List<TheaterDetails> theaterDetails = theaterDetailsRepository.findAllTheatresByCity(city);
        log.info("No of theaters running movie: {}", theaterDetails == null ? 0: theaterDetails.size());
        MovieDetails movieDetails = movieDetailsRepository.findMovieByTitle(movieName);
        log.info("Fetching movie details: {}", movieDetails == null ? "Movie Found": "Movie Not Found");
        if(movieDetails == null)
            throw new MovieNotFoundException(100, "Movie not found");
        List<ScreenDetails> screenDetails = theaterDetails.parallelStream()
                .map(theaterDetail -> screenDetailsRepository.findScreensRunningMoviesByTheater(theaterDetail.getTheaterId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        log.info("Fetching movie running on screens: {}", screenDetails == null ? 0: screenDetails.size());
        Set<ScreenDetails> filteredScreenList = screenDetails.parallelStream()
                .filter(screenDetails1 -> screenDetails1.getMovieDetails().getMovieId()==movieDetails.getMovieId())
                .collect(Collectors.toSet());
        log.info("Fetching movie running on screens, post deleting duplicates: {}", filteredScreenList == null ? 0: filteredScreenList.size());
        return filteredScreenList;
    }

}
