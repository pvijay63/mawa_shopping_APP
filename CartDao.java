package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.*;
import com.shopping.util.JDBCConnection;
public class CartDao {


	public static final String insert="insert into cart_details(Product_id, Customer_id, Product_Quantity) values(?,?,?)";
	public boolean insertCartDetails(Cart_Details cartdetails)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			preparedstatement.setInt(1, cartdetails.getProduct_id());
			preparedstatement.setInt(2, cartdetails.getCustomer_id());
			preparedstatement.setInt(3, cartdetails.getProduct_quantity());
			int result=preparedstatement.executeUpdate();
			if(result!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		
		e.printStackTrace();
		return false;
		}
		
	}
	
	
	public List<Product_Details> getAllCartDetails(int customerId) {
	    String sql = "SELECT p.Product_id, p.Product_Name, p.Product_Brand, p.Product_Price, " +
	                 "p.Product_Category, p.Product_Discount, c.Product_Quantity " +
	                 "FROM cart_details c " +
	                 "JOIN product_details p ON c.Product_id = p.Product_id " +
	                 "WHERE c.Customer_id = ?";
	    
	    List<Product_Details> productList = new ArrayList<>();

	    try (Connection connection = JDBCConnection.forMySQLConnection();
	         PreparedStatement ps = connection.prepareStatement(sql)) {
	        
	        ps.setInt(1, customerId);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            Product_Details product = new Product_Details();
	            product.setProduct_name(rs.getString("Product_Name"));
	            product.setProduct_brand(rs.getString("Product_Brand"));
	            product.setProduct_price(rs.getDouble("Product_Price"));
	            product.setProduct_category(rs.getString("Product_Category"));
	            product.setproduct_discount(rs.getDouble("Product_Discount"));
	            
	            // ✅ set quantity from cart
	            product.setProduct_quantity(rs.getInt("Product_Quantity"));
	            
	            productList.add(product);
	        }

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return productList;
	}

	
	
	
}
