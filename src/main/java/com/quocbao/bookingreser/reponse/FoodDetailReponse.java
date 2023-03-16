package com.quocbao.bookingreser.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.request.FoodDetailRequest;

public class FoodDetailReponse extends FoodDetailRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("food_id")
	private Long foodId;
}
