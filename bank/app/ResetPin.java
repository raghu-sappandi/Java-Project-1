package com.bank.app;

import java.util.Scanner;

import com.bank.dao.*;
import com.bank.dto.Customer;

public class ResetPin {
	public static void resetPin(Customer c) {
		Scanner sc=new Scanner(System.in);
		CustomerDAO cdao=new CustomerDAO_imp1();
		System.out.println("Enter your Phone Number");
		long phone=sc.nextLong();
		System.out.println("Enter your Mail Id");
		String mail=sc.next();
		if(phone==c.getPhone() && mail.equals(c.getMail())) {
			System.out.println("set a new pin");
			int pin=sc.nextInt();
			System.out.println("Confirm the pin");
			int cpin=sc.nextInt();
			if(pin==cpin) {
				c.setPin(pin);
				boolean res=cdao.updateCustomer(c);
				if(res) {
					System.out.println("Pin Updated Successfully");
				}
				else {
					System.out.println("Failed to Updated Pin");
				}
			}
			else {
				System.out.println("Pin mismatch or Incorrect pin");
			}
		}
	}
}
