package com.quocbao.bookingreser.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.quocbao.bookingreser.request.AccountRequest;

public interface AccountService {

	public void createAccount(AccountRequest accountRequest);

	public void updateAccountRole(AccountRequest accountRequest);
	
	public UserDetails loadUserByUsername(String username);
}
