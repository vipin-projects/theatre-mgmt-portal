/**
 * This entity class is for theaters
 */
package com.theatreportal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    String address;
    String coreArea;
    String city;
    String zipCode;

    @OneToMany(mappedBy = "theaterDetails", cascade = CascadeType.ALL)
    List<ScreenDetails> screens;
}
