package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.common.DataResponse;
import com.quocbao.bookingreser.request.ServiceRequest;
import com.quocbao.bookingreser.service.ServicesService;

@RestController
@RequestMapping("/service")
public class ServicesController {

	@Autowired
	private ServicesService servicesService;

	@PostMapping("/create")
	public ResponseEntity<DataResponse> createService(@RequestBody ServiceRequest serviceRequest) {
		servicesService.createService(serviceRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{id}/detail")
	public ResponseEntity<DataResponse> detailService(@PathVariable Long id) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, servicesService.detailService(id)), HttpStatus.OK);
	}

	@GetMapping("/{companyId}/getAll")
	public ResponseEntity<DataResponse> getAllService(@PathVariable Long companyId) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, servicesService.listServiceByCompany(companyId)),
				HttpStatus.OK);
	}
}
