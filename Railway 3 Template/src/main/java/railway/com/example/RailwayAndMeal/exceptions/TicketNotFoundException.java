package railway.com.example.RailwayAndMeal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 1. Add proper annotation for this custom exception class
 2. It returns a response status of type NOT_FOUND.
 **/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException
{
    //complete the code body for this constructor

    public TicketNotFoundException(String message) {
        super(message);
    }
}

