package com.capgemini.addressbook.dto;

import java.util.ArrayList;
import java.util.Scanner;
public class DetailsChecking {
	private ArrayList<ContactDetails> addressBook;
	private Scanner scan;
	private String firstName;
	private String lastName;
	public DetailsChecking(AddressBook addressBook,Scanner scan) {
		this.addressBook=addressBook.getAddressBook();
		this.scan=scan;
	}
	public int validate() {
		System.out.println("Enter Your first Name for validation: ");
		firstName=scan.next();
		System.out.println("Enter Your Last Name for validation: ");
		lastName=scan.next();
		for(int i=0 ; i<addressBook.size();i++) {
			if(addressBook.get(i).getFirstName().equalsIgnoreCase(firstName) && 
					addressBook.get(i).getLastName().equalsIgnoreCase(lastName)) {
				return i;
			}
		}
		System.out.println("No Entry Found!");
		return -1;
	}
}
