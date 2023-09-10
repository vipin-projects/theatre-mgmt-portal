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
    @OneToMany()
    @JoinColumn(name = "seatId")
    List<SeatDetails> seats;
    String firstShow;
    String lastShow;
    int noOfShows;
    int movieId;
}
