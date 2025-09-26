package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Order_Details;
import com.shopping.util.JDBCConnection;

public class OrderDao {

	private static final String insert="insert into order_details (Customer_id, Product_id, Product_Quantity, Order_Address, Order_Date)"
			+ "values (?,?,?,?,?)";
	
	private static final String getOrders="select * from order_details where Customer_id=?";
	public void insertOrderDetails(Order_Details order_Details)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setInt(1, order_Details.getCustomer_id());
			preparedStatement.setInt(2, order_Details.getProduct_id());
			preparedStatement.setInt(3, order_Details.getProduct_quantity());
			preparedStatement.setString(4, order_Details.getOrder_address());
			preparedStatement.setDate(5,Date.valueOf(order_Details.getOrder_date()));
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Order_Details> getOrderDetails(int customerId)
	{
	
		List<Order_Details>listOfOrders=new ArrayList<Order_Details>();
		Connection connection;
		try {
			connection = JDBCConnection.forMySQLConnection();
			PreparedStatement prepare=connection.prepareStatement(getOrders);
			prepare.setInt(1,customerId);
			ResultSet resultSet=prepare.executeQuery();
			if(resultSet.isBeforeFirst())
			{
				while (resultSet.next()) {
					
					Order_Details order_Details=new Order_Details();
					order_Details.setCustomer_id(resultSet.getInt("Customer_id"));
					order_Details.setProduct_id(resultSet.getInt("Product_id"));
					order_Details.setProduct_quantity(resultSet.getInt("Product_Quantity"));
					order_Details.setOrder_address(resultSet.getString("Order_Address"));
					order_Details.setOrder_date(resultSet.getDate("Order_Date").toLocalDate());
					listOfOrders.add(order_Details);
				}
				return listOfOrders;
			}
			else
			{
				return listOfOrders;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
