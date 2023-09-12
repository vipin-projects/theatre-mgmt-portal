/**
 * This is for ErrorResponse
 */
package com.theatreportal.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse extends BaseResponse{
    int code;
    String message;
}
