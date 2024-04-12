package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.AccountRequest;
import com.quocbao.bookingreser.response.AccountResponse;
import com.quocbao.bookingreser.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.OK)
	public AccountResponse createAccount(@RequestBody AccountRequest accountRequest) {
		return accountService.createAccount(accountRequest);
	}

	@PostMapping("/login")
	@ResponseStatus(code = HttpStatus.OK)
	public AccountResponse login(@RequestBody AccountRequest accountRequest) {
		return accountService.login(accountRequest);
	}
}
