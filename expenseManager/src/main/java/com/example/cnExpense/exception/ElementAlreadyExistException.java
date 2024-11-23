package com.example.cnExpense.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ElementAlreadyExistException extends RuntimeException{

    public ElementAlreadyExistException(String message)
    {
        super(message);
        System.out.println(message);
    }
}
