/**
 * This class is generated to catch movie not found exception.
 */
package com.theatreportal.exception;

import lombok.Getter;

@Getter
public class MovieNotFoundException extends Exception {
    int errorCode;
    String message;
    public MovieNotFoundException(int errorCode, String message) {
        super(message);
        this.message=message;
        this.errorCode=errorCode;
    }
}
