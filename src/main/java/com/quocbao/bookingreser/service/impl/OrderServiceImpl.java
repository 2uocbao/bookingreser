package com.quocbao.bookingreser.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.Employee;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.entity.metamodel.Food_;
import com.quocbao.bookingreser.entity.metamodel.OrderDetail_;
import com.quocbao.bookingreser.entity.metamodel.Order_;
import com.quocbao.bookingreser.entity.metamodel.Services_;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.EmployeeRepository;
import com.quocbao.bookingreser.repository.FoodRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.repository.OrderDetailRepository;
import com.quocbao.bookingreser.repository.OrderRepository;
import com.quocbao.bookingreser.repository.ServicesRepository;
import com.quocbao.bookingreser.repository.UserRepository;
import com.quocbao.bookingreser.request.OrderRequest;
import com.quocbao.bookingreser.response.OrderDetailResponse;
import com.quocbao.bookingreser.response.OrderResponse;
import com.quocbao.bookingreser.service.OrderService;
import com.quocbao.bookingreser.util.Status;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ServicesRepository serviceRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private FoodRepository foodRepository;
	@Autowired
	private MaterialRepository materialRepository;

	@Override
	public void createOrder(OrderRequest orderRequest) {
		Employee employee = employeeRepository.findById(orderRequest.getEmployeeId());
		Order order = new Order(orderRequest, employee.getCompany(),
				serviceRepository.findById(orderRequest.getServiceId()), employee);
		orderRepository.save(order);
		orderRequest.getOrderDetailRequests().stream().forEach(
				x -> orderDetailRepository.save(new OrderDetail(x, foodRepository.findById(x.getFoodId()), order)));
		serviceRepository.uColumn(orderRequest.getServiceId(), Services_.STATUS, Status.USED.toString());
	}

	@Override
	public OrderResponse detailOrder(Long id) {
		Order order = orderRepository.findById(id);
		if (order == null) {
			throw new NotFoundException("Order information not found with: " + id.toString());
		}
		return new OrderResponse(order);
	}

	@Override
	public void updateOrder(Long id, OrderRequest orderRequest) {
		Order order = orderRepository.findById(id);
		order.setDescription(orderRequest.getDescription());
		if (orderRequest.getUserId() != null) {
			order.setUser(userRepository.findById(orderRequest.getUserId()));
		}
		orderRepository.update(order);

		// Retrieve a list of existing order details
		List<OrderDetail> existingOrderDetails = order.getOrderDetails();
		// Retrieve a list of new or update order details
		List<OrderDetail> upnewOrderDetails = orderRequest.getOrderDetailRequests().stream()
				.map(x -> new OrderDetail(x, foodRepository.findById(x.getFoodId()), order)).toList();
		// Create a list of order details no change
		List<OrderDetail> nochangeOrderDetails = new ArrayList<>();
		// Create a list of update order details
		List<OrderDetail> updateOrderDetails = new ArrayList<>();
		// Create a list of remove order details
		List<OrderDetail> removeOrderDetails = new ArrayList<>();

		// Iterate through the existing order details object
		for (OrderDetail existOrderDetail : existingOrderDetails) {
			// Check if existing order detail object exist in new order detail
			boolean exist = false;
			for (OrderDetail upnewOrderDetail : upnewOrderDetails) {
				if (existOrderDetail.getFood().getId().equals(upnewOrderDetail.getFood().getId())
						&& existOrderDetail.getQuantity() == upnewOrderDetail.getQuantity()) {
					// If exist and new order detail equals in food id and quantity
					// Add exist to no change list
					exist = true;
					nochangeOrderDetails.add(existOrderDetail);
				} else if (existOrderDetail.getFood().getId().equals(upnewOrderDetail.getFood().getId())
						&& existOrderDetail.getQuantity() < upnewOrderDetail.getQuantity()) {
					// If exist and new order detail equals in food id
					// and quantity exist less in new quantity
					exist = true;
					// Update new quantity
					existOrderDetail.setQuantity(upnewOrderDetail.getQuantity());
					// Update status based on quantity order update
					existOrderDetail.setStatus(
							Integer.toString(upnewOrderDetail.getQuantity() - existOrderDetail.getQuantity()) + "LEFT");
					updateOrderDetails.add(existOrderDetail);
					break;
				}
			}
			if (!exist) {
				// If status order was served, can't be remove that
				// Else add exist to remove list
				removeOrderDetails.add(existOrderDetail);
			}
		}

		// Remove order detail object if this status was served
		removeOrderDetails.removeIf(t -> t.getStatus().equals(Status.SERVED.toString()));

		// Remove order detail object if this have in remove
		existingOrderDetails.removeAll(removeOrderDetails);

		// Iterate through the new order detail object
		for (OrderDetail newOrderDetail : upnewOrderDetails) {
			// Find food for order, if it exist
			OrderDetail existOrderDetail = findExistOrderDetail(existingOrderDetails, newOrderDetail.getFood().getId());
			if (existOrderDetail == null) {
				existingOrderDetails.add(newOrderDetail);
			}
		}

		// Remove order detail object no change
		existingOrderDetails.removeAll(nochangeOrderDetails);

		// Remove order detail existing object if it is update
		existingOrderDetails.removeAll(updateOrderDetails);

		// Update order detail
		updateOrderDetails.stream().forEach(x -> orderDetailRepository.update(x));

		// Remove order detail
		removeOrderDetails.stream().forEach(x -> orderDetailRepository.delete(x));

		// Create new order detail
		existingOrderDetails.stream().forEach(x -> orderDetailRepository.save(x));
	}

	@Override
	public List<OrderResponse> listOrderByCompanyId(Long companyId) {
		return new OrderResponse()
				.orderResponses(orderRepository.getAll(Company.class, Order_.COMPANYID, "id", companyId));
	}

	@Override
	public List<OrderResponse> listOrderByUserId(Long userId) {
		return new OrderResponse().orderResponses(orderRepository.getAll(User.class, Order_.USERID, "id", userId));
	}

	@Override
	public void uStatus(Long id, String status) {
		orderRepository.uColumn(id, Order_.STATUS, status);
	}

	@Override
	public OrderResponse payOrder(Long id) {
		Order order = orderRepository.findById(id);
		// Retrieve a list of existing order details
		List<OrderDetail> orderDetails = order.getOrderDetails();
		// Remove order detail object if this status was not served
		orderDetails.removeIf(x -> !x.getStatus().equals(Status.SERVED.toString()));
		orderDetails.stream().forEach(
				x -> order.setTotalAmount(order.getTotalAmount() + (x.getQuantity() * x.getFood().getPrice())));
		order.setStatus(Status.SUCCESS.toString());
		// Retrieve detail order reponse
		List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
		orderDetails.stream().forEach(x -> orderDetailResponses.add(new OrderDetailResponse(x)));
		orderRepository.update(order);
		OrderResponse orderResponse = new OrderResponse(order);
		orderResponse.setOrderDetailResponses(orderDetailResponses);
		serviceRepository.uColumn(order.getService().getId(), Services_.STATUS, Status.EMPTY.toString());
		return orderResponse;
	}

	@Override
	public void uStatusOrderDetails(Long orderDetailId, String status) {
		OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId);
		// If status update is served
		if (status.equals(Status.SERVED.toString())) {
			// Retrieve a list of food
			List<FoodDetail> foodDetails = orderDetail.getFood().getFoodDetails();
			foodDetails.stream().forEach(x -> {
				// Update quantity of material used for food
				Material material = materialRepository.findById(x.getMaterial().getId());
				material.setQuantity(material.getQuantity() - (x.getQuantity() * orderDetail.getQuantity()));
				if (material.getQuantity() < material.getStockEnd()) {
					material.setStatus(Status.OVER.toString());
					foodRepository.uColumn(x.getFood().getId(), Food_.STATUS, Status.OFF.toString());
				}
				materialRepository.update(material);
			});
		}
		orderDetailRepository.uColumn(orderDetailId, OrderDetail_.STATUS, status);
	}

	public OrderDetail findExistOrderDetail(List<OrderDetail> existOrderDetails, Long foodId) {
		for (OrderDetail existOrderDetail : existOrderDetails) {
			if (existOrderDetail.getFood().getId().equals(foodId)) {
				return existOrderDetail;
			}
		}
		return null;
	}
}
