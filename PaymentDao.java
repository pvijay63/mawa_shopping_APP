package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.shopping.dto.Payment_Details;
import com.shopping.util.JDBCConnection;

public class PaymentDao {

	private static final String insert="insert into payment_details(Customer_id, Product_id, Payment_Type, Payment_Status, Amount, Payment_Date)"
			+ " values (?,?,?,?,?,?)";
	public boolean insertPaymentDetails(Payment_Details p)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setInt(1, p.getCustomer_id());
			preparedStatement.setInt(2, p.getProduct_id());
			preparedStatement.setString(3, p.getPayment_type());
			preparedStatement.setString(4, p.getPayment_status());
			preparedStatement.setDouble(5, p.getAmount());
			preparedStatement.setDate(6, Date.valueOf(p.getPayment_date()));
			int res=preparedStatement.executeUpdate();
			if(res!=0)
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
	
	
}
