package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.entity.metamodel.OrderDetail_;
import com.quocbao.bookingreser.entity.metamodel.Order_;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.repository.FoodRepository;
import com.quocbao.bookingreser.repository.OrderDetailRepository;
import com.quocbao.bookingreser.repository.OrderRepository;
import com.quocbao.bookingreser.repository.ServiceRepository;
import com.quocbao.bookingreser.repository.UserRepository;
import com.quocbao.bookingreser.request.OrderDetailRequest;
import com.quocbao.bookingreser.request.OrderRequest;
import com.quocbao.bookingreser.service.OrderService;

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

	// OrderDetail
	@Override
	public void createOrderDetail(OrderDetailRequest orderDetailRequest) {
		orderDetailRepository
				.save(new OrderDetail(orderDetailRequest, orderRepository.findById(orderDetailRequest.getOrderId()),
						foodRepository.findById(orderDetailRequest.getFoodId())));
	}

	@Override
	public List<OrderDetail> orderDetails(Long orderId) {
		return orderDetailRepository.getAll(Order.class, OrderDetail_.ORDERID, "id", orderId);
	}

	@Override
	public void updateOrderDetail(Long id, OrderDetailRequest orderDetailRequest) {
		OrderDetail orderDetail = orderDetailRepository.findById(id);
		orderDetail.setOrderDetail(orderDetailRequest);
		orderDetailRepository.update(orderDetail);
	}

	@Override
	// trang thai phuc vu mon an
	public void uStatusOrderDetail(Long id, int value) {
		orderDetailRepository.uColumn(id, OrderDetail_.STATUS, value);
	}
}
