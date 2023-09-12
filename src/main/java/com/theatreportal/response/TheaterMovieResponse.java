/**
 * This is reponse for TheaterMovieResponse
 */
package com.theatreportal.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class TheaterMovieResponse extends BaseResponse{
    String city;
    Set<MovieDetailResponse> movieDetails;
    Set<TheaterDetailResponse> theaterDetails;
}
