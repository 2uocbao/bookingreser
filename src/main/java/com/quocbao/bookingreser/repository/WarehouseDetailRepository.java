package com.quocbao.bookingreser.repository;

import java.sql.Timestamp;
import java.util.List;

import com.quocbao.bookingreser.entity.WarehouseDetail;

public interface WarehouseDetailRepository {

	public WarehouseDetail createWarehouseDetail(WarehouseDetail warehouseDetail);
	
	public WarehouseDetail detailWarehouseDetail(Long id);
	
	public WarehouseDetail updateWarehouseDetail(WarehouseDetail warehouseDetail);
	
	public List<WarehouseDetail> listWarehouseDetailByWarehouseId(Long id);
	
	public List<WarehouseDetail> listWarehouseDetailByDay(Timestamp fromDay, Timestamp toDay);
	
	public List<WarehouseDetail> listWarehouseDetailByEmployeeId(Long id);
}
