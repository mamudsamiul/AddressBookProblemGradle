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

	@Override
	public void SearchByCity(AddressBookList addressBookList, String city) {
		for (int i = 0; i < addressBookList.getAddressBookList().size(); i++) {
			for (int j = 0; j < addressBookList.getAddressBookList().get(i).getAddressBook().size(); j++) {
				if (addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getCity().equals(city)) {
					System.out
							.print(addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getFirstName());
					System.out.print(
							" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getLastName());
					System.out.print(
							" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getAddress());
					System.out
							.print(" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getCity());
					System.out.print(
							" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getState());
					System.out
							.print(" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getZip());
					System.out.print(
							" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getPhoneNo());
					System.out.print(" "
							+ addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getEmailAddress());
					System.out.println();
				}
			}
		}

	}

	@Override
	public void SearchByState(AddressBookList addressBookList, String state) {
		for (int i = 0; i < addressBookList.getAddressBookList().size(); i++) {
			for (int j = 0; j < addressBookList.getAddressBookList().get(i).getAddressBook().size(); j++) {
				if (addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getState().equals(state)) {
					System.out
							.print(addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getFirstName());
					System.out.print(
							" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getLastName());
					System.out.print(
							" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getAddress());
					System.out
							.print(" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getCity());
					System.out.print(
							" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getState());
					System.out
							.print(" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getZip());
					System.out.print(
							" " + addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getPhoneNo());
					System.out.print(" "
							+ addressBookList.getAddressBookList().get(i).getAddressBook().get(j).getEmailAddress());
					System.out.println();
				}
			}
		}
	}
}
