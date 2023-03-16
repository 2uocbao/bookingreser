package com.quocbao.bookingreser.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.request.WarehouseDetailRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class WarehouseDetailReponse extends WarehouseDetailRequest{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("warehouse_id")
	private Long warehouseId;
	
	@JsonProperty("employee_id")
	private Long employeeId;
	
}
