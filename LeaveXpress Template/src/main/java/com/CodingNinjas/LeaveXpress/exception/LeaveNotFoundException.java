package com.CodingNinjas.LeaveXpress.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LeaveNotFoundException extends RuntimeException{
    public LeaveNotFoundException(String message) {
        super(message);
    }
}
