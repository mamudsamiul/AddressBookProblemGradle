package com.capgemini.addressbook.service;

import com.capgemini.addressbook.dto.AddressBookList;

public interface AddressBookService {
	public void showList(AddressBookList addressBookList);

	public int FindAddressBook(String name, AddressBookList addressBookList);
	public void SearchByCity(AddressBookList addressBookList, String city);
	public void SearchByState(AddressBookList addressBookList, String state);
}
