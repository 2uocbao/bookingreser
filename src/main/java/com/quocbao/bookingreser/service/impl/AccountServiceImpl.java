package com.quocbao.bookingreser.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Account;
import com.quocbao.bookingreser.entity.Role;
import com.quocbao.bookingreser.entity.metamodel.Account_;
import com.quocbao.bookingreser.exception.BookingreserException;
import com.quocbao.bookingreser.repository.AccountRepository;
import com.quocbao.bookingreser.repository.RoleRepository;
import com.quocbao.bookingreser.request.AccountRequest;
import com.quocbao.bookingreser.response.AccountResponse;
import com.quocbao.bookingreser.security.jwt.JwtTokenProvider;
import com.quocbao.bookingreser.service.AccountService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService, UserDetailsService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	JwtTokenProvider jwtTokenProvider;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public AccountResponse createAccount(AccountRequest accountRequest) {
		Account account = new Account(accountRequest);
		if (accountRepository.findByColumn(Account_.USERNAME, accountRequest.getUsername()) != null) {
			throw new BookingreserException(HttpStatus.CONFLICT, "Username already exist!!!");
		}
		account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
		account.setRoles(roles(accountRequest.getRoles()));
		accountRepository.save(account);
		var jwtToken = jwtTokenProvider.generateToken(account);
		return AccountResponse.builder().accessToken(jwtToken).build();
	}

	@Override
	public AccountResponse login(AccountRequest accountRequest) {
		Account account = accountRepository.findByColumn(Account_.USERNAME, accountRequest.getUsername());
		if (account == null) {
			throw new BookingreserException(HttpStatus.NOT_FOUND, "Username or password incorrect");
		}
		String accessToken = jwtTokenProvider.generateToken(account);
		return AccountResponse.builder().accessToken(accessToken).build();
	}

	@Override
	public void updateAccountRole(AccountRequest accountRequest) {
		Account account = accountRepository.findByColumn(Account_.USERNAME, accountRequest.getUsername());
		account.setRoles(roles(accountRequest.getRoles()));
		accountRepository.update(account);
	}

	public Set<Role> roles(List<Long> roleIds) {
		Set<Role> roles = new HashSet<>();
		roleIds.stream().forEach(x -> roles.add(roleRepository.findById(x)));
		return roles;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		Account account = accountRepository.findByColumn(Account_.USERNAME, username);
		if (account == null) {
			throw new BookingreserException(HttpStatus.BAD_REQUEST, "Username or password don't correct");
		}
		return new User(account.getUsername(), account.getPassword(), account.getAuthorities());
	}
}
