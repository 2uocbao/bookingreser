package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.RoleRequest;
import com.quocbao.bookingreser.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@PostMapping("/create")
	ResponseEntity<Object> createRole(@RequestBody RoleRequest roleRequest){
		roleService.createRole(roleRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
