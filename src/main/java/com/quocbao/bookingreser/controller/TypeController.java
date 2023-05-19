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

import com.quocbao.bookingreser.request.TypeRequest;
import com.quocbao.bookingreser.service.TypeService;

@RestController
@RequestMapping("/types")
public class TypeController {

	@Autowired
	TypeService typeService;

	@PostMapping("/create")
	ResponseEntity<Object> createType(@RequestBody TypeRequest typeRequest) {
		typeService.addType(typeRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/")
	ResponseEntity<Object> types(@RequestParam("type") String type){
		return new ResponseEntity<>(typeService.types(type), HttpStatus.OK);
	}
}
