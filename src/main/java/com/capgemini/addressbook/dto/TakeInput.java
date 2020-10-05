package com.capgemini.addressbook.dto;

import java.util.Scanner;

import com.capgemini.addressbook.service.implementation.PersonServiceImplementation;

public class TakeInput {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNo;
	private String email;
	private PersonServiceImplementation personService = new PersonServiceImplementation();

	public boolean takeInput(ContactDetails contactDetails, AddressBook addressBook, Scanner scan) {
		System.out.println("Please enter your First name :");
		firstName = (scan.next());
		System.out.println("Please enter your Last name :");
		lastName = (scan.next());
		System.out.println("Please enter your Address :");
		address = (scan.next());
		System.out.println("Please enter your City :");
		city = (scan.next());
		System.out.println("Please enter your State:");
		state = (scan.next());
		System.out.println("Please enter your Zip Code :");
		zip = (scan.next());
		System.out.println("Please enter your Phone number :");
		phoneNo = (scan.next());
		System.out.println("Please enter your email Address :");
		email = (scan.next());
		if (personService.DuplicateChecker(addressBook, firstName, lastName, scan)) {
			contactDetails.setFirstName(firstName);
			contactDetails.setLastName(lastName);
			contactDetails.setAddress(address);
			contactDetails.setCity(city);
			contactDetails.setState(state);
			contactDetails.setZip(zip);
			contactDetails.setPhoneNo(phoneNo);
			contactDetails.setEmailAddress(email);
			return true;
		} else
			return false;
	}
}
