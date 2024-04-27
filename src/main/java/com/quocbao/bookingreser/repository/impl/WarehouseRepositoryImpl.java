package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.repository.WarehouseRepository;

@Repository
public class WarehouseRepositoryImpl extends RepositoryImpl<Warehouse> implements WarehouseRepository {

	protected WarehouseRepositoryImpl() {
		super(Warehouse.class);
	}

}
