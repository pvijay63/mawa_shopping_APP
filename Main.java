package com.shopping.main;

import java.util.Scanner;

import com.shopping.service.AdminService;
import com.shopping.service.CustomerService;

public class Main {

	public static void main(String[] args) {
		AdminService admin=new AdminService();
		CustomerService c=new CustomerService();
		Scanner s=new Scanner(System.in);
		String str="****----****Welcome To Shopping****----****";
		for(int i=0;i<str.length();i++)
		{
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
		boolean exit=true;
		
		while(exit)
		{
			System.out.println("Enter  \n 1. For Admin Login   \n "
					+ "2. For Customer Registration \n "
					+ "3.For Customer Login ");
		switch (s.nextInt()) {
		case 1:
			System.out.println("Admin Login");
			admin.adminLogin();
			System.out.println("Do you want To Continue 😁😁😁  Enter \n Yes \n No");
			if(s.next().equalsIgnoreCase("yes"))
				continue;
	
			else
			{
				exit=false;
				System.out.println("Thank you Visit Again....😁😁😁");
			}
			break;
		case 2:
			System.out.println("Customer Registration");	
				System.out.println("Do you want To Continue 😁😁😁  Enter \n Yes \n No");
				if(s.next().equalsIgnoreCase("yes"))
					c.customerRegistration();
			else
			{
				exit=false;
				System.out.println("Thank you Visit Again....😁😁😁");
			}
			break;
		case 3:
			System.out.println("Customer Login");
			c.customer_Login();
			System.out.println("Do you want To Continue 😁😁😁  Enter \n Yes \n No");
			if(s.next().equalsIgnoreCase("yes"))
				continue;
			else
			{
				exit=false;
				System.out.println("Thank you Visit Again....😁😁😁");
			}
			break;
		default:
			exit=false;
			System.out.println("Invalid Request");
			System.out.println("Thank you Visit Again....😁😁😁");
			break;
		}
	}
		
	}

}
