package com.test.hplus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		
		System.out.println("Ending the session");
		session.invalidate(); //to end the session
		//System.out.println("Session Attribute"+ session.getAttribute("login"));
		return "login";
		
	}

}
