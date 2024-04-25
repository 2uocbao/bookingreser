package com.quocbao.bookingreser.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.quocbao.bookingreser.exception.ValidationException;
import com.quocbao.bookingreser.service.AccountService;

@Component
@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private AccountService accountService;

	@Override
	public Authentication authenticate(Authentication authentication) {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		UserDetails userDetails = accountService.loadUserByUsername(username);
		if (passwordEncoder().matches(password, userDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(),
					userDetails.getAuthorities());
		} else {
			throw new ValidationException("Username or password don't correct");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
