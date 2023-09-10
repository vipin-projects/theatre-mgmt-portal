package com.theatreportal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "seat_details")
public class SeatDetails {
    @Id
    String seatId;
    int row;
    @ManyToOne()
    @JoinColumn(name="screenId")
    ScreenDetails screenDetails;
    int seatNo;
}
