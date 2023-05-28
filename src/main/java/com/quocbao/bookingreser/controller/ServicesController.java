package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.ServiceRequest;
import com.quocbao.bookingreser.service.ServicesService;

@RestController
@RequestMapping("/service")
public class ServicesController {

	@Autowired
	private ServicesService servicesService;

	@PostMapping("/create")
	public ResponseEntity<Object> createService(@RequestBody ServiceRequest serviceRequest) {
		servicesService.createService(serviceRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> detailService(@RequestAttribute Long id) {
		return new ResponseEntity<>(servicesService.detailService(id), HttpStatus.OK);
	}

	@GetMapping("/{companyId}/getAll")
	public ResponseEntity<Object> getAllService(@RequestAttribute Long companyId) {
		return new ResponseEntity<>(servicesService.listServiceByCompany(companyId), HttpStatus.OK);
	}
}
