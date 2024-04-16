package com.quocbao.bookingreser.response;

import java.util.List;

import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.request.MaterialRequest;

import lombok.Setter;

@Setter
public class MaterialResponse extends MaterialRequest{

	public MaterialResponse(Material material) {
		this.id = material.getId();
		this.companyId = material.getCompany() == null ? null : material.getCompany().getId();
		this.code = material.getCode();
		this.name = material.getName();
		this.cost = material.getCost();
		this.quantity = material.getQuantity();
		this.stockEnd = material.getStockEnd();
		this.status = material.getStatus();
	}

	public List<MaterialResponse> materialResponses(List<Material> materials) {
		return materials.stream().map(MaterialResponse::new).toList();
	}

	public MaterialResponse() {

	}
}
