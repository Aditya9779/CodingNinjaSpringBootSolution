package com.cn.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpRatingServiceNotFound extends HttpClientErrorException{

	private static final long serialVersionUID = 1L;

	public HttpRatingServiceNotFound(HttpStatus status) {
		super(status);
		
	}

}
