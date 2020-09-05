package com.test.hplus.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Which will tell that this product bean is correspond to product table in
		// mysql server
public class Product {
	@Id //Primary key of the Prodcut table
	private int id;
	private String name;
	private String imagePath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
