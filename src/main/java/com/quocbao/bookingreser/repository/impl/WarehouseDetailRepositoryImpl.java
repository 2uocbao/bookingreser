package com.quocbao.bookingreser.repository.impl;

import org.springframework.stereotype.Repository;

import com.quocbao.bookingreser.common.RepositoryImpl;
import com.quocbao.bookingreser.entity.WarehouseDetail;
import com.quocbao.bookingreser.repository.WarehouseDetailRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class WarehouseDetailRepositoryImpl extends RepositoryImpl<WarehouseDetail>
		implements WarehouseDetailRepository {

	protected WarehouseDetailRepositoryImpl() {
		super(WarehouseDetail.class);
	}

}
