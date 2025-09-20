package com.shopping.dto;

import java.time.LocalDate;

public class Payment_Details {

	private String payment_type;
	private String payment_status;
	private double amount;
	private LocalDate payment_date;
	private int customer_id;
	private int product_id;
	
	
	public Payment_Details(String payment_type, String payment_status, double amount, LocalDate payment_date,
			int customer_id, int product_id) {
		super();
		this.payment_type = payment_type;
		this.payment_status = payment_status;
		this.amount = amount;
		this.payment_date = payment_date;
		this.customer_id = customer_id;
		this.product_id = product_id;
	}

	public Payment_Details() {
		// TODO Auto-generated constructor stub
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

	public void setPayment_date(LocalDate payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPayment_date() {
		return payment_date;
	}

	@Override
	public String toString()
	{
		return "Payment type :"+getPayment_type()+" \n payment status "+getPayment_status()
		+"\n amount :"+getAmount()+" \n payment date : "+getPayment_date();
	}
	
}
