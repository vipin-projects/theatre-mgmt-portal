package com.theatreportal.repository;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.ScreenDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenDetailsRepository extends JpaRepository<ScreenDetails, Long> {
    @Query("select sd from ScreenDetails sd where sd.theaterDetails.theaterId=:theaterId")
    List<ScreenDetails> findScreensRunningMoviesByTheater(@Param("theaterId") int theaterId);
}
