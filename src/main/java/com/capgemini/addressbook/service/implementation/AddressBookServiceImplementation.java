package com.capgemini.addressbook.service.implementation;

import com.capgemini.addressbook.dto.AddressBookList;
import com.capgemini.addressbook.service.AddressBookService;

public class AddressBookServiceImplementation implements AddressBookService{

	public AddressBookServiceImplementation() {
		
	}
	@Override
	public void showList(AddressBookList addressBookList) {
		for(int i=0;i<addressBookList.getAddressBookList().size();i++) {
			System.out.println(addressBookList.getAddressBookList().get(i).getName());
		}
	}
}
