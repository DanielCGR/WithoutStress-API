package com.withoutstress.ws_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadResourceRequestException extends RuntimeException{
	public BadResourceRequestException(String message){
		super(message);
	}
}
