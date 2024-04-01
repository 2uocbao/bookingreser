package com.quocbao.bookingreser.request;

import java.sql.Time;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ReservationRequest {

	@JsonProperty("userId")
	protected Long userId;

	@JsonProperty("serviceId")
	protected Long serviceId;

	@JsonProperty("checkindate")
	protected Timestamp checkinDate;
	
	@JsonProperty("checkintime")
	protected Time checkinTime;

	@JsonProperty("note")
	protected String note;
}
