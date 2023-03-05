package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationRequest {
	@JsonProperty("checkindate")
	private String checkinDate;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("deposit")
	private float deposit;
}
