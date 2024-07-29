package com.bank.app;

import java.util.Scanner;

public class Welcome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice=0;
		Scanner sc =new Scanner(System.in);
		System.out.println("===========Welcome to ASP Bank=============");
		do {
			System.out.println("==============================================");
			System.out.println("1------>Customer Login");
			System.out.println("2------>Create a Account");
			System.out.println("3------>Exit");
			choice=sc.nextInt();
			switch(choice) {
			case 1:Login.login();
			System.out.println();
					break;
			case 2:Signup.signup();
			System.out.println();
					break;
			case 3:
					System.out.println("Exiting the Application");
					System.out.println();
					break;
			default:System.out.println("invalid Choice");
			}
		}while(choice!=3);
	}

}
