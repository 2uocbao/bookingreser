package com.quocbao.bookingreser.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorDetail> bookingreserException(BookingreserException bookingreserException,
			RuntimeException ex) {
		ErrorDetail errorDetail = new ErrorDetail(bookingreserException.getHttpStatus(), LocalDateTime.now(),
				ex.getMessage());
		return new ResponseEntity<>(errorDetail, bookingreserException.getHttpStatus());
	}

	@ExceptionHandler
	public ResponseEntity<Object> globleExcpetionHandler(RuntimeException ex) {
		ErrorDetail errorDetail = new ErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(),
				ex.getMessage());
		return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
