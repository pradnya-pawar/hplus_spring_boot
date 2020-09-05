package com.test.hplus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;

@Controller
public class SearchController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/search")
	public String goToSearch(@RequestParam("search") String search ,Model model)
	{
		//Requestparam-We should expect "search" in upcoming request
		//Model-Any information we need to display on page after returning value can be put model attribute
		System.out.println("Inside search Controller");
		System.out.println("Search parameter"+search);
		List<Product> products= new ArrayList();
		products=productRepository.searchByName(search);
		model.addAttribute("products",products);
		return "search";//with this you are just returning view name not attribute data to be rendered on jsp page
	}
}
