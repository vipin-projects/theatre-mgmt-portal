package com.theatreportal.repository;

import com.theatreportal.entities.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetails, Long> {
}
