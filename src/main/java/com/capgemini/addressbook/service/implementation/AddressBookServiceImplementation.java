package com.capgemini.addressbook.service.implementation;

import com.capgemini.addressbook.dto.AddressBookList;
import com.capgemini.addressbook.service.AddressBookService;

public class AddressBookServiceImplementation implements AddressBookService {

	public AddressBookServiceImplementation() {

	}

	@Override
	public void showList(AddressBookList addressBookList) {
		for (int i = 0; i < addressBookList.getAddressBookList().size(); i++) {
			System.out.println(addressBookList.getAddressBookList().get(i).getName());
		}
	}

	@Override
	public int FindAddressBook(String name, AddressBookList addressBookList) {
		for (int i = 0; i < addressBookList.getAddressBookList().size(); i++) {
			if (addressBookList.getAddressBookList().get(i).getName().equals(name))
				return i;
		}
		return -1;
	}
}
