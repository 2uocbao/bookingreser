package com.quocbao.bookingreser.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicUpdate;

import com.quocbao.bookingreser.request.FoodDetailRequest;

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
@Table(name = "food_detail")
@DynamicUpdate
@NoArgsConstructor
public class FoodDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity")
	private float quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "food_id", nullable = false)
	private Food food;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "material_id", referencedColumnName = "id")
	private Material material;

	public FoodDetail(Long idFood, FoodDetailRequest foodDetailRequest) {
		Material material = new Material();
		Food food = new Food();
		food.setId(idFood);
		material.setId(foodDetailRequest.getMaterialId());
		this.food = food;
		this.material = material;
		this.quantity = foodDetailRequest.getQuantity();
	}
}
