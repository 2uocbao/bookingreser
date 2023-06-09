package com.quocbao.bookingreser.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.entity.Warehouse;
import com.quocbao.bookingreser.entity.metamodel.Material_;
import com.quocbao.bookingreser.entity.metamodel.OrderDetail_;
import com.quocbao.bookingreser.entity.metamodel.Order_;
import com.quocbao.bookingreser.entity.metamodel.Warehouse_;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.repository.FoodRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.repository.OrderDetailRepository;
import com.quocbao.bookingreser.repository.OrderRepository;
import com.quocbao.bookingreser.repository.WarehouseRepository;
import com.quocbao.bookingreser.response.ReportResponse;
import com.quocbao.bookingreser.service.ReportService;
import com.quocbao.bookingreser.util.ConvertTime;
import com.quocbao.bookingreser.util.Status;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	FoodRepository foodRepository;
	@Autowired
	OrderDetailRepository orderDetailRepository;
	@Autowired
	MaterialRepository materialRepository;
	@Autowired
	WarehouseRepository warehouseRepository;

	private ReportResponse reportRevenue(List<Order> orders, List<Warehouse> warehouses) {
		ReportResponse reportResponse = new ReportResponse();
		orders.stream().forEach(x -> reportResponse.setTurnover(reportResponse.getTurnover() + x.getTotalAmount()));
		warehouses.stream().forEach(x -> reportResponse.setCost(reportResponse.getCost() + x.getTotalAmount()));
		reportResponse.setProfit(reportResponse.getTurnover() - reportResponse.getProfit());
		return reportResponse;
	}

	private ReportResponse reportFood(List<Order> orders, Food food) {
		// Retrieve orders detail list have food
		List<OrderDetail> orderDetails = orderDetailRepository.getAll(Food.class, OrderDetail_.FOODID, "id",
				food.getId());
		// Remove orders detail object. If it don't belong to any orders
		orderDetails.stream().forEach(x -> orders.stream().forEach(y -> {
			if (!y.equals(x.getOrder())) {
				orderDetails.remove(x);
			}
		}));
		ReportResponse reportResponse = new ReportResponse();
		orderDetails.stream().forEach(
				x -> reportResponse.setTurnover(reportResponse.getTurnover() + x.getQuantity() * food.getPrice()));
		food.getFoodDetails().stream().forEach(
				x -> reportResponse.setCost(reportResponse.getCost() + x.getQuantity() * x.getMaterial().getCost()));
		reportResponse.setProfit(reportResponse.getTurnover() - reportResponse.getProfit());
		return reportResponse;
	}

	@Override
	public ReportResponse reportByTime(LocalDate start, LocalDate end, String entity, Long id) {
		ConvertTime convertTime = new ConvertTime();
		// Report work of food in three months
		if (entity.equals("food")) {
			// Retrieve food entity
			Food food = foodRepository.findById(id);
			// Retrieve orders list from start month to end month
			List<Order> orders = orderRepository.getAll(Company.class, Order_.COMPANYID, "id",
					food.getCompany().getId());
			orders.stream().filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isAfter(start))
					.filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isBefore(end));
			return reportFood(orders, food);
		} else if (entity.equals("material")) { // Report for material
			Material material = materialRepository.findById(id);
			List<Warehouse> warehouses = warehouseRepository.getAll(Material.class, Warehouse_.MATERIALID, "id", id)
					.stream().filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isAfter(start))
					.filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isBefore(end))
					.filter(x -> x.getStatus().equals(Status.SUCCESS.toString())).toList();
			return reportMaterial(material, warehouses);
		} else if (entity.equals("employee")) {
			List<Order> orders = orderRepository.getAll(Employee.class, Order_.EMPLOYEEID, "id", id).stream()
					.filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isAfter(start))
					.filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isBefore(end))
					.filter(x -> x.getStatus().equals(Status.SUCCESS.toString())).toList();
			return reportEmployeeRevenue(orders, id);
		}
		// Report revenue three months for company
		// Retrieve orders list
		List<Order> orders = orderRepository.getAll(Company.class, Order_.COMPANYID, "id", id);
		// Retrive materials list
		List<Material> materials = materialRepository.getAll(Company.class, Material_.COMPANYID, "id", id);
		List<Warehouse> warehouses = new ArrayList<>();
		materials.stream().forEach(x -> warehouses
				.addAll(warehouseRepository.getAll(Material.class, Warehouse_.MATERIALID, "id", x.getId())));
		orders.stream().filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isAfter(start))
				.filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isBefore(end));
		warehouses.stream().filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isAfter(start))
				.filter(x -> convertTime.fromTimestamp(x.getCreatedAt()).isBefore(end));
		return reportRevenue(orders, warehouses);
	}

	private ReportResponse reportMaterial(Material material, List<Warehouse> warehouses) {
		ReportResponse reportResponse = new ReportResponse();
		warehouses.stream().forEach(x -> reportResponse.setCost(reportResponse.getCost() + x.getTotalAmount()));
		warehouses.stream().forEach(x -> reportResponse.setProfit(reportResponse.getProfit() + x.getQuantity()));
		reportResponse.setTurnover(reportResponse.getTurnover() - material.getQuantity());
		return reportResponse;
	}

	public ReportResponse reportEmployeeRevenue(List<Order> orders, Long employeeId) {
		ReportResponse reportResponse = new ReportResponse();
		Employee employee = employeeRepository.findById(employeeId);
		orders.stream().forEach(x -> reportResponse.setProfit(reportResponse.getProfit() + x.getTotalAmount()));
		reportResponse.setCost(employee.getKpa());
		return null;
	}

}
