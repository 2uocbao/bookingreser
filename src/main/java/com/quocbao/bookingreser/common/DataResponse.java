package com.quocbao.bookingreser.common;

import org.springframework.http.HttpStatus;

public class DataResponse {

	private HttpStatus status;
	private Object data;
	
	public DataResponse(HttpStatus status) {
		this.status = status;
	}

	public DataResponse(HttpStatus status, Object data) {
		this.status = status;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
