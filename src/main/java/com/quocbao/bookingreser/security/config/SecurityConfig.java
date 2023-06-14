package com.quocbao.bookingreser.security.config;

import static com.quocbao.bookingreser.util.Permission.ADMIN;
import static com.quocbao.bookingreser.util.Permission.ADMIN_KITCHEN;
import static com.quocbao.bookingreser.util.Permission.ADMIN_STAFF;
import static com.quocbao.bookingreser.util.Permission.ADMIN_WAREHOUSE;
import static com.quocbao.bookingreser.util.Permission.STAFF;
import static com.quocbao.bookingreser.util.Permission.USER;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

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
				
				.requestMatchers("/account/**").permitAll()
				
				.requestMatchers("/company/**").hasRole(ADMIN.toString())

				.requestMatchers("/employee/**").hasAnyRole(ADMIN.toString(), ADMIN_KITCHEN.toString(), ADMIN_STAFF.toString(), ADMIN_WAREHOUSE.toString())
				.requestMatchers(GET, "/employee/**").hasRole(STAFF.toString())
				.requestMatchers(PUT, "/employee/**").hasRole(STAFF.toString())

				.requestMatchers(GET, "/food/**").permitAll()
				.requestMatchers("/food/**").hasAnyRole(ADMIN.toString(), ADMIN_KITCHEN.toString())

				.requestMatchers("/material/**").hasAnyRole(ADMIN.toString(), ADMIN_KITCHEN.toString())

				.requestMatchers(GET, "/order/**").hasRole(USER.toString())
				.requestMatchers(POST, "/order/**").hasRole(USER.toString())
				.requestMatchers("/order/**").hasAnyRole(STAFF.toString(), ADMIN_STAFF.toString())

				.requestMatchers("/payment/**").hasAnyRole(ADMIN.toString(), ADMIN_STAFF.toString(), STAFF.toString(), USER.toString())

				.requestMatchers("/rated/**").hasRole(USER.toString())
				.requestMatchers(GET, "/rated/**").permitAll()
				.requestMatchers(DELETE, "/rated/**").hasAnyRole(ADMIN_STAFF.toString(), STAFF.toString())

				.requestMatchers("/report/**").hasRole(ADMIN.toString())

				.requestMatchers("/reservation/byCompany/**").hasAnyRole(ADMIN.toString(), ADMIN_STAFF.toString())
				.requestMatchers("/reservation/byUser/**").hasRole(USER.toString())
				.requestMatchers("/reservation/**").hasAnyRole(ADMIN_STAFF.toString(), STAFF.toString(), USER.toString())
				
				.requestMatchers("/role/**").hasRole(ADMIN.toString())
				
				.requestMatchers(POST, "/service/**").hasAnyRole(ADMIN.toString(), ADMIN_STAFF.toString())
				.requestMatchers(GET, "/service/**").hasAnyRole(ADMIN_STAFF.toString(), STAFF.toString(), USER.toString())
				
				.requestMatchers("/type/**").hasRole(ADMIN.toString())
				
				.requestMatchers("/user/**").hasRole(USER.toString())
				
				.requestMatchers("/warehouse/**").hasAnyRole(ADMIN.toString(), ADMIN_WAREHOUSE.toString())
				
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
