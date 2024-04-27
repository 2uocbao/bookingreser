package com.quocbao.bookingreser.security.config;

import static com.quocbao.bookingreser.util.Permission.ADMIN;
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
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

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
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(cf -> cf.disable());
		http.anonymous(ano -> ano.disable());
		http.authorizeHttpRequests(authorize -> authorize
				
				.requestMatchers(HttpMethod.OPTIONS).permitAll()
				
				.requestMatchers("/anonymous*").anonymous()
				
				.requestMatchers("/account/**").permitAll()
				
				.requestMatchers(GET, "/company/**").permitAll()
				.requestMatchers("/company/**").hasRole(ADMIN.toString())

				.requestMatchers(GET, "/employee/**").hasRole(ADMIN.toString())
				.requestMatchers(PUT, "/employee/**").hasAnyRole(ADMIN.toString(), STAFF.toString())
				.requestMatchers("/employee/**").hasAnyRole(ADMIN.toString())

				.requestMatchers(GET, "/foods/**").permitAll()
				.requestMatchers("/foods/**").hasAnyRole(ADMIN.toString())

				.requestMatchers("/material/**").hasAnyRole(ADMIN.toString())

				.requestMatchers(GET, "/orders/**").hasAnyRole(USER.toString(), ADMIN.toString(), STAFF.toString())
				.requestMatchers("/orders/**").hasAnyRole(ADMIN.toString(), STAFF.toString())

				.requestMatchers("/payment/**").hasAnyRole(ADMIN.toString(), STAFF.toString(), USER.toString())

				.requestMatchers(GET, "/rated/**").permitAll()
				.requestMatchers(DELETE, "/rated/**").hasAnyRole(ADMIN.toString(), STAFF.toString())
				.requestMatchers("/rated/**").hasRole(USER.toString())

				.requestMatchers("/report/**").hasRole(ADMIN.toString())
				
				.requestMatchers("/reservation/company/**").hasAnyRole(ADMIN.toString(), STAFF.toString())
				.requestMatchers("/reservation/user/**").hasRole(USER.toString())
				.requestMatchers("/reservation/**").hasAnyRole(ADMIN.toString(), STAFF.toString(), USER.toString())
				
				.requestMatchers("/role/**").hasRole(ADMIN.toString())
				
				
				.requestMatchers(POST, "/service/**").hasAnyRole(ADMIN.toString())
				.requestMatchers(GET, "/service/**").hasAnyRole(ADMIN.toString(), STAFF.toString(), USER.toString())
				
				.requestMatchers("/types/**").hasRole(ADMIN.toString())
				
				.requestMatchers("/user/**").hasRole(USER.toString())
				
				
				.requestMatchers("/warehouse/**").hasAnyRole(ADMIN.toString(), ADMIN_WAREHOUSE.toString())
				
				.anyRequest().authenticated());
		
		http.logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
				.logoutSuccessHandler(logoutSuccessHandler()));
		http.authenticationProvider(authenticationProvider).addFilterBefore(jwtAuthenticationFilter,
				UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling(handling -> handling.accessDeniedHandler(accessDeniedException()));
		return http.build();
	}

    @Bean
    LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}

    @Bean
    AccessDeniedHandler accessDeniedException() {
    	return new CustomAccessDeniedHandler();
    }
    
}
