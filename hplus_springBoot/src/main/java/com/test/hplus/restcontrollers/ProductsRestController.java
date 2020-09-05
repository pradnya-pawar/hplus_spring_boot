package com.test.hplus.restcontrollers;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;

//@Controller
@RestController  //controller and repsonsebody 
public class ProductsRestController {
	
	@Autowired
	private ProductRepository productRepository;
	
	/*
	 * @GetMapping("/hplus/rest/products")//http://localhost:8080/hplus/rest/
	 * products
	 * 
	 * @ResponseBody //will tell to spring mvc that return type of the method is
	 * supposed to represent the body of response//no longer view name not needed
	 * public List<Product> getProducts() {
	 * 
	 * List<Product> products = new ArrayList();
	 * productRepository.findAll().forEach(product -> products.add(product)); return
	 * products; }
	 */
	
	//@ResponseEntity ----//send the information back to client abt the request even though product does not exist it will give u 200 and body will be empty.To avoid this we use reponseEntity

	@GetMapping("/hplus/rest/products")//http://localhost:8080/hplus/rest/products
	//@ResponseBody //will tell to spring mvc that return type of the method is supposed to represent the body of response//no longer view name not needed
	public ResponseEntity getProductsByRequestParam(@RequestParam("name") String name)
	{
		
		List<Product> products = new ArrayList();
		productRepository.searchByName(name);
		return new  ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@GetMapping("/hplus/rest/products/{name}")
	public ResponseEntity getProductsByPathVariable(@PathVariable("name") String name)
	{
		
		List<Product> products = new ArrayList();
		productRepository.searchByName(name);
		return new  ResponseEntity<>(products,HttpStatus.OK);
	}
	
	//@RequestBody--Form JSon data gets converted into java object --Represents request body
}
