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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "table")
@AllArgsConstructor
@NoArgsConstructor
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
