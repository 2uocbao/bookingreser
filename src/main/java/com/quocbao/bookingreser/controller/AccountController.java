package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.AccountRequest;
import com.quocbao.bookingreser.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/create")
	public ResponseEntity<Object> createAccount(@RequestBody AccountRequest accountRequest) {
		return new ResponseEntity<>(accountService.createAccount(accountRequest), HttpStatus.OK);
	}

	@GetMapping("/login")
	public ResponseEntity<Object> login(@RequestBody AccountRequest accountRequest) {
		return new ResponseEntity<>(accountService.login(accountRequest), HttpStatus.OK);
	}
}
