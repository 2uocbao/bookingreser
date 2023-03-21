package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import com.quocbao.bookingreser.request.ServiceRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "service")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	// relationship

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	public Service(ServiceRequest serviceRequest, Company company) {
		this.name = serviceRequest.getName();
		this.company = company;
	}

}
