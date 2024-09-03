package org.cn.cnkart.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class WrongDetailException extends RuntimeException {

    public WrongDetailException(String message) {
        super(message);
    }
}
