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

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import static com.quocbao.bookingreser.util.Permission.ADMIN;
import static com.quocbao.bookingreser.util.Permission.STAFF;
import static com.quocbao.bookingreser.util.Permission.USER;

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
				
				.requestMatchers("/account/**").permitAll()
				
				.requestMatchers("/company/**").hasRole(ADMIN.getPermission())

				.requestMatchers("/employee/**").hasRole(ADMIN.getPermission())
				.requestMatchers(GET, "/employee/**").hasRole(STAFF.getPermission())
				.requestMatchers(PUT, "/employee/**").hasRole(STAFF.getPermission())

				.requestMatchers(GET, "/food/**").permitAll()
				.requestMatchers("/food/**").hasAnyRole(ADMIN.getPermission(), STAFF.getPermission())

				.requestMatchers("/material/**").hasRole(ADMIN.getPermission())

				.requestMatchers(GET, "/order/**").hasRole(USER.getPermission())
				.requestMatchers(POST, "/order/**").hasRole(USER.getPermission())
				.requestMatchers("/order/**").hasAnyRole(STAFF.getPermission(), ADMIN.getPermission())

				.requestMatchers("/payment/**").hasAnyRole(STAFF.getPermission(), USER.getPermission())

				.requestMatchers("/rated/**").hasRole(USER.getPermission())
				.requestMatchers(GET, "/rated/**").permitAll()
				.requestMatchers(DELETE, "/rated/**").hasAnyRole(STAFF.getPermission())

				.requestMatchers("/report/**").hasRole(ADMIN.getPermission())

				.requestMatchers("/reservation/byCompany/**").hasRole(ADMIN.getPermission())
				.requestMatchers("/reservation/byUser/**").hasRole(USER.getPermission())
				.requestMatchers("/reservation/**").hasAnyRole(STAFF.getPermission(), USER.getPermission())
				
				.requestMatchers("/role/**").hasRole(ADMIN.getPermission())
				
				.requestMatchers(POST, "/service/**").hasRole(ADMIN.getPermission())
				.requestMatchers(GET, "/service/**").hasAnyRole(STAFF.getPermission(), USER.getPermission())
				
				.requestMatchers("/type/**").hasRole(ADMIN.getPermission())
				
				.requestMatchers("/user/**").hasRole(USER.getPermission())
				
				.requestMatchers("/warehouse/**").hasRole(ADMIN.getPermission())
				
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
