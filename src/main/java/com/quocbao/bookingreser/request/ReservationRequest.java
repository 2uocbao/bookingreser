package com.quocbao.bookingreser.request;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ReservationRequest {

	@JsonProperty("employeeId")
	protected Long employeeId;

	@JsonProperty("userId")
	protected Long userId;

	@JsonProperty("serviceId")
	protected Long serviceId;

	@JsonProperty("checkindate")
	protected Timestamp checkinDate;

	@JsonProperty("note")
	protected String note;

	@JsonProperty("deposit")
	protected float deposit;
}
