package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.OrderRequest;
import com.quocbao.bookingreser.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/create")
	ResponseEntity<Object> createOrder(@RequestBody OrderRequest orderRequest) {
		orderService.createOrder(orderRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Object> detailOrder(@PathVariable Long id) {
		return new ResponseEntity<>(orderService.detailOrder(id), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<Object> updateOrder(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
		orderService.updateOrder(id, orderRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}/pay")
	ResponseEntity<Object> payOrder(@PathVariable Long id) {
		return new ResponseEntity<>(orderService.payOrder(id), HttpStatus.OK);
	}

	@GetMapping("/{companyId}/byCompany")
	ResponseEntity<Object> listByCompanyId(@PathVariable Long companyId) {
		return new ResponseEntity<>(orderService.listOrderByCompanyId(companyId), HttpStatus.OK);
	}

	@GetMapping("/{userId}/byUser")
	ResponseEntity<Object> listByUserId(@PathVariable Long userId) {
		return new ResponseEntity<>(orderService.listOrderByUserId(userId), HttpStatus.OK);
	}

	@PutMapping("/{orderDetailId}/orderDetail")
	ResponseEntity<Object> updateStatusOrderDetail(@PathVariable Long orderDetailId,
			@RequestParam("status") String status) {
		orderService.uStatusOrderDetails(orderDetailId, status);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
