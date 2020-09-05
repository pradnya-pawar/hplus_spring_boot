package com.test.hplus.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String goHome()
	{
		System.out.println("We r in HomeController");
		return "index";//View Name is Index.jsp
		//Dispatcher servlet work with viewResolver and resolve that to this index.jsp template
		
	}
	

	  @GetMapping("/goToSearch") 
	  public String goToSearch() { //Requestparam-We should expect "search" in
	  //upcoming request //Model-Any information we need to display on page after
	  //returning value can be put model attribute
	  System.out.println("Inside search Controller");
	 
	  return "search";//with this
	  //you are just returning view name not attribute data to be rendered on jsp page 
	  }
	 
	  @GetMapping("/goToLogin")
		public String goToLogin()
		{
			System.out.println("We r in Login ");
			return "login";//View Name is Index.jsp
			//Dispatcher servlet work with viewResolver and resolve that to this index.jsp template
			
		}
	  @GetMapping("/goToRegistration")
		public String goToRegistration()
		{
			System.out.println("We r in Registration");
			return "register";//View Name is Index.jsp
			//Dispatcher servlet work with viewResolver and resolve that to this index.jsp template
			
		}
	  
	/*
	 * @ModelAttribute("newuser") public User getDefaultUser() { return new
	 * User();//It will return default user so that jsp is rendered correctly with
	 * the help of modelAttribute }
	 * 
	 * @ModelAttribute("genderItems") //default values will get rendered on JSP page
	 * public List<String> getGenderItems() { return Arrays.asList(new String[]
	 * {"Male","Female","Other"});//It will return default user so that jsp is
	 * rendered correctly with the help of modelAttribute }
	 * 
	 * @ModelAttribute("login") //default values will get rendered on JSP page
	 * public Login getDefaultLogin() { return new Login();//It will return default
	 * user so that jsp is rendered correctly with the help of modelAttribute }
	 */
   
	/*
	 * @GetMapping("/search") public ModelAndView search() {
	 * System.out.println("Inside search Controller"); ModelAndView model = new
	 * ModelAndView(); model.setView("search"); return model; //with this you can
	 * return data as well as view model.addObject(attributeValue) return
	 * "search"; }
	 */
}
