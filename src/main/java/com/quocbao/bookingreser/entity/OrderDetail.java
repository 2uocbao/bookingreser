package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicUpdate;

import com.quocbao.bookingreser.request.OrderDetailRequest;
import com.quocbao.bookingreser.util.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "order_detail")
@DynamicUpdate
@NoArgsConstructor
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "status")
	private String status;

	// relationship

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "food_id", referencedColumnName = "id")
	private Food food;

	public OrderDetail(Long idOrder, OrderDetailRequest orderDetailRequest) {
		Food food = new Food();
		Order order = new Order();
		food.setId(orderDetailRequest.getFoodId());
		order.setId(idOrder);
		this.order = order;
		this.food = food;
		this.quantity = orderDetailRequest.getQuantity();
		this.status = Status.PROCESSING.toString();
	}

	public void setOrderDetail(OrderDetailRequest orderDetailRequest) {
		this.quantity = orderDetailRequest.getQuantity();
	}
}
