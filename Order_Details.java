package com.shopping.dto;

import java.time.LocalDate;

public class Order_Details {

	private int order_id;
	private int customer_id;
	private int product_id;
	private int product_quantity;
	private String order_address;
	private LocalDate order_date;
	
	
	public Order_Details() {
		// TODO Auto-generated constructor stub
	}


	public Order_Details(int order_id, int customer_id, int product_id, int product_quantity, String order_address,
			LocalDate order_date) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.product_quantity = product_quantity;
		this.order_address = order_address;
		this.order_date = order_date;
	}

	public int getOrder_id() {
	return order_id;
}


public void setOrder_id(int order_id) {
	this.order_id = order_id;
}


public int getCustomer_id() {
	return customer_id;
}


public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}


public int getProduct_id() {
	return product_id;
}


public void setProduct_id(int product_id) {
	this.product_id = product_id;
}


public int getProduct_quantity() {
	return product_quantity;
}


public void setProduct_quantity(int product_quantity) {
	this.product_quantity = product_quantity;
}


public String getOrder_address() {
	return order_address;
}


public void setOrder_address(String order_address) {
	this.order_address = order_address;
}


public LocalDate getOrder_date() {
	return order_date;
}


public void setOrder_date(LocalDate order_date) {
	this.order_date = order_date;
}


	@Override
	public String toString()
	{
		return " Order id :"+getOrder_id()+" \n Customer id :"+getCustomer_id()+ " \n product id :"+getProduct_id()
		+" \n product quantity : "+getProduct_quantity()+" \n order date :"+getOrder_date()+" \n order address :"+getOrder_address();
	}
	
	
}
