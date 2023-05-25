package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.OrderDetail;

import lombok.Setter;

@Setter
public class OrderDetailResponse {

	@JsonProperty("foodId")
	public Long foodId;

	@JsonProperty("quantity")
	public float quantity;

	public OrderDetailResponse(OrderDetail orderDetail) {
		this.foodId = orderDetail.getFood().getId();
		this.quantity = orderDetail.getQuantity();
	}
	
	public List<OrderDetailResponse> orderDetailResponses(List<OrderDetail> orderDetails){
		return orderDetails.stream().map(OrderDetailResponse::new).toList();
	}

	public OrderDetailResponse() {

	}
}
