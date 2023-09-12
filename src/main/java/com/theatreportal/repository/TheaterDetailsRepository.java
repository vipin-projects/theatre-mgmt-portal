package com.theatreportal.repository;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.TheaterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterDetailsRepository extends JpaRepository<TheaterDetails, Long> {

    @Query("select td from TheaterDetails td where city=:cityName")
    List<TheaterDetails> findAllTheatresByCity(@Param("cityName") String cityName);
}
