package com.quocbao.bookingreser.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorDetail {

	private Integer status;

	private LocalDateTime localDateTime;

	private String message;

}
