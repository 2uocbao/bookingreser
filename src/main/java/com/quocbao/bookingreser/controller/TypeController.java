package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.common.DataResponse;
import com.quocbao.bookingreser.request.TypeRequest;
import com.quocbao.bookingreser.service.TypeService;

@RestController
@RequestMapping("/types")
public class TypeController {

	@Autowired
	TypeService typeService;

	@PostMapping("/create")
	ResponseEntity<DataResponse> createType(@RequestBody TypeRequest typeRequest) {
		typeService.addType(typeRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/getList")
	ResponseEntity<DataResponse> types(@RequestParam("type") String type) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, typeService.types(type)), HttpStatus.OK);
	}
}
