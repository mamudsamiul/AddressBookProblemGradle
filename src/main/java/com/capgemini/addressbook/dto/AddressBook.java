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
}
