package com.cn.cnpayment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Add annotation for returning BAD_REQUEST as the response status for this class.
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ElementAlreadyExistException extends RuntimeException{

    public ElementAlreadyExistException(String message) {
        super(message);
    }

    // Complete the method body for passing custom message.


}
