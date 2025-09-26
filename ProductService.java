package com.shopping.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shopping.dao.ProductDao;
import com.shopping.dto.Product_Details;

public class ProductService {

	ProductDao productDao=new ProductDao();
	Scanner s=new Scanner(System.in);
	public void StoreproductDetails()
	{
		System.out.println("enter product name");
		String pname=s.nextLine();
		System.out.println("enter product brand");
		String pbrand=s.nextLine();
		s.nextLine();
		System.out.println("enter product price");
		double pprice=s.nextDouble();
		s.nextLine();
		System.out.println("enter product manufacture date");
		String pmdate=s.next();
		System.out.println("enter product expiry date");
		String pexdate=s.next();
		System.out.println("enter product quantity");
		int pquantity=s.nextInt();
		s.nextLine();
		System.out.println("enter product Category");
		String pcategory=s.next();
		System.out.println("enter product discount");
		double pdiscount=s.nextDouble();
		System.out.println(productDao);
		Product_Details product=new Product_Details();
		product.setProduct_name(pname);
		product.setProduct_brand(pbrand);
		product.setProduct_price(pprice);
		product.setProduct_M_F_date(Date.valueOf(pmdate));
		product.setProduct_Ex_date(Date.valueOf(pexdate));
		product.setProduct_quantity(pquantity);
		product.setProduct_category(pcategory);
		product.setproduct_discount(pdiscount);
		/* DAO insertion */
		productDao.insertProductDetails(product);
		System.out.println(productDao);
		
	}
	
	public void storeProductsByUSingBrand()
	{
		List<Product_Details>list=new ArrayList<Product_Details>();
		
		System.out.println("enter the product brand");
		String pbrand=s.next();
		System.out.println("Number of products under "+pbrand+" brand");
		int number=s.nextInt();
		String n[]= {"first","second","third","fourth","fifith"};
		for(int i=0;i<number;i++)
		{
			System.out.println("enter "+n[i]+" product details");
			System.out.println("enter product name");
			String pname=s.next();
			System.out.println("enter product price");
			double pprice=s.nextDouble();
			System.out.println("enter product manufacture date");
			String pmdate=s.next();
			System.out.println("enter product expiry date");
			String pexdate=s.next();
			System.out.println("enter product quantity");
			int pquantity=s.nextInt();
			System.out.println("enter product Category");
			String pcategory=s.next();
			System.out.println("enter product discount");
			double pdiscount=s.nextDouble();
			
			Product_Details product=new Product_Details();
			product.setProduct_name(pname);
			product.setProduct_brand(pbrand);
			product.setProduct_price(pprice);
			product.setProduct_M_F_date(Date.valueOf(pmdate));
			product.setProduct_Ex_date(Date.valueOf(pexdate));
			product.setProduct_quantity(pquantity);
			product.setProduct_category(pcategory);
			product.setproduct_discount(pdiscount);
			
			list.add(product);
		}
		if(productDao.insertMorethanOneProduct(list))
		{
			System.out.println("Product inserted successfully");
		}
		else
		{
			System.out.println("Server error 500");
		}
	}
	
	public List<Product_Details> getAllProductDetails() {
		
		return productDao.getAllProductDetails();                                                                

	}

	public Product_Details getAPrdoDetails(int id)
	{
		Product_Details product_Details=productDao.getProductDetails(id);
		return product_Details;
	}
}
