package org.musicalpatriots.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	// Show login page
	@RequestMapping("/login/signin")
	public String showLoginPage() {
		
		return "userlogin";
		
	}
	
	// Show create new user
	
	// Process new user
	
}
