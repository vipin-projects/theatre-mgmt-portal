package com.theatreportal.repository;

import com.theatreportal.entities.MovieDetails;
import com.theatreportal.entities.TheaterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetails, Long> {
    @Query("select md from MovieDetails md where title=:titleStr")
    MovieDetails findMovieByTitle(@Param("titleStr") String titleStr);
}
