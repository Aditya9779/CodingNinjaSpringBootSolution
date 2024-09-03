package org.assisment.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadException extends RuntimeException{
    public BadException(String message) {
        super(message);
    }
}
