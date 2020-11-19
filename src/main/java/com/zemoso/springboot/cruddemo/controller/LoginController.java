package com.zemoso.springboot.cruddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login(Model model) {

		return "login";
	}
	
	// mapping for access denied
		@GetMapping("/access-denied")
		public String showAcessDenied() {
			
			return "access-denied";
			
		}
}
