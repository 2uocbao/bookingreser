package com.quocbao.bookingreser.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.quocbao.bookingreser.request.AccountRequest;
import com.quocbao.bookingreser.response.AccountResponse;

public interface AccountService extends UserDetailsService{

	public AccountResponse createAccount(AccountRequest accountRequest);
	
	public AccountResponse login(AccountRequest accountRequest);

	public void updateAccountRole(AccountRequest accountRequest);
	
	public UserDetails loadUserByUsername(String username);
}
