package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.AdminDetails;
import com.shopping.util.JDBCConnection;

public class AdminDao {

	private static final String selectAll="select * from admin_details where  Admin_Email_id=? and Admin_password=?";
	
	public AdminDetails selectAllAdminDetailas(String adminemailid ,String adminpass)
	{
	
		try {
			Connection connect =JDBCConnection.forMySQLConnection();
			PreparedStatement prepare=connect.prepareStatement(selectAll);
			  prepare.setString(1, adminemailid);
			  prepare.setString(2,adminpass);
	          ResultSet resultset=prepare.executeQuery();
	          
	          AdminDetails a=null;
	         
	          while(resultset.next())
	          {
	        	 a=new AdminDetails();
	        	  a.setAdmin_email_id(resultset.getString("Admin_Email_id"));
	        	  a.setAdmin_password(resultset.getString("Admin_password"));
	        	  a.setAdmin_role(resultset.getString("Admin_Role"));
	
	          }
	          return a;
		} 
			
		catch (SQLException |ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
