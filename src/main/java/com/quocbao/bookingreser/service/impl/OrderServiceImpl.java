package com.quocbao.bookingreser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Company;
import com.quocbao.bookingreser.entity.FoodDetail;
import com.quocbao.bookingreser.entity.Material;
import com.quocbao.bookingreser.entity.Order;
import com.quocbao.bookingreser.entity.OrderDetail;
import com.quocbao.bookingreser.entity.User;
import com.quocbao.bookingreser.entity.metamodel.Food_;
import com.quocbao.bookingreser.entity.metamodel.OrderDetail_;
import com.quocbao.bookingreser.entity.metamodel.Order_;
import com.quocbao.bookingreser.exception.ResourceNotFoundException;
import com.quocbao.bookingreser.repository.FoodRepository;
import com.quocbao.bookingreser.repository.MaterialRepository;
import com.quocbao.bookingreser.repository.OrderDetailRepository;
import com.quocbao.bookingreser.repository.OrderRepository;
import com.quocbao.bookingreser.request.OrderRequest;
import com.quocbao.bookingreser.response.OrderResponse;
import com.quocbao.bookingreser.service.OrderService;
import com.quocbao.bookingreser.util.Status;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private FoodRepository foodRepository;
	@Autowired
	private MaterialRepository materialRepository;

	@Override
	public void createOrder(OrderRequest orderRequest) {
		orderRepository.save(new Order(orderRequest));
	}

	@Override
	public OrderResponse detailOrder(Long id) {
		Order order = orderRepository.findById(id);
		if (order == null) {
			throw new ResourceNotFoundException("Order information not found");
		}		
		return new OrderResponse(order);
	}

	@Override
	public void updateOrder(OrderRequest orderRequest) {
		
	}

	@Override
	public List<OrderResponse> listOrderByCompanyId(Long companyId) {
		return new OrderResponse()
				.orderResponses(orderRepository.getAll(Company.class, Order_.COMPANYID, "id", companyId.toString()));
	}

	@Override
	public List<OrderResponse> listOrderByUserId(Long userId) {
		return new OrderResponse().orderResponses(orderRepository.getAll(User.class, Order_.USERID, "id", userId.toString()));
	}

	@Override
	public void uStatus(Long id, String status) {
		orderRepository.uColumn(id, Order_.STATUS, status);
	}

	@Override
	public OrderResponse payOrder(Long idService) {
//		Order order = null;
//		// Retrieve a list of existing order details
//		List<OrderDetail> orderDetails  = orderDetailRepository.getAll(Order.class, OrderDetail_.ORDERID, "id", id.toString());
//		// Remove order detail object if this status was not served
//		orderDetails.removeIf(x -> !x.getStatus().equals(Status.SERVED.toString()));
//		orderDetails.stream().forEach(
//				x -> order.setTotalAmount(order.getTotalAmount() + (x.getQuantity() * x.getFood().getPrice())));
//		order.setStatus(Status.SUCCESS.toString());
//		orderRepository.update(order);
////		OrderResponse orderResponse = new OrderResponse(order);
////		orderResponse.setOrderDetailResponses(orderDetailResponses);
//		serviceRepository.uColumn(order.getService().getId(), Services_.STATUS, Status.EMPTY.toString());
////		return orderResponse;
		
		return new OrderResponse(orderRepository.orderByServiceId(idService));
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
					material.setStatus(Status.OUT_OF_STOCK.toString());
					foodRepository.uColumn(x.getFood().getId(), Food_.STATUS, Status.OUT_OF_STOCK.toString());
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
