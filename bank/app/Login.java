package com.bank.app;
import java.util.Scanner;

import com.bank.dao.*;
import com.bank.dto.Customer;
public class Login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		System.out.println("1------>Login using Account Number");
		System.out.println("2------>Login using Phone Number and mail");
		switch (sc.nextInt()) {
		case 1:CustomerDAO cdao=new CustomerDAO_imp1();
		System.out.println("Enter your Account number");
		long accno=sc.nextLong();
		System.out.println("Enter the pin");
		int pin=sc.nextInt();
		
		Customer c=cdao.getCustomer(accno, pin);
		if(c!=null) {
		System.out.println("LOGIN SUCESSFULL");
		App.option(c);
			
		}
		else {
			System.out.println("failed to login");
		}
		break;
		
		case 2:
			CustomerDAO cdao1=new CustomerDAO_imp1();
		System.out.println("Enter your Phone number");
		long phone=sc.nextLong();
		System.out.println("Enter the mail");
		String mail=sc.next();
		
		Customer c1=cdao1.getCustomer(phone, mail);
		if(c1!=null) {
		System.out.println("LOGIN SUCESSFULL");
		App.option(c1);
			
		}
		else {
			System.out.println("failed to login");
		}
		break;
		}
		
		
 }

		
	
}
