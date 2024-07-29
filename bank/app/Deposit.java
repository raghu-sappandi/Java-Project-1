package com.bank.app;

import java.util.Scanner;
import com.bank.dao.*;
import com.bank.dto.Customer;

public class Deposit {
	public static void deposit(Customer c) {
		CustomerDAO cdao=new CustomerDAO_imp1();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount to be Deposited");
		double amount=sc.nextDouble();
		c.setBal(c.getBal()+amount);
		boolean res = cdao.updateCustomer(c);
		if(res) {
			System.out.println("Amount of Rs."+amount+"has been added");
			System.out.println("Updated Balance is "+c.getBal());
		}
		else {
			System.out.println("Deposite Unsuccessfull");
		}
	}
}
