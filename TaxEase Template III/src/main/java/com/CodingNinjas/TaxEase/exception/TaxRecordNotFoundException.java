package com.CodingNinjas.TaxEase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaxRecordNotFoundException extends RuntimeException {

    /*
        This is an exception class, which will be called when a tax record is not found by id.
        Complete this class by doing the following:

        a. Extend this class with RuntimeException class.
        b. Create a parameterized constructor with (String message) as the argument for
           returning custom message in an exception state.
     */
    public TaxRecordNotFoundException(String message) {
        super(message);
    }

}
