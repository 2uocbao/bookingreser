package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.EmpUserRequest;
import com.quocbao.bookingreser.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/create")
	ResponseEntity<Object> createUser(@RequestBody EmpUserRequest userRequest) {
		userService.createUser(userRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Object> detailUser(@PathVariable Long id) {
		return new ResponseEntity<>(userService.detailUser(id), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody EmpUserRequest empUserRequest) {
		userService.updateUser(id, empUserRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}/removeUser")
	ResponseEntity<Object> removeUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
