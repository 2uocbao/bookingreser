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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.common.DataResponse;
import com.quocbao.bookingreser.request.UserRequest;
import com.quocbao.bookingreser.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/create")
	ResponseEntity<DataResponse> createUser(@RequestBody UserRequest userRequest, @RequestHeader("Authorization") String authorization) {
		String token = authorization.replace("Bearer ", "");
		userService.createUser(userRequest, token);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/detail")
	ResponseEntity<DataResponse> detailUser(@RequestHeader("Authorization") String authorization) {
		String token = authorization.replace("Bearer ", "");
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, userService.detailUser(token)), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<DataResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest empUserRequest) {
		userService.updateUser(id, empUserRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@DeleteMapping("/{id}/removeUser")
	ResponseEntity<Object> removeUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}
}
