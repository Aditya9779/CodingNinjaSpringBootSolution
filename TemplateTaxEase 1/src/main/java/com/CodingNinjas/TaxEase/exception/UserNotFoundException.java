package com.CodingNinjas.TaxEase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 1. Extend the UserNotFoundException class with the appropriate class
// 2. It returns a NOT_FOUND HttpStatus
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    // Add the constructor with message field.
    public UserNotFoundException(String message) {
        super(message);
    }
}
