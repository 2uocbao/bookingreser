package com.quocbao.bookingreser.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.entity.metamodel.Warehouse_;
import com.quocbao.bookingreser.exception.ResourceNotFoundException;
import com.quocbao.bookingreser.exception.ValidationException;
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
		List<Warehouse> warehouses = warehouseRepository.getAll(Material.class, Warehouse_.MATERIALID, "id",
				warehouseRequest.getMaterialId().toString());
		warehouses.stream().forEach(x -> {
			// If status of warehouse for material have not success.
			// New warehouse will not be created for that material
			if (!x.getStatus().equals(Status.SUCCESS.toString())) {
				throw new ValidationException("There is at least one unfinished activity with this material");
			}
		});
		warehouseRepository
				.save(new Warehouse(warehouseRequest, materialRepository.findById(warehouseRequest.getMaterialId()),
						employeeRepository.findById(Long.parseLong(warehouseRequest.getEmployeeId()))));
	}

	@Override
	public WarehouseResponse detailWarehouse(Long id) {
		return new WarehouseResponse(warehouseRepository.findById(id));
	}

	@Override
	public List<WarehouseResponse> warehouses(Long materialId, LocalDate fromDate, LocalDate toDate) {
		// Between to day, don't get start day and end day
		ConvertTime convertTime = new ConvertTime();
		List<Warehouse> warehouses = warehouseRepository.getAll(Material.class, Warehouse_.MATERIALID, "id", materialId.toString())
				.stream().filter(x -> fromDate.isBefore(convertTime.fromTimestamp(x.getCreatedAt())))
				.filter(x -> toDate.isAfter(convertTime.fromTimestamp(x.getCreatedAt()))).toList();
		if (warehouses.isEmpty()) {
			throw new ResourceNotFoundException("Warehouse detail not found");
		}
		return new WarehouseResponse().warehouseResponses(warehouses);
	}

	@Override
	public void updateWarehouse(Long id, WarehouseRequest warehouseRequest) {
		Warehouse warehouse = warehouseRepository.findById(id);
		if(warehouse.getStatus() == Status.SUCCESS.toString()) {
			throw new ValidationException(warehouse.getMaterial().getName() + " is success, do not update");
		}
		warehouse.setWarehouse(warehouseRequest);
		warehouseRepository.update(warehouse);
	}

	@Override
	public void updateStatus(Long id, String status) {
		Warehouse warehouse = warehouseRepository.findById(id);
		if (warehouse.getStatus().equals(Status.SUCCESS.toString())) {
			throw new ValidationException("Action not taken");
		}
		if (status.equals(Status.SUCCESS.toString())) {
			Material material = materialRepository.findById(warehouse.getMaterial().getId());
			material.setQuantity(warehouse.getQuantity() + material.getQuantity());
			if(material.getQuantity() < material.getStockEnd()) {
				material.setStatus(Status.OUT_OF_STOCK.toString());
			}else {
				material.setStatus(Status.AVAILABLE.toString());
			}
			material.setCost(warehouse.getCost());
			materialRepository.update(material);
		}
		warehouseRepository.uColumn(id, Warehouse_.STATUS, status);
	}
}
