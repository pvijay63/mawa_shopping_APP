package com.shopping.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.jws.Oneway;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;

import com.shopping.dao.CartDao;
import com.shopping.dao.CustomerDao;
import com.shopping.dto.Cart_Details;
import com.shopping.dto.Customer_Details;
import com.shopping.dto.Order_Details;
import com.shopping.dto.Payment_Details;
import com.shopping.dto.Product_Details;
import com.shopping.exception.CustomerDataInvalidException;
import com.shopping.util.JDBCConnection;

public class CustomerService {
	
	OrderService orderService=new OrderService();
	PaymentService paymentService=new PaymentService();
	CartService cartService=new CartService();
	Customer_Details customer_Details=new Customer_Details();
    ProductService productService=new ProductService();
	CustomerDao customerdao=new CustomerDao();
	Scanner s=new Scanner(System.in);
	private Customer_Details c_id;
	public void customerRegistration() 
	{
		List<Customer_Details>listofcustomers=customerdao.selectAllCustomerDetails();
		System.out.println("enter customer name ");
		String cname=s.next();
		System.out.println("enter customer gender");
		String cgender=s.next();
		System.out.println("enter customer email id");
		String cemailid=s.next();
		boolean b=true;
		final String emailid=cemailid;
		long emailcount =listofcustomers.stream().filter((customer) ->customer.getCustomer_email_id().equals(emailid))
				.count();
		
		while(b)
		{
			
		try {
			if(emailcount>0)
			{
				throw new CustomerDataInvalidException("Email already existed") ;
			}
		if(!cemailid.contains("@gmail.com"))
		{	
			throw new CustomerDataInvalidException("Invalid email id");
		}
		else
		{
			b=false;
			
		}
		}
		catch(CustomerDataInvalidException e)
		{
			System.out.println("re enter valid email id");
			cemailid=s.next();
		}
		}
		System.out.println("enter email password");
		String cpassword=s.next();
		final String pass=cpassword;
		long passwordcount=listofcustomers.stream().filter((c)->c.getPassword().equals(pass)).count();
		try {
		if(passwordcount>0)
		{
			throw new CustomerDataInvalidException("Password already existed");
		}
		}
		catch(CustomerDataInvalidException e)
		{
			System.out.println("Re- enter password it is already existed ");
			cpassword=s.next();
		}
		System.out.println("Enter mobile number");
		long cmobilenumber=s.nextLong();
		final long  mobile= cmobilenumber;
		long mobilenumberCount =listofcustomers.stream().filter((c)->c.getCustomer_mob_num()==mobile).count();
		boolean a=true;
			while(a)
			{
			try {
				if(mobilenumberCount>0)
				{
					throw new CustomerDataInvalidException("Mobile number already existed");
				}
			 if(!(cmobilenumber>=6000000000l && cmobilenumber<=9999999999l))
			 {
					throw new CustomerDataInvalidException("Invalid mobilenumber");
			 }
			 else
			 {
				 a=false;
			 }
			}
			catch(CustomerDataInvalidException e)
			{
				System.out.println("re-enter valid mobile number");
				 cmobilenumber= s.nextLong();
			}
			}
		s.nextLine();
		System.out.println("enter customer address");
		String caddress=s.nextLine();
		Customer_Details c=new Customer_Details();
		c.setCustomer_name(cname);
		c.setCustomer_email_id(cemailid);
		c.setPassword(cpassword);
		c.setCustomer_mob_num(cmobilenumber);
		c.setCustomer_address(caddress);
		if(customerdao.insertCustomerDetails(c))
		{
			System.out.println(cname+" registered successfully");
		}
		else
		{
			System.out.println("server 500");
		}
		
		
	}
	
	public void customer_Login()
	{
		System.out.println("Enter the customer emailid OR Mobilenumber");
		String emailidormobilenumber=s.next();
		System.out.println("Enter the password");
		String password=s.next();
		Customer_Details c=customerdao.selectCustomerDetailsByUsingEmailidOrMobileNumberANdPassword(emailidormobilenumber, password);
		if(customerdao!=null)
		{
			System.out.println("Login successfully");
			
			
			if(c.getCustomer_gender().equalsIgnoreCase("male"))
			{
				System.out.println("Heloo  Mr   "+c.getCustomer_name());
				this.c_id=c;
				customerOperations();
			}
			if(c.getCustomer_gender().equalsIgnoreCase("female")) {
		    	System.out.println("Heloo  Mrs  "+c.getCustomer_name());
		    	this.c_id=c;
		    	customerOperations();
		    	
		    	
			}
		    
		}
		else
		{
			System.out.println("Invalid emailid or password");
		}
	}
	
	public void customerOperations() {
		System.out.println("enter \n 1.To All product details \n 2.My Cart details \n 3.My Order details");
		switch (s.nextInt()) {
		case 1:
			System.out.println("All product details");
			List<Product_Details>listOfProducts=productService.getAllProductDetails();
			int sno=1;
			for (Product_Details product_Details : listOfProducts) {
				System.out.println("S.NO :"+sno);
				System.out.println("Product Name :"+product_Details.getProduct_name());
				System.out.println("Product brand :"+product_Details.getProduct_brand());
				System.out.println("Product Price :"+product_Details.getProduct_price());
				System.out.println("Product Category :"+product_Details.getProduct_category());
				System.out.println("Product Manufacture Date :"+product_Details.getProduct_M_F_date());
				System.out.println("Product Expiry date : "+product_Details.getProduct_Ex_date());
				System.out.println("****-----*****-----*****------*****");
				sno++;
			}
			System.out.println("Enter a S.NO to add to Cart or Buy");
            Product_Details product_Details =productService.getAllProductDetails().get(s.nextInt()-1);
            System.out.println("Product Name :"+product_Details.getProduct_name());
			System.out.println("Product brand :"+product_Details.getProduct_brand());
			System.out.println("Product Price :"+product_Details.getProduct_price());
			System.out.println("Product Category :"+product_Details.getProduct_category());
			System.out.println("Product Manufacture Date :"+product_Details.getProduct_M_F_date());
			System.out.println("Product Expiry date : "+product_Details.getProduct_Ex_date());
			System.out.println("****-----*****-----*****------*****");
			
			
			System.out.println("Enter \n 1. To add product to cart \n 2. To Buy");
			switch (s.nextInt()) {
			case 1:
				System.out.println("To add the Product In cart");
				System.out.println("Enterr product quantity");
				int quantity =s.nextInt();
				Cart_Details cart_Details=new Cart_Details();
				cart_Details.setProduct_id(product_Details.getProduct_id());
				cart_Details.setCustomer_id(c_id.getCustomer_id());
				cart_Details.setProduct_quantity(quantity);
				cartService.addCartDetails(cart_Details);
				break;
			case 2:
				System.out.println("To Buy");
				System.out.println("To Buy Product");
				System.out.println("Enter the product Quantity");
				int quantityy = s.nextInt();
				System.out.println("Product Name : " + product_Details.getProduct_name() + "\nProduct Brand : "
						+ product_Details.getProduct_brand() + "\nProduct Category : " + product_Details.getProduct_category()
						+ "\nProduct Price : " + product_Details.getProduct_price());
				double tp = product_Details.getProduct_price() * quantityy;
				System.out.println("Total price : " + tp);
				double dp = product_Details.getProduct_price() * (0.01 * product_Details.getproduct_discount()) * quantityy;
				System.out.println("Discount Price : " + dp);
				double ta=tp-dp;
				System.out.println("Total Amount should pay : "+ta);
	            paymentService.paymentprocessDetails(c_id.getCustomer_id(), ta, product_Details.getProduct_id());
	            Order_Details o=new Order_Details();
	            o.setCustomer_id(c_id.getCustomer_id());
	            o.setProduct_id(product_Details.getProduct_id());
	            o.setProduct_quantity(quantityy);
	            o.setOrder_address(c_id.getCustomer_address());
	            o.setOrder_date(LocalDate.now());
	            orderService.insertOrderDetails(o);
				break;
			    default:
				System.out.println("Invalid request");
				break;
			}
			break;
		case 2:
			System.out.println("Cart details");
			cartService.showCartDetails(c_id.getCustomer_id());
			break;
		case 3:
			System.out.println("Order details");
			int id= c_id.getCustomer_id();
			List<Order_Details> o=orderService.getOrderDetails(id);
           
			if(o!=null && !o.isEmpty())
			{
			for (Order_Details order_Details : o) {
				
					Product_Details p=productService.getAPrdoDetails(order_Details.getProduct_id());
					System.out.println("Product name :"+p.getProduct_name());
					System.out.println("Product Brand :"+p.getProduct_brand());
					System.out.println("Product Quantity :"+order_Details.getProduct_quantity());
					System.out.println("Order Address  :"+order_Details.getOrder_address());
					System.out.println("Order Date  :"+order_Details.getOrder_date());
				}
			}
				else
				{
					System.out.println("There is no orders  confirmed for this customer");
				}
			
		
			break;
		default:
			System.out.println("Invalid request");
			break;
		}

	}
	
}
