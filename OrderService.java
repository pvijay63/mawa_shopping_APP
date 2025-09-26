package com.shopping.service;

import java.util.List;

import com.shopping.dao.OrderDao;
import com.shopping.dto.Order_Details;

public class OrderService {

	OrderDao orderDao=new OrderDao();
	public void insertOrderDetails(Order_Details o)
	{
		orderDao.insertOrderDetails(o);
	}
	
	public List<Order_Details> getOrderDetails(int id)
	{
		return orderDao.getOrderDetails(id);
	}
}
