package com.quocbao.bookingreser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -679779841024534819L;

	public AlreadyExistException(String message) {
		super(message);
	}
}
