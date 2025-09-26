package com.shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Customer_Details;
import com.shopping.service.CustomerService;
import com.shopping.util.JDBCConnection;

public class CustomerDao {

	private static final String insert=" insert into customer_details(Customer_Name, Customer_Email_id, Customer_Mobile_Num, "
			+ "Customer_Address, Password) values(?,?,?,?,?)";
	private static final String selectAll="select * from customer_details ";
	private static final String customer_Login="select * from customer_details where (Customer_Email_id=? or Customer_Mobile_Num=?) "
			+ "and  Password=?";
	public boolean insertCustomerDetails(Customer_Details c)
	{
		 
		try {
			Connection connection =JDBCConnection.forMySQLConnection();
			PreparedStatement prepared=connection.prepareStatement(insert);
			System.out.println(prepared);
			prepared.setString(1,c.getCustomer_name());
			prepared.setString(2, c.getCustomer_email_id());
			prepared.setLong(3, c.getCustomer_mob_num());
			prepared.setString(4,c.getCustomer_address());
			prepared.setString(5, c.getPassword());
			int result=prepared.executeUpdate();
			System.out.println(prepared);
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
	public List<Customer_Details> selectAllCustomerDetails() {
		
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement prepared=connection.prepareStatement(selectAll);
			ResultSet result=prepared.executeQuery();
			
			List<Customer_Details> listofcustomers=new ArrayList<Customer_Details>();
			while(result.next())
			{
				Customer_Details c=new Customer_Details();
				c.setCustomer_id(result.getInt("Customer_id"));
				c.setCustomer_email_id(result.getString("Customer_Email_id"));
				c.setCustomer_mob_num(result.getLong("Customer_Mobile_Num"));
				c.setPassword(result.getString("password"));
				listofcustomers.add(c);
			
			}
			return listofcustomers;
		} catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
			return null;
		}
		

	}
	
	public Customer_Details selectCustomerDetailsByUsingEmailidOrMobileNumberANdPassword(String emailidormobileNumber,String password)
	{
		
		
		
			 
			try {
				Connection connection = JDBCConnection.forMySQLConnection();
				PreparedStatement prepare=connection.prepareStatement(customer_Login);
				prepare.setString(1, emailidormobileNumber);
				prepare.setString(2, emailidormobileNumber);
				prepare.setString(3, password);
				
				ResultSet result=prepare.executeQuery();
				Customer_Details c =new Customer_Details();
				if(result.next())
				{
				    c.setCustomer_id(result.getInt("Customer_id"));
					c.setCustomer_email_id(result.getString("Customer_Email_id"));
					c.setCustomer_mob_num(result.getLong("Customer_Mobile_Num"));
					c.setCustomer_gender(result.getString("Customer_Gender"));
					c.setCustomer_name(result.getString("Customer_Name"));
					
					return c;
				}
				else
				{
					return null;
				}
			} catch (ClassNotFoundException | SQLException  | NullPointerException e) {
				
				e.printStackTrace();
				return null;
			}
			
		
	}
	
	
	
	
}
