package com.quocbao.bookingreser.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quocbao.bookingreser.entity.Account;
import com.quocbao.bookingreser.entity.Role;
import com.quocbao.bookingreser.entity.metamodel.Account_;
import com.quocbao.bookingreser.exception.AlreadyExistException;
import com.quocbao.bookingreser.exception.NotFoundException;
import com.quocbao.bookingreser.repository.AccountRepository;
import com.quocbao.bookingreser.repository.RoleRepository;
import com.quocbao.bookingreser.request.AccountRequest;
import com.quocbao.bookingreser.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	RoleRepository roleRepository;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public void createAccount(AccountRequest accountRequest) {
		Account account = new Account(accountRequest);
		if (accountRepository.findByColumn(Account_.USERNAME, accountRequest.getUsername()) != null) {
			throw new AlreadyExistException("Username already exit");
		}
		account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
		account.setRoles(roles(accountRequest.getRoles()));
		accountRepository.save(account);
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByColumn(Account_.USERNAME, username);
		if (account == null) {
			throw new NotFoundException("Username or password incorrect");
		}
		return new User(account.getUsername(), account.getPassword(), getAuthorities(account.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).toList();
	}

}
