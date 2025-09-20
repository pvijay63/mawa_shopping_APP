package com.shopping.dto;

public class Cart_Details {

	private int cart_id;
	private int product_id;
	private int customer_id;
	private int product_quantity;
	
	public Cart_Details() {
		// TODO Auto-generated constructor stub
	}

	public Cart_Details(int cart_id, int product_id, int customer_id, int product_quantity) {
		super();
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.product_quantity = product_quantity;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id)
	{
		this.cart_id=cart_id;
	}

	public int getProduct_id() {
		return product_id;
	}

   public void setProduct_id(int product_id)
   {
	   this.product_id=product_id;
   }
	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customerid)
	{
		this.customer_id=customerid;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	
	
	@Override
	public String toString()
	{
		return "Cart id :"+getCart_id()+" \n product id :"+getProduct_id()+
				" \n customer id : "+getCustomer_id()+"  \n poduct  quantity : "+getProduct_quantity();
	}

	
	
}
