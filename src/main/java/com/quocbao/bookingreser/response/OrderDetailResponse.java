package com.quocbao.bookingreser.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.request.OrderDetailRequest;

import lombok.Setter;

@Setter
public class OrderDetailResponse extends OrderDetailRequest{

	@JsonProperty("order_detail_id")
	private Long orderDetailId;

	@JsonProperty("price")
	private float price;

	@JsonProperty("total_amount")
	private float totalAmout;

	public OrderDetailResponse(OrderDetail orderDetail) {
		this.orderDetailId = orderDetail.getId();
		this.quantity = orderDetail.getQuantity();
	}

	public List<OrderDetailResponse> orderDetailResponses(List<OrderDetail> orderDetails) {
		return orderDetails.stream().map(OrderDetailResponse::new).toList();
	}

	public OrderDetailResponse() {

	}
}
