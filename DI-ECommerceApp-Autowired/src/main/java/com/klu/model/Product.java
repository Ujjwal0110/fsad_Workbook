package com.klu.model;

import org.springframework.stereotype.Component;

//@Value(4)
@Component
public class Product {
	private int productId;
	private String productName;
	private double price;
	private String category;
	
	public Product() {
		this.productId = 101;
		this.productName = "HP";
		this.price = 51000.00;
		this.category = "Electronics";
	}
	
	public int getProductID() {
		return productId;
	}
	
	public String getProductName() { 
	return productName;
	}
	
	public double getPrice() { 
	return price;
	}
	
	public String getCategory() { 
	return category;
	}

}
