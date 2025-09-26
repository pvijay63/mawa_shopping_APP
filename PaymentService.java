package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.dao.PaymentDao;
import com.shopping.dto.Customer_Details;
import com.shopping.dto.Payment_Details;

public class PaymentService {

	PaymentDao paymentDao=new PaymentDao();
	Scanner sc=new Scanner(System.in);
	
	public void paymentprocessDetails(int cid,Double amount,int pid) {
		
		Payment_Details payment_Details=new Payment_Details();
		payment_Details.setCustomer_id(cid);
		payment_Details.setPayment_date(LocalDate.now());
		System.out.println("Enter \n 1.For UPI \n 2.Cash on Delivery \n 3.Debit \n 4.Net Payment \n 5.EMI");
		switch (sc.nextInt()) {
		case 1:
			payment_Details.setPayment_type("UPI");
			payment_Details.setPayment_status("Payment Success");
			break;
		case 2:
			payment_Details.setPayment_type("Cash on Delivery");
			payment_Details.setPayment_status("Under processing");
			break;
		case 3:
			payment_Details.setPayment_type("Debit");
			payment_Details.setPayment_status("Payment Success");
			break;
		case 4:
			payment_Details.setPayment_type("Net Payment");
			payment_Details.setPayment_status("Payment Success");
			break;
		case 5:
			payment_Details.setPayment_type("EMI");
			payment_Details.setPayment_status("Under processing");
			break;
		default:
			break;
		}
		System.out.println("Enter Amount");
		double unamount=sc.nextDouble();
		if(unamount==amount)
		{
			 payment_Details.setCustomer_id(cid);
			 payment_Details.setPayment_date(LocalDate.now());
			 payment_Details.setProduct_id(pid);
			 payment_Details.setAmount(unamount);
			 if(paymentDao.insertPaymentDetails(payment_Details))
			 {
				 System.out.println("Order placed successfuly");
			 }
			 else
			 {
				 System.out.println("Invalid amount");
			 }
		}

	}
}
