package com.CN.CarQuest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpReviewServiceNotFound extends HttpClientErrorException{

	private static final long serialVersionUID = 1L;

	public HttpReviewServiceNotFound(HttpStatus status) {
		super(status);
		
	}

}
