package com.theatreportal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "theater_details")
public class TheaterDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int theaterId;
    String theaterName;
    String city;
    int noOfScreens;
    Time firstShow;
    Time lastShow;

    @OneToMany
    @JoinColumn(name="screenId")
    List<ScreenDetails> screens;
}
