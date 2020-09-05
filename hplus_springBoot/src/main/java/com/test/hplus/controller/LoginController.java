package com.test.hplus.controller;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;

@Controller
@SessionAttributes("login") //login is module attribute inside login.jsp
//also make sure hat before writing this sessionAttribute ,modelAttribute should be present inside controller like @modelAttribute which is there in defaultModelAttributeController 
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login) {
		User user=userRepository.searchByname(login.getUsername());
		if(user==null)
		{
			throw new com.test.hplus.exception.ApplicationException("User Not found");
		}
		return "forward:/userprofile"; //forwarding control from login to userProfile
	}
	
	/*
	 * @ExceptionHandler(com.test.hplus.exception.ApplicationException.class)//to
	 * tellthat this class exception has to be handled public String
	 * exceptionHandler() { System.out.println("In Login Controller of Exception");
	 * return "error"; }
	 */

}
