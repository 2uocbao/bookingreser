package com.quocbao.bookingreser.sercurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.quocbao.bookingreser.sercurity.CustomAuthenticationFailureHandler;
import com.quocbao.bookingreser.sercurity.CustomLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan("com.quocbao.bookingreser.sercurity")
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
					.requestMatchers("/anonymous*").anonymous()
					.requestMatchers("/company/**").hasRole("ADMIN")
					.requestMatchers("/admin").hasRole("ADMIN")
					.requestMatchers("/employee/**").hasRole("employee")
					.anyRequest().authenticated()
					)
			.formLogin(login -> login
//					.loginPage("/login.html")
//					.usernameParameter("username")
//					.passwordParameter("password")
//					.loginProcessingUrl("/process_login")
//					.defaultSuccessUrl("/homepage.html", true)
//					.failureUrl("/login?error=true")
					.failureHandler(authenticationFailureHandler())
					)
			.logout(logout -> logout
					.logoutSuccessUrl("/login?logout=true")
					.logoutSuccessHandler(logoutSuccessHandler())
					.permitAll()
					)
			;
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
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
			throws Exception{ 
		return authenticationConfiguration.getAuthenticationManager();	
	}
}
