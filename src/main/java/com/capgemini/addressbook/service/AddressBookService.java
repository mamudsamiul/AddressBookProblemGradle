package com.capgemini.addressbook.service;

import com.capgemini.addressbook.dto.AddressBook;
import com.capgemini.addressbook.dto.AddressBookList;
import com.capgemini.addressbook.dto.ContactDetails;

public interface AddressBookService {
	public void showList(AddressBookList addressBookList);

	public int FindAddressBook(String name, AddressBookList addressBookList);

	public void SearchByCity(AddressBookList addressBookList, String city);

	public void SearchByState(AddressBookList addressBookList, String state);

	public void AddStateToDictionary(AddressBookList addressBookList, ContactDetails contactDetails);

	public void AddCityToDictionary(AddressBookList addressBookList, ContactDetails contactDetails);

	public void deleteStateFromDictionary(AddressBookList addressBookList, int index, AddressBook addressBook);

	public void deleteCityFromDictionary(AddressBookList addressBookList, int index, AddressBook addressBook);
}
