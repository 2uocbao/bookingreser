package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.OrderRequest;
import com.quocbao.bookingreser.util.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "orders")
@DynamicUpdate
@NoArgsConstructor
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "total_amount")
	private float totalAmount;

	@Column(name = "status")
	private String status;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Timestamp createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	private List<OrderDetail> orderDetails;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id", referencedColumnName = "id")
	private Services service;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;

	public Order(OrderRequest orderRequest) {
		Services service = new Services();
		Employee employee = new Employee();
		employee.setId(orderRequest.getEmployeeId());
		service.setId(orderRequest.getServiceId());
		this.service = service; 
		this.employee = employee;
		this.status = Status.UNCONFIRMED.toString();
	}

	public void setOrder(OrderRequest orderRequest, Services service, Employee employee) {
		this.employee = employee;
		this.service = service;
	}
}
