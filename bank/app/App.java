package com.bank.app;

import java.util.Scanner;

import com.bank.dto.Customer;

public class App {
	
	 public static void option(Customer c)
	 {
		 Scanner sc=new Scanner(System.in);
		 int choice=0;
		 System.out.println("WELCOME"+" "+c.getName());
		 System.out.println("enter your choice");
		 do {
			 System.out.println("1---->check balance");
			 System.out.println("2---->deposite");
			 System.out.println("3---->transfer the amount");
			 System.out.println("4---->passbook");
			 System.out.println("5---->update your account");
			 System.out.println("6---->reset pin");
			 System.out.println("7---->go back to main menu");
			 choice=sc.nextInt();
			 switch(choice) 
			 {
			 case 1:System.out.println("your account balence is"+" "+c.getBal());
			       break;
			 case 2:Deposit.deposit(c);
		       		break;
			 case 3:TransferAmount.transferAmount(c);
			 
		       break;
			 case 4://passbook/
		       break;
			 case 5://update/
				 break;
			 case 6:ResetPin.resetPin(c);
				 break;
			 case 7:return ;
				 
			 }
			 
			 
		 }
		 while(choice!=7);
	 }
}

