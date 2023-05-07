package com.quocbao.bookingreser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.response.WarehouseResponse;

public interface WarehouseService {
	public ResponseEntity<WarehouseResponse> createWarehouse(Warehouse warehouse);

	public ResponseEntity<WarehouseResponse> detailWarehouse(Long id);

	public ResponseEntity<WarehouseResponse> updateWarehouse(Warehouse warehouse);

	public ResponseEntity<List<WarehouseResponse>> listWarehouseByCompanyId(Long companyId);
}
