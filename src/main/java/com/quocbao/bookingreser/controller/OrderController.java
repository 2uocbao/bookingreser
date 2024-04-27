package com.quocbao.bookingreser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.OrderRequest;
import com.quocbao.bookingreser.response.OrderResponse;
import com.quocbao.bookingreser.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void createOrder(@RequestBody OrderRequest orderRequest) {
		orderService.createOrder(orderRequest);
	}

	@GetMapping("/{id}/detail")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderResponse detailOrder(@PathVariable Long id) {
		return orderService.detailOrder(id);
	}

	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateOrder(@RequestBody OrderRequest orderRequest) {
		orderService.updateOrder(orderRequest);
	}

	@GetMapping("/{id}/pay")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderResponse payOrder(@PathVariable Long id) {
		return orderService.payOrder(id);
	}

	@GetMapping("/{companyId}/company")
	@ResponseStatus(code = HttpStatus.OK)
	public List<OrderResponse> listByCompanyId(@PathVariable Long companyId) {
		return orderService.listOrderByCompanyId(companyId);
	}

	@GetMapping("/{userId}/user")
	@ResponseStatus(code = HttpStatus.OK)
	public List<OrderResponse> listByUserId(@PathVariable Long userId) {
		return orderService.listOrderByUserId(userId);
	}

	@PutMapping("/detail/status/{orderDetailId}/update")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateStatusOrderDetail(@PathVariable Long orderDetailId, @RequestParam("status") String status) {
		orderService.uStatusOrderDetails(orderDetailId, status);
	}
}
