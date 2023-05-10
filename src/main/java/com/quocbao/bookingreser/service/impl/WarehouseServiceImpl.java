package com.quocbao.bookingreser.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.entity.WarehouseDetail;
import com.quocbao.bookingreser.entity.metamodel.WarehouseDetail_;
import com.quocbao.bookingreser.entity.metamodel.Warehouse_;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.repository.WarehouseDetailRepository;
import com.quocbao.bookingreser.repository.WarehouseRepository;
import com.quocbao.bookingreser.request.WarehouseDetailRequest;
import com.quocbao.bookingreser.request.WarehouseRequest;
import com.quocbao.bookingreser.service.WarehouseService;
import com.quocbao.bookingreser.util.ConvertTime;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	WarehouseRepository warehouseRepository;
	@Autowired
	WarehouseDetailRepository warehouseDetailRepository;
	@Autowired
	MaterialRepository materialRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	// Warehouse
	@Override
	public void createWarehouse(WarehouseRequest warehouseRequest) {
		Material material = materialRepository.findById(warehouseRequest.getMaterialId());
		warehouseRepository.save(new Warehouse(material, material.getCompany()));
	}

	@Override
	public Warehouse detailWarehouse(Long id) {
		return warehouseRepository.findById(id);
	}

	@Override
	public void updateWarehouse(Long id, WarehouseRequest warehouseRequest) {
		Warehouse warehouse = warehouseRepository.findById(id);
		warehouse.setWarehouse(materialRepository.findById(warehouseRequest.getMaterialId()));
		warehouseRepository.update(warehouse);
	}

	@Override
	public List<Warehouse> listWarehouseByCompanyId(Long companyId) {
		return warehouseRepository.getAll(Company.class, Warehouse_.COMPANYID, "id", companyId);
	}

	// WarehouseDetail
	@Override
	public void createWarehouseDetail(WarehouseDetailRequest warehouseDetailRequest) {
		warehouseDetailRepository.save(new WarehouseDetail(warehouseDetailRequest,
				warehouseRepository.findById(warehouseDetailRequest.getWarehouseId()),
				employeeRepository.findById(warehouseDetailRequest.getEmployeeId())));
	}

	@Override
	public WarehouseDetail detailWarehouseDetail(Long id) {
		return warehouseDetailRepository.findById(id);
	}

	@Override
	public List<WarehouseDetail> warehouseDetails(Long warehouseId, LocalDate fromDate, LocalDate toDate) {
		ConvertTime convertTime = new ConvertTime();
		return warehouseDetailRepository.getAll(Warehouse.class, WarehouseDetail_.WAREHOUSEID, "id", warehouseId)
				.stream().filter(x -> fromDate.isBefore(convertTime.fromTimestamp(x.getCreatedAt())))
				.filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isAfter(toDate)).toList();
	}

}
