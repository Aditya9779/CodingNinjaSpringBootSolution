package com.CN.FitFusion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DietNotFoundException extends RuntimeException {
    public DietNotFoundException(String message) {
        super(message);
    }
}
