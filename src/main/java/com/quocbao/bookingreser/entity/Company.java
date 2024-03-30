package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.quocbao.bookingreser.request.CompanyRequest;
import com.quocbao.bookingreser.util.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "company")
@DynamicUpdate
@NoArgsConstructor
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "image")
	private String image;

	@Column(name = "infor")
	private String infor;

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

	// relationship
	@OneToMany(mappedBy = "company")
	private Set<Employee> employees;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	@OneToMany(mappedBy = "company")
	private Set<Services> services;

	@OneToMany(mappedBy = "company")
	private Set<Material> materials;

	@OneToMany(mappedBy = "company")
	private Set<Food> foods;

	public Company(CompanyRequest companyRequest) {
		this.name = companyRequest.getName();
		this.address = new Address(companyRequest.getAddressRequest());
		this.email = companyRequest.getEmail();
		this.phone = companyRequest.getPhone();
		this.image = companyRequest.getImage();
		this.infor = companyRequest.getInfor();
		this.status = Status.OFF.toString();
	}

	public void company(CompanyRequest companyRequest) {
		this.name = companyRequest.getName();
		this.email = companyRequest.getEmail();
		this.phone = companyRequest.getPhone();
		this.image = companyRequest.getImage();
		this.infor = companyRequest.getInfor();
	}
}
