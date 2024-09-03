package railway.com.example.RailwayAndMeal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 1. Add proper annotation for this custom exception class
 * 2. It returns a response status of type CONFLICT.
 **/
@ResponseStatus(HttpStatus.CONFLICT)
public class TicketAlreadyExistsException extends RuntimeException {

    public TicketAlreadyExistsException(String message) {
        super(message);
    }

    //complete the code body for this constructor

}
