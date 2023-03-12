package com.quocbao.bookingreser.repository;

import java.util.List;

import com.quocbao.bookingreser.entity.Warehouse;

public interface WarehouseRepository {

	public Warehouse createWarehouse(Warehouse warehouse);
	
	public Warehouse detailWarehouse(Long id);
	
	public Warehouse updateWarehouse(Warehouse warehouse);
	
	public List<Warehouse> listWarehouseByCompanyId(Long companyId);
}
