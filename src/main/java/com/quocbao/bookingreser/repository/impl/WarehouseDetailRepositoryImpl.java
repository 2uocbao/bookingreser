package com.quocbao.bookingreser.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.WarehouseDetail;
import com.quocbao.bookingreser.repository.WarehouseDetailRepository;

@Repository
public class WarehouseDetailRepositoryImpl extends AbstractRepository<WarehouseDetail> implements WarehouseDetailRepository {

	@Override
	public WarehouseDetail createWarehouseDetail(WarehouseDetail warehouseDetail) {
		return this.create(warehouseDetail);
	}

	@Override
	public WarehouseDetail detailWarehouseDetail(Long id) {
		return this.detail(id);
	}

	@Override
	public WarehouseDetail updateWarehouseDetail(WarehouseDetail warehouseDetail) {
		return this.update(warehouseDetail);
	}

	@Override
	public List<WarehouseDetail> listWarehouseDetailByWarehouseId(Long id) {
		return this.listWarehouseDetailByWarehouseId(id);
	}

	@Override
	public List<WarehouseDetail> listWarehouseDetailByDay(Timestamp fromDay, Timestamp toDay) {
		return this.listWarehouseDetailByDay(fromDay, toDay);
	}

	@Override
	public List<WarehouseDetail> listWarehouseDetailByEmployeeId(Long id) {
		return this.listWarehouseDetailByEmployeeId(id);
	}
}
