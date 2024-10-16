package com.CN.Gym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GymNotFoundException extends RuntimeException {

    public GymNotFoundException(String message) {
        super(message);
    }
}
