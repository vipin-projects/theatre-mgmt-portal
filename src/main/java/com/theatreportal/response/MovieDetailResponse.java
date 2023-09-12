package com.theatreportal.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieDetailResponse {
    int movieId;
    String title;
}
