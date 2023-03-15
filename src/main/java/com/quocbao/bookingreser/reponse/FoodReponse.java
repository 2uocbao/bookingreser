package com.quocbao.bookingreser.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.request.FoodRequest;

public class FoodReponse extends FoodRequest{

	@JsonProperty("id")
	private Long id;
}
