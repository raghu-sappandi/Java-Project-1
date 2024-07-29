package com.bank.app;
import java.util.Scanner;

import com.bank.dao.*;
import com.bank.dto.Customer;
public class Signup {
		public static void signup()
		{
			Customer c=new Customer();
			CustomerDAO cdao=new CustomerDAO_imp1();
			Scanner sc = new Scanner(System.in);
			System.out.println("==========Application Form=======");
			
			System.out.println("Enter the name");
			c.setName(sc.next());
			
			System.out.println("Enter the phone number");
			c.setPhone(sc.nextLong());
			
			System.out.println("Enter the Mail Id");
			c.setMail(sc.next());
			
			System.out.println("Set the pin");
			int pin=sc.nextInt();
			
			System.out.println("Confirm the pin");
			int cpin=sc.nextInt();
			
			if(pin==cpin) {
				c.setPin(pin);
				boolean res= cdao.insertCustomer(c);
				
				if(res) {
					System.out.println("Data added successfully");
					c=cdao.getCustomer(c.getPhone(),c.getMail());
					System.out.println("Your account number is "+c.getAccno());
				}
				else {
					System.out.println("Failed to create the account");
				}
			}
		}
}
