package com.quocbao.bookingreser.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.entity.metamodel.Warehouse_;
import com.quocbao.bookingreser.exception.AlreadyExistException;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.repository.WarehouseRepository;
import com.quocbao.bookingreser.request.WarehouseRequest;
import com.quocbao.bookingreser.response.WarehouseResponse;
import com.quocbao.bookingreser.service.WarehouseService;
import com.quocbao.bookingreser.util.ConvertTime;
import com.quocbao.bookingreser.util.Status;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	WarehouseRepository warehouseRepository;
	@Autowired
	MaterialRepository materialRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void createWarehouse(WarehouseRequest warehouseRequest) {
		warehouseRepository
				.save(new Warehouse(warehouseRequest, materialRepository.findById(warehouseRequest.getMaterialId()),
						employeeRepository.findById(warehouseRequest.getEmployeeId())));
	}

	@Override
	public WarehouseResponse detailWarehouse(Long id) {
		return new WarehouseResponse(warehouseRepository.findById(id));
	}

	@Override
	public List<Warehouse> warehouseDetails(Long warehouseId, LocalDate fromDate, LocalDate toDate) {
		ConvertTime convertTime = new ConvertTime();
		List<Warehouse> warehouseDetails = warehouseRepository
				.getAll(Warehouse.class, Warehouse_.MATERIALID, "id", warehouseId).stream()
				.filter(x -> fromDate.isBefore(convertTime.fromTimestamp(x.getCreatedAt())))
				.filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isAfter(toDate)).toList();
		if (warehouseDetails.isEmpty()) {
			throw new NotFoundException("Warehouse detail not found with: " + warehouseId.toString());
		}
		return warehouseDetails;
	}

	@Override
	public void updateWarehouse(Long id, WarehouseRequest warehouseRequest) {
		Warehouse warehouse = warehouseRepository.findById(id);
		warehouse.setWarehouse(warehouseRequest);
		warehouseRepository.update(warehouse);
	}

	@Override
	public void updateStatus(Long id, String status) {
		Warehouse warehouse = warehouseRepository.findById(id);
		if (warehouse.getStatus().equals(Status.SUCCESS.toString())) {
			throw new AlreadyExistException("Action not taken");
		}
		if (status.equals(Status.APPROVE.toString())) {
			Material material = materialRepository.findById(warehouse.getId());
			material.setQuantity(warehouse.getQuantity());
			material.setStatus(Status.STOCKING.toString());
			materialRepository.update(material);
		}
		warehouseRepository.uColumn(id, Warehouse_.STATUS, status);
	}
}
