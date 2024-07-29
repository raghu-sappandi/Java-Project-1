package com.bank.app;

import java.util.Scanner;

import com.bank.dao.*;
import com.bank.dto.Customer;

public class TransferAmount {
	public static void transferAmount(Customer c) {//c is sender account which is logged in
		CustomerDAO cdao=new CustomerDAO_imp1();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount to be transfered");
		double amount=sc.nextDouble();
		System.out.println("Enter the Benificiary account number");
		long receiver_accno=sc.nextLong();
		Customer receiver=cdao.getCustomer(receiver_accno);
		if(c.getAccno()!=receiver.getAccno() && c.getBal()>0 && c.getBal()>=amount && amount>0) {
			System.out.println("Enter the pin");
			int pin=sc.nextInt();
			if(pin==c.getPin()) {
				c.setBal(c.getBal()-amount);
				boolean c_res=cdao.updateCustomer(c); //amount is getting debited
				receiver.setBal(receiver.getBal()+amount);
				boolean receiver_res=cdao.updateCustomer(receiver);
				if(c_res && receiver_res) {
					System.out.println("Transaction Successfull");
				}
			}
			else {
				System.out.println("Transaction failed");
			}
		}
	}
}
