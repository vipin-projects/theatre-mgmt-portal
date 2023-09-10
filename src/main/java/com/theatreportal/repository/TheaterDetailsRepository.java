package com.theatreportal.repository;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.TheaterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterDetailsRepository extends JpaRepository<TheaterDetails, Long> {
}
