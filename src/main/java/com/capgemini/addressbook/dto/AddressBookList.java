package com.capgemini.addressbook.dto;

import java.util.ArrayList;

public class AddressBookList {
	private ArrayList<AddressBook> addressBookList;

	public AddressBookList() {
		addressBookList = new ArrayList<AddressBook>();
	}

	public void CreateAddressBook(AddressBook addressBook) {
		addressBookList.add(addressBook);
	}

	public ArrayList<AddressBook> getAddressBookList() {
		return addressBookList;
	}
}
