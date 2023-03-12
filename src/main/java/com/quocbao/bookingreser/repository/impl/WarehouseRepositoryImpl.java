package com.quocbao.bookingreser.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.repository.WarehouseRepository;

@Repository
public class WarehouseRepositoryImpl extends AbstractRepository<Warehouse> implements WarehouseRepository {

	@Override
	public Warehouse createWarehouse(Warehouse warehouse) {
		return this.create(warehouse);
	}

	@Override
	public Warehouse detailWarehouse(Long id) {
		return this.detail(id);
	}

	@Override
	public Warehouse updateWarehouse(Warehouse warehouse) {
		return this.update(warehouse);
	}

	@Override
	public List<Warehouse> listWarehouseByCompanyId(Long companyId) {
		return this.listWarehouseByCompanyId(companyId);
	}

}
