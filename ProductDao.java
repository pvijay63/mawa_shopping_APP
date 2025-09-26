package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Product_Details;
import com.shopping.util.JDBCConnection;

public class ProductDao {

	private static final String insert="insert into product_details(Product_Name, Product_Brand, Product_Price, Product_M_F_Date, Product_Ex_Date, Product_Quantity,"
			+ " Product_Category, Product_Discount) values "
			+ "(?,?,?,?,?,?,?,?)";
	private static final String selectAll="select * from product_details";
	private static final String selectid="select * from product_details where Product_id=?";
	public boolean insertProductDetails(Product_Details p){
		
		 try {
			Connection connection =JDBCConnection.forMySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setString(1,p.getProduct_name() );
			preparedStatement.setString(2, p.getProduct_brand());
			preparedStatement.setDouble(3,p.getProduct_price());
			preparedStatement.setDate(4,p.getProduct_M_F_date());
			preparedStatement.setDate(5, p.getProduct_Ex_date());
			preparedStatement.setInt(6, p.getProduct_quantity());
			preparedStatement.setString(7, p.getProduct_category());
			preparedStatement.setDouble(8, p.getproduct_discount());
			
			
			int result=preparedStatement.executeUpdate();
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
	
	public boolean insertMorethanOneProduct( List<Product_Details> list)
	{
	try {
		Connection connection = JDBCConnection.forMySQLConnection();
		PreparedStatement prepare=connection.prepareStatement(insert);
		for(Product_Details p:list)
		{
			prepare.setString(1,p.getProduct_name());
			prepare.setString(2,p.getProduct_brand());
			prepare.setDouble(3,p.getProduct_price());
			prepare.setDate(4,p.getProduct_M_F_date());
			prepare.setDate(5,p.getProduct_Ex_date());
			prepare.setInt(6, p.getProduct_quantity());
			prepare.setString(7,p.getProduct_category());
			prepare.setDouble(8, p.getproduct_discount());
			
		}
		prepare.addBatch();
		int [] results=prepare.executeBatch();
		if(results.length!=0)
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
	public List<Product_Details> getAllProductDetails() {
		
		 
		
			try {
				Connection connectin=JDBCConnection.forMySQLConnection();
				PreparedStatement prep=connectin.prepareStatement(selectAll);
				ResultSet resultSet=prep.executeQuery();
				List<Product_Details> listofProducts=new ArrayList<Product_Details>();
				if(resultSet.isBeforeFirst())
				{
					while (resultSet.next()) {
						Product_Details product=new Product_Details();
						product.setProduct_name(resultSet.getString("Product_Name"));
						product.setProduct_id(resultSet.getInt("Product_id"));
						product.setProduct_brand(resultSet.getString("Product_Brand"));
						product.setProduct_price(resultSet.getDouble("Product_Price"));
						product.setProduct_M_F_date(resultSet.getDate("Product_M_F_Date"));
						product.setProduct_Ex_date(resultSet.getDate("Product_Ex_Date"));
						product.setProduct_quantity(resultSet.getInt("Product_Quantity"));
						product.setProduct_category(resultSet.getString("Product_Category"));
						product.setproduct_discount(resultSet.getDouble("Product_Discount"));
						listofProducts.add(product);
					}
					return listofProducts;
				    }
					else
					{
						return null;
					}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	
	public Product_Details getProductDetails(int id)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(selectid);
			preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.isBeforeFirst())
		{
			Product_Details product=new Product_Details();
			while(resultSet.next())
			{
				if(resultSet.getInt("Product_id")==id)
				{
				product.setProduct_name(resultSet.getString("Product_Name"));
				product.setProduct_brand(resultSet.getString("Product_Brand"));
				product.setProduct_price(resultSet.getDouble("Product_Price"));
				product.setProduct_M_F_date(resultSet.getDate("Product_M_F_Date"));
				product.setProduct_Ex_date(resultSet.getDate("Product_Ex_Date"));
				product.setProduct_quantity(resultSet.getInt("Product_Quantity"));
				product.setProduct_category(resultSet.getString("Product_Category"));
				product.setproduct_discount(resultSet.getDouble("Product_Discount"));
				}
				
			}
			return product;
		}
		else
		{
			return null;
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
