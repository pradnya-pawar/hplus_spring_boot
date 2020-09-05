package com.test.hplus.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;

@Controller
public class RegistrationController {
	
	
	
	@Autowired 
	private UserRepository userRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, "dateOfBirth",new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"), true));
	}
	//@valid-To tell Spring container that,we are carrying out validation in Spring beans with the help of JSR 380,so accordingly you also check for validation before carrying out any activity
	//BindingResult=If some of the spring validation failed,then to throw an errro we use BindingResult
	@PostMapping("/registeruser")
	public String registerUser(@Valid @ModelAttribute("newuser") User user,BindingResult result,Model model) //@modelAttribute enabeling data binding between jsp and java.IN jsp see user form data where u will find newuser
	{
		System.out.println("We r in Registration Controller");
		if(result.hasErrors())
		{
			return "register";//If any error then return view to register.jsp
		}
		userRepository.save(user);
		model.addAttribute("dataSaved", "User registred Successfully");
		return "login";
	}

}
