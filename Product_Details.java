package com.shopping.dto;

import java.sql.Date;

public class Product_Details {

	private int product_id;
	private String product_name;
	private String product_brand;
	private double product_price;
	private Date product_M_F_date;
	private Date product_Ex_date;
	private int product_quantity;
	private String product_category;
	private double pproduct_discount;
	
	public Product_Details() {
		// TODO Auto-generated constructor stub
	}

	public Product_Details(int product_id, String product_name, String product_brand, double product_price,
			Date product_M_F_date, Date product_Ex_date, int product_quantity, String product_category,
			double pproduct_discount) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_brand = product_brand;
		this.product_price = product_price;
		this.product_M_F_date = product_M_F_date;
		this.product_Ex_date = product_Ex_date;
		this.product_quantity = product_quantity;
		this.product_category = product_category;
		this.pproduct_discount = pproduct_discount;
	}

	public int getProduct_id() {
		return product_id;
	}
    public void setProduct_id(int product_id)
  {
	 this.product_id=product_id;
  }
	

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public Date getProduct_M_F_date() {
		return product_M_F_date;
	}

	public void setProduct_M_F_date(Date product_M_F_date) {
		this.product_M_F_date = product_M_F_date;
	}

	public Date getProduct_Ex_date() {
		return product_Ex_date;
	}

	public void setProduct_Ex_date(Date product_Ex_date) {
		this.product_Ex_date = product_Ex_date;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public double getproduct_discount() {
		return pproduct_discount;
	}

	public void setproduct_discount(double pproduct_discount) {
		this.pproduct_discount = pproduct_discount;
	}
	
	@Override
	public String toString()
	{
		return " product id : "+getProduct_id()+"\n product name :"+getProduct_name()+" \n product price :"+getProduct_price()
		+"\n product_discount : "+getproduct_discount();
	}
	
}
