package com.test.hplus.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import com.test.hplus.exception.LoginFailureException;
import com.test.hplus.repository.UserRepository;

@RestController
public class LoginRestController {
	
	@Autowired
	private UserRepository userepository;
	
	
	@PostMapping("/hplus/rest/loginuser")
	public ResponseEntity getLoginDetails(@RequestBody Login login) throws LoginFailureException
	{
		System.out.println("User credentials are "+login.getUsername()+ " Password is "+login.getPassword());
		User user=userepository.searchByname(login.getUsername());
		
		if(user==null)
		{
			//return ResponseEntity.status(404).build(); //to send 404 to client
			return new ResponseEntity<>("User not found ",HttpStatus.NOT_FOUND);
		}
		
		if(user.getUsername().equals(login.getUsername()) &&
				
				user.getPassword().equals(login.getPassword()))
				{
				return new ResponseEntity<>("welcome "+login.getUsername(),HttpStatus.OK);
				}
		else
		{
			throw new LoginFailureException("Invalid Username or password");
		}
		
	}
	

}
