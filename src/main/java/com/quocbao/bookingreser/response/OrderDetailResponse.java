package com.quocbao.bookingreser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.request.OrderDetailRequest;

import lombok.Setter;

@Setter
public class OrderDetailResponse extends OrderDetailRequest {

	@JsonProperty("id")
	private Long id;

	public OrderDetailResponse(OrderDetail orderDetail) {
		this.id = orderDetail.getId();
		this.foodId = orderDetail.getFood().getId();
		this.quantity = orderDetail.getQuantity();
	}
}
