package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.entity.Food;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.entity.metamodel.FoodDetail_;
import com.quocbao.bookingreser.entity.metamodel.OrderDetail_;
import com.quocbao.bookingreser.entity.metamodel.Order_;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.repository.FoodDetailRepository;
import com.quocbao.bookingreser.repository.FoodRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.repository.OrderDetailRepository;
import com.quocbao.bookingreser.repository.OrderRepository;
import com.quocbao.bookingreser.repository.ServiceRepository;
import com.quocbao.bookingreser.repository.UserRepository;
import com.quocbao.bookingreser.request.OrderDetailRequest;
import com.quocbao.bookingreser.request.OrderRequest;
import com.quocbao.bookingreser.service.OrderService;
import com.quocbao.bookingreser.util.Status;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private FoodRepository foodRepository;
	@Autowired
	private FoodDetailRepository foodDetailRepository;
	@Autowired
	private MaterialRepository materialRepository;

	// Order
	@Override
	public void createOrder(OrderRequest orderRequest) {
		Employee employee = employeeRepository.findById(orderRequest.getEmployeeId());
		orderRepository.save(
				new Order(orderRequest, employee.getCompany(), serviceRepository.findById(orderRequest.getServiceId()),
						employee, userRepository.findById(orderRequest.getUserId())));
	}

	@Override
	public Order detailOrder(Long id) {
		Order order = orderRepository.findById(id);
		if (order == null) {
			throw new NotFoundException("Order information not found with: " + id.toString());
		}
		return order;
	}

	@Override
	public void updateOrder(Long id, OrderRequest orderRequest) {
		Order order = orderRepository.findById(id);
		order.setOrder(orderRequest,
				!order.getService().getId().equals(orderRequest.getServiceId())
						? serviceRepository.findById(orderRequest.getServiceId())
						: order.getService(),
				!order.getEmployee().getId().equals(orderRequest.getEmployeeId())
						? employeeRepository.findById(orderRequest.getEmployeeId())
						: order.getEmployee(),
				!order.getUser().getId().equals(orderRequest.getUserId())
						? userRepository.findById(orderRequest.getUserId())
						: order.getUser());
		orderRepository.update(order);
	}

	@Override
	public List<Order> listOrderByCompanyId(Long companyId) {
		return orderRepository.getAll(Company.class, Order_.COMPANYID, "id", companyId);
	}

	@Override
	public List<Order> listOrderByUserId(Long userId) {
		return orderRepository.getAll(User.class, Order_.USERID, "id", userId);
	}

	@Override
	public void uStatus(Long id, String status) {
		orderRepository.uColumn(id, Order_.STATUS, status);
	}

	@Override
	public Order payOrder(Long id) {
		Status status = Status.RECEIVED;
		float total;
		Order order = orderRepository.findById(id);
		// Danh sach mon an da order
		List<OrderDetail> orderDetails = orderDetailRepository.getAll(Order.class, OrderDetail_.ORDERID, "id", id);
		// Danh sach cac mon an da phuc vu
		orderDetails = orderDetails.stream().filter(x -> x.getStatus().equals(status.toString())).toList();
		// Tong tien = cac mon an da phuc vu * so luong
		total = orderDetails.stream().map(x -> x.getFood().getPrice() * x.getQuantity()).count();
		// Cap nhat tong tien goi mon
		order.setTotalAmount(total);
		orderRepository.update(order);
		return order;
	}

	// OrderDetail
	@Override
	public void createOrderDetail(OrderDetailRequest orderDetailRequest) {
		orderDetailRepository
				.save(new OrderDetail(orderDetailRequest, orderRepository.findById(orderDetailRequest.getOrderId()),
						foodRepository.findById(orderDetailRequest.getFoodId())));
	}

	@Override
	public List<OrderDetail> orderDetails(Long orderId) {
		List<OrderDetail> orderDetails = orderDetailRepository.getAll(Order.class, OrderDetail_.ORDERID, "id", orderId);
		if (orderDetails.isEmpty()) {
			throw new NotFoundException("Order detail not found with: " + orderId.toString());
		}
		return orderDetails;
	}

	@Override
	public void updateOrderDetail(Long id, OrderDetailRequest orderDetailRequest) {
		OrderDetail orderDetail = orderDetailRepository.findById(id);
		orderDetail.setOrderDetail(orderDetailRequest);
		orderDetailRepository.update(orderDetail);
	}

	@Override
	public void uStatusOrderDetail(Long id) {
		Status served = Status.SERVED;
		Status procesing = Status.PROCESSING;
		Status received = Status.RECEIVED;
		// Mon an cap nhat trang thai
		OrderDetail orderDetail = orderDetailRepository.findById(id);
		if (orderDetail.getStatus().equals(served.toString())) {
			orderDetail.setStatus(procesing.toString());
			orderDetailRepository.update(orderDetail);
			throw new NotFoundException(orderDetail.getFood().getName() + "is being prepared");
		}
		// Chi tiet mon an
		List<FoodDetail> foodDetails = foodDetailRepository.getAll(Food.class, FoodDetail_.FOODID, "id",
				orderDetail.getFood().getId());
		// Cap nhat nguyen lieu
		foodDetails.stream().forEach(x -> {
			Material material = materialRepository.findById(x.getMaterial().getId());
			material.setQuantity(material.getQuantity() - x.getQuantity() * orderDetail.getQuantity());
			materialRepository.update(material);
		});
		// Cap nhat trang thai mon an
		orderDetail.setStatus(received.toString());
		orderDetailRepository.update(orderDetail);
	}
}
