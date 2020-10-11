package com.capgemini.addressbook.dto;

import java.util.ArrayList;

public class AddressBook {

	private ArrayList<ContactDetails> addressBook;
	private String name;

	public AddressBook(String name) {
		this.name = name;
		addressBook = new ArrayList<ContactDetails>();
	}

	public void AddContact(ContactDetails person) {
		addressBook.add(person);
	}

	public void ShowContact() {
		for (int i = 0; i < addressBook.size(); i++) {
			System.out.print(i + 1 + " Entry = ");
			System.out.print(addressBook.get(i).getFirstName());
			System.out.print(" " + addressBook.get(i).getLastName());
			System.out.print(" " + addressBook.get(i).getAddress());
			System.out.print(" " + addressBook.get(i).getCity());
			System.out.print(" " + addressBook.get(i).getState());
			System.out.print(" " + addressBook.get(i).getZip());
			System.out.print(" " + addressBook.get(i).getPhoneNo());
			System.out.print(" " + addressBook.get(i).getEmailAddress());
			System.out.println();
		}
	}

	public ArrayList<ContactDetails> getAddressBook() {
		return addressBook;
	}

	public String getName() {
		return name;
	}
}
