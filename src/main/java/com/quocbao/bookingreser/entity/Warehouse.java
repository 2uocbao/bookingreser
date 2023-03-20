package com.quocbao.bookingreser.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "table")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Warehouse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "material_id", referencedColumnName = "id")
	private Material material;
	
	@OneToOne
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;
	
	@OneToMany(mappedBy = "warehouse")
	private Set<WarehouseDetail> warehouseDetails;
}
