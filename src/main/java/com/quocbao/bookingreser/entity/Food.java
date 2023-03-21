package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.util.Set;

import com.quocbao.bookingreser.request.FoodRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "food")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Food implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "status")
	private int status;
	
	// relationship
	
	@ManyToOne
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;
	
	@OneToMany(mappedBy = "food")
	private Set<FoodDetail> foodDetails;
	
	public Food(FoodRequest foodRequest, Company company) {
		this.company = company;
		this.name = foodRequest.getName();
		this.price = foodRequest.getPrice();
		this.image = foodRequest.getImage();
	}
}
