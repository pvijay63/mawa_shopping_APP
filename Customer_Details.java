package com.shopping.dto;

public class Customer_Details {

	private int customer_id;
	private String customer_name;
	private String customer_email_id;
	private long customer_mob_num;
	private String customer_address;
	private String password;
	private String customer_gender;
	
	public Customer_Details() {
		// TODO Auto-generated constructor stub
	}

	
	public Customer_Details(int customer_id, String customer_name, String customer_email_id, long customer_mob_num,
			String customer_address, String password, String customer_gender) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_email_id = customer_email_id;
		this.customer_mob_num = customer_mob_num;
		this.customer_address = customer_address;
		this.password = password;
		this.customer_gender = customer_gender;
	}


	public String getCustomer_gender() {
		return customer_gender;
	}


	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
	}

public void setCustomer_id(int id )
{
	this.customer_id=id;
}
	
	public int getCustomer_id() {
		return customer_id;
	}

	

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email_id() {
		return customer_email_id;
	}

	public void setCustomer_email_id(String customer_email_id) {
		this.customer_email_id = customer_email_id;
	}

	public long getCustomer_mob_num() {
		return customer_mob_num;
	}

	public void setCustomer_mob_num(long customer_mob_num) {
		this.customer_mob_num = customer_mob_num;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString()
	{
		return "Customer id : "+getCustomer_id()+" \n customer_email : "+getCustomer_email_id()+" \n customer MobNo :"+getCustomer_mob_num()
		+"\n customer Address :"+getCustomer_address();
	}
	
	
	
}
