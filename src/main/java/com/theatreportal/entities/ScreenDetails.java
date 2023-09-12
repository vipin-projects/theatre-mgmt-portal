/**
 * This entity class is for screens.
 */
package com.theatreportal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "screen_details")
public class ScreenDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int screenId;
    String screenName;
    String showTimings;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movieId")
    MovieDetails movieDetails;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theaterId")
    TheaterDetails theaterDetails;
    @OneToMany(mappedBy = "screenDetails", cascade = CascadeType.ALL)
    List<SeatDetails> seatDetails;

}
