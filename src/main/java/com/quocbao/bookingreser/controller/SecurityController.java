package com.quocbao.bookingreser.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookingreser")
public class SecurityController {

	@GetMapping("/login")
	public String login(Model model, CsrfToken token) {
		// the token will be injected automatically
		return "/templates/login";
	}
}
