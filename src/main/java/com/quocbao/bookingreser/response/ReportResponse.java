package com.quocbao.bookingreser.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReportResponse {

	@JsonProperty("turnover")
	private float turnover;
	
	@JsonProperty("cost")
	private float cost;
	
	@JsonProperty("profit")
	private float profit;
}
