package com.quocbao.bookingreser.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ApiResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("success")
	private Boolean success;
	
	@JsonProperty("message")
	private String message;
	
	@JsonIgnore
	private HttpStatus status;
	
	public ApiResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}

}
