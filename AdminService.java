package com.shopping.service;


import java.util.Scanner;

import com.shopping.dao.AdminDao;
import com.shopping.dto.AdminDetails;

public class AdminService {
	ProductService p=new ProductService();
    AdminDao a1=new AdminDao();
	Scanner s =new Scanner(System.in);
	public void adminLogin()
	{
		System.out.println("enter admin email id");
		String adminemail=s.next();
		System.out.println("enter admin password");
		String adminpass=s.next();
		
		 AdminDetails a= a1.selectAllAdminDetailas(adminemail, adminpass);
		if(a!=null)
		{
			System.out.println("Enter \n 1.To insert Product details "
					+ "\n 2.To insert Product based on brand");
			switch (s.nextInt()) {
			case 1:
				System.out.println("insert product details");
				p.StoreproductDetails();
				break;
			case 2:
				p.storeProductsByUSingBrand();
				break;
			default:
				System.out.println("invalid request");
				break;
			}
		}
		else
		{
			System.out.println("Invalid admin email or password");
		}
	}
}
