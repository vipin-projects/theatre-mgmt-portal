package com.theatreportal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movie_details")
public class MovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer movieId;
    String title;
    @ElementCollection
    List<String> languages;
    @ElementCollection
    List<String> leadActors;
    @ElementCollection
    List<String> supportingActors;
    @ElementCollection
    List<String> producers;
    @ElementCollection
    List<String> directors;
    String rating;
    Date releaseDate;
}
