package com.shopping.service;


import java.util.List;

import com.shopping.dao.CartDao;
import com.shopping.dto.Cart_Details;
import com.shopping.dto.Product_Details;

public class CartService {

	CartDao cartDao = new CartDao();

	public void addCartDetails(Cart_Details cartDetails) {
		if (cartDao.insertCartDetails(cartDetails)) {
			System.out.println("Product Added to the Cart");
		} else {
			System.out.println("Not Added");
		}
	}
	
	public void showCartDetails(int customerId) {
	    List<Product_Details> products = cartDao.getAllCartDetails(customerId);

	    if (products.isEmpty()) {
	        System.out.println("Your cart is empty!");
	        
	    } else {
	        System.out.println("Your Cart:");
	        for (Product_Details p : products) {
	            System.out.println("Product: " + p.getProduct_name() +
	                               " | Brand: " + p.getProduct_brand() +
	                               " | Price: " + p.getProduct_price() +
	                               " | Quantity: " + p.getProduct_quantity());
	        }
	       
	    }
	}
	
	

}
