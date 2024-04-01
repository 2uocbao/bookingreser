package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import org.hibernate.annotations.DynamicUpdate;

import com.quocbao.bookingreser.request.ServiceRequest;
import com.quocbao.bookingreser.util.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "services")
@DynamicUpdate
@NoArgsConstructor
public class Services implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "status")
	private String status;

	// relationship

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	public Services(ServiceRequest serviceRequest, Company company) {
		this.name = serviceRequest.getName();
		this.company = company;
		this.status = Status.EMPTY.toString();
	}

}
