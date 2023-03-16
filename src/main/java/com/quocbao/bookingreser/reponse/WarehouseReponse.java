package com.quocbao.bookingreser.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WarehouseReponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("material_id")
	private Long materialId;
	
	@JsonProperty("company_id")
	private Long companyId;
}
