package com.quocbao.bookingreser;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
public class BookingreserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingreserApplication.class, args);
	}

	@PostConstruct
	public void init() {
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+7"));
	}
}
