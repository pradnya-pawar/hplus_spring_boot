package com.test.hplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.hplus.beans.Login;

@Controller
public class UserProfileController {

	//we are creating thos controller because session should be available from one controller to another when it traverse.
	//FRom login to profile session should be available 
	//and to fetch session attribute 
	@PostMapping("/userprofile") //@sessionAttribute should be same as module attribute of login.jsp
	public String getUserProfile(@SessionAttribute("login") Login login,Model model)
	{
		System.out.println("Inside user profile controller");
		System.out.println("username from session "+login.getUsername());
		model.addAttribute("username",login.getUsername());
		//you can use repository and get all user details and show it on jsp page
		return "profile";
	}
}
