package com.quocbao.bookingreser.request;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ReservationRequest {
	
	@JsonProperty("employeeId")
	public Long employeeId;
	
	@JsonProperty("userId")
	public Long userId;
	
	@JsonProperty("serviceId")
	public Long serviceId;
	
	@JsonProperty("checkindate")
	public Timestamp checkinDate;

	@JsonProperty("note")
	public String note;

	@JsonProperty("deposit")
	public float deposit;
}
