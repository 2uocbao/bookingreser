package com.quocbao.bookingreser.service;

import java.time.LocalDate;
import java.util.List;

import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.request.WarehouseRequest;

public interface WarehouseService {
	
	public void createWarehouse(WarehouseRequest warehouseDetailRequest);

	public Warehouse detailWarehouse(Long id);

	public List<Warehouse> warehouseDetails(Long material, LocalDate fromDate, LocalDate toDate);
}
