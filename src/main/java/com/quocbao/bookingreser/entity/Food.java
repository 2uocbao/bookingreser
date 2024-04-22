package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.quocbao.bookingreser.request.FoodRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "food")
@DynamicUpdate
@NoArgsConstructor
public class Food implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private float price;

	@Column(name = "image")
	private String image;

	@Column(name = "status")
	private String status;

	// relationship

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToMany(mappedBy = "food", cascade = CascadeType.PERSIST)
	private List<FoodDetail> foodDetails;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "food_types", joinColumns = @JoinColumn(name = "food_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
	private Set<Types> types = new HashSet<>();

	public Food(FoodRequest foodRequest) {
		this.name = foodRequest.getName();
		this.price = foodRequest.getPrice();
		this.image = foodRequest.getImage();
		this.status = foodRequest.getStatus();
	}
	
}
