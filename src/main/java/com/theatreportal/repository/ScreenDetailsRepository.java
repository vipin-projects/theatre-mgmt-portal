package com.theatreportal.repository;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.ScreenDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenDetailsRepository extends JpaRepository<ScreenDetails, Long> {
}
