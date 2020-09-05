package com.test.hplus.beans;
import java.util.Date;

//JSR 380 validation PAI is a standard approach to apply validation in Spring... In spring boot this validation is available in org.hibernate validator 
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.bytebuddy.implementation.auxiliary.AuxiliaryType.SignatureRelevant;

@Entity
public class User {
	
	@Id
	private int id;
	@Size(min=6,message= "{username.cannot.be.empty}")//localizing error msg with properties file
	private String username;
	
	//@Pattern(regexp="(?=.*[A-Z].{6,10})",message="Password should atleast contain one upper case and lower case")
	private String password;
	@Enumerated(EnumType.STRING)//By default gender will get stored in Ordinal value(0,1,2) default .In order to save it in String we will use Enumrated
	private Gender gender;
	
	@NotNull(message="Activity can not be null")
	private String activity;
	
	@NotEmpty(message="First name can not be left empty")
	private String firstName;
	
	private String lastName;
	
	//Required for converting complex data types into java models.@modelAttribute wpuld not have donr from string to date binding/To solve this problem we came up with binder
		//To enable binders we will use @InitBinder.PropertyEditor instance enabled via @InitBinder
	private Date dateOfBirth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

}
