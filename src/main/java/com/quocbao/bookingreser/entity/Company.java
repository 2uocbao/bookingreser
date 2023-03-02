package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "address")
	private String address;

	@Column(name = "status")
	private int status;

	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	//relationship
	
	@OneToMany(mappedBy = "company")
	private Set<Employee> employees;
	
	@OneToMany(mappedBy = "company")
	private Set<Service> services;
	
	@OneToMany(mappedBy = "company")
	private Set<Material> materials;
	
	@OneToMany(mappedBy = "company")
	private Set<Food> foods;
}
