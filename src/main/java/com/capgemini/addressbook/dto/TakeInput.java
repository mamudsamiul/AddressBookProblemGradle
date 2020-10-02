package com.capgemini.addressbook.dto;

import java.util.Scanner;

public class TakeInput {
	public void takeInput(ContactDetails contactDetails, Scanner scan) {
		System.out.println("Please enter your First name :");
		contactDetails.setFirstName(scan.nextLine());
		System.out.println("Please enter your Last name :");
		contactDetails.setLastName(scan.nextLine());
		System.out.println("Please enter your Address :");
		contactDetails.setAddress(scan.nextLine());
		System.out.println("Please enter your City :");
		contactDetails.setCity(scan.nextLine());
		System.out.println("Please enter your State:");
		contactDetails.setState(scan.nextLine());
		System.out.println("Please enter your Zip Code :");
		contactDetails.setZip(scan.nextLine());
		System.out.println("Please enter your Phone number :");
		contactDetails.setPhoneNo(scan.nextLine());
		System.out.println("Please enter your email Address :");
		contactDetails.setEmailAddress(scan.nextLine());
	}
}
