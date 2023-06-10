package com.quocbao.bookingreser.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.quocbao.bookingreser.security.CustomAuthenticationFailureHandler;
import com.quocbao.bookingreser.security.CustomAuthenticationProvider;
import com.quocbao.bookingreser.security.CustomLogoutSuccessHandler;
import com.quocbao.bookingreser.security.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@ComponentScan("com.quocbao.booking.security")
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final CustomAuthenticationProvider authenticationProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(cf -> cf.disable());
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/anonymous*").anonymous()
				.requestMatchers("/payment/**").permitAll()
				.requestMatchers("/account/**").permitAll()
				.requestMatchers("/company/**").hasRole("ADMIN")
				.requestMatchers("/").hasRole("ADMIN")
				.requestMatchers("/employee/**").hasRole("employee")
				.anyRequest().authenticated());
		http.logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
				.logoutSuccessHandler(logoutSuccessHandler()));
		http.authenticationProvider(authenticationProvider).addFilterBefore(jwtAuthenticationFilter,
				UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
}
