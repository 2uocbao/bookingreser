package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "food_detail")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class FoodDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "quantity")
	private float quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_id", referencedColumnName = "id")
	private Food food;
	
	@OneToOne
	@JoinColumn(name = "material_id", referencedColumnName = "id")
	private Material material;
}
