package com.quocbao.bookingreser.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetail {

	private HttpStatus status;

	private LocalDateTime localDateTime;

	private String message;
}
