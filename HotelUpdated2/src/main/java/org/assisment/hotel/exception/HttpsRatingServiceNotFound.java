package org.assisment.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpsRatingServiceNotFound extends HttpClientErrorException {

    public HttpsRatingServiceNotFound(HttpStatusCode statusCode) {
        super(statusCode);
    }
}
