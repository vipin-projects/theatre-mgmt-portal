/**
 * This entity class is for seats
 */
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int seatId;
    int rowId;
    int seatNo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="screenId")
    ScreenDetails screenDetails;
}
