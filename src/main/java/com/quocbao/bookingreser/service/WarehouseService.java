package com.quocbao.bookingreser.service;

import java.time.LocalDate;
import java.util.List;

import com.quocbao.bookingreser.request.WarehouseRequest;
import com.quocbao.bookingreser.response.WarehouseResponse;

public interface WarehouseService {

	public void createWarehouse(WarehouseRequest warehouseRequest);

	public WarehouseResponse detailWarehouse(Long id);

	public void updateWarehouse(Long id, WarehouseRequest warehouseRequest);

	public void updateStatus(Long id, String status);

	public List<WarehouseResponse> warehouses(Long materialId, LocalDate fromDate, LocalDate toDate);
}
