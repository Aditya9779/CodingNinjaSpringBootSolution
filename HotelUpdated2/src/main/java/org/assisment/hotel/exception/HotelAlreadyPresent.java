package org.assisment.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class HotelAlreadyPresent extends RuntimeException{
    public HotelAlreadyPresent(String message) {
        super(message);
    }
}
