package com.test.hplus.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;

@ControllerAdvice
public class DefaultModelAttributeController { //whenever all the validation get passed property is not getting fetched properly 
	
	  @ModelAttribute("newuser")
	  public User getDefaultUser()
	  {
		  return new User();//It will return default user so that jsp is rendered correctly with the help of modelAttribute
	  }
	  
	  @ModelAttribute("genderItems") //default values will get rendered on JSP page
	  public List<String> getGenderItems()
	  {
		  return Arrays.asList(new String[] {"Male","Female","Other"});//It will return default user so that jsp is rendered correctly with the help of modelAttribute
	  }
	  
	  @ModelAttribute("login") //default values will get rendered on JSP page
	  public Login getDefaultLogin()
	  {
		  return new Login();//It will return default user so that jsp is rendered correctly with the help of modelAttribute
	  }

}
