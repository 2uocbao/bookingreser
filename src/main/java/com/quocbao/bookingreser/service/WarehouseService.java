package com.quocbao.bookingreser.service;

import java.time.LocalDate;
import java.util.List;

import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.entity.WarehouseDetail;
import com.quocbao.bookingreser.request.WarehouseDetailRequest;
import com.quocbao.bookingreser.request.WarehouseRequest;

public interface WarehouseService {

	public void createWarehouse(WarehouseRequest warehouseRequest);

	public Warehouse detailWarehouse(Long id);

	public void updateWarehouse(Long id, WarehouseRequest warehouseRequest);

	public List<Warehouse> listWarehouseByCompanyId(Long companyId);

	// WarehouseDetail
	public void createWarehouseDetail(WarehouseDetailRequest warehouseDetailRequest);

	public WarehouseDetail detailWarehouseDetail(Long id);

	public List<WarehouseDetail> warehouseDetails(Long warehouseId, LocalDate fromDate, LocalDate toDate);
}
