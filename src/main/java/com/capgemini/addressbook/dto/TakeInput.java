package com.capgemini.addressbook.dto;

import java.util.Scanner;

public class TakeInput {
	public void takeInput(ContactDetails contactDetails, Scanner scan) {
		System.out.println("Please enter your First name :");
		contactDetails.setFirstName(scan.next());
		System.out.println("Please enter your Last name :");
		contactDetails.setLastName(scan.next());
		System.out.println("Please enter your Address :");
		contactDetails.setAddress(scan.next());
		System.out.println("Please enter your City :");
		contactDetails.setCity(scan.next());
		System.out.println("Please enter your State:");
		contactDetails.setState(scan.next());
		System.out.println("Please enter your Zip Code :");
		contactDetails.setZip(scan.next());
		System.out.println("Please enter your Phone number :");
		contactDetails.setPhoneNo(scan.next());
		System.out.println("Please enter your email Address :");
		contactDetails.setEmailAddress(scan.next());
	}
}
