package com.quocbao.bookingreser.sercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.quocbao.bookingreser.exception.AlreadyExistException;
import com.quocbao.bookingreser.service.AccountService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private final AccountService accountService;

	BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

	public CustomAuthenticationProvider(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		UserDetails userDetails = accountService.loadUserByUsername(username);
		if (cryptPasswordEncoder.matches(password, userDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(),
					userDetails.getAuthorities());
		} else {
			throw new AlreadyExistException("Invalid username or password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
