package com.capgemini.addressbook.service.implementation;

import com.capgemini.addressbook.dto.AddressBook;
import com.capgemini.addressbook.dto.AddressBookList;
import com.capgemini.addressbook.dto.ContactDetails;
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

	@Override
	public void AddStateToDictionary(AddressBookList addressBookList, ContactDetails contactDetails) {
		int indexAddress = FindAddressBook(contactDetails.getState(), addressBookList);
		if (indexAddress < 0) {
			AddressBook addressBook = new AddressBook(contactDetails.getState());
			addressBook.AddContact(contactDetails);

		} else {
			addressBookList.getAddressBookList().get(indexAddress).AddContact(contactDetails);
		}
	}

	@Override
	public void AddCityToDictionary(AddressBookList addressBookList, ContactDetails contactDetails) {
		int indexAddress = FindAddressBook(contactDetails.getCity(), addressBookList);
		if (indexAddress < 0) {
			AddressBook addressBook = new AddressBook(contactDetails.getCity());
			addressBook.AddContact(contactDetails);

		} else {
			addressBookList.getAddressBookList().get(indexAddress).AddContact(contactDetails);
		}

	}

	public void convertState(AddressBookList stateList, int index, AddressBook addressBook) {
		ContactDetails contactDetails = addressBook.getAddressBook().get(index);
		AddStateToDictionary(stateList, contactDetails);
	}

	public void convertCity(AddressBookList cityList, int index, AddressBook addressBook) {
		ContactDetails contactDetails = addressBook.getAddressBook().get(index);
		AddStateToDictionary(cityList, contactDetails);
	}

	@Override
	public void deleteStateFromDictionary(AddressBookList stateList, int index, AddressBook addressBook) {
		ContactDetails contactDetails = addressBook.getAddressBook().get(index);
		int indexAddress = FindAddressBook(contactDetails.getState(), stateList);
		stateList.getAddressBookList().remove(index);

	}

	@Override
	public void deleteCityFromDictionary(AddressBookList cityList, int index, AddressBook addressBook) {
		ContactDetails contactDetails = addressBook.getAddressBook().get(index);
		int indexAddress = FindAddressBook(contactDetails.getCity(), cityList);
		cityList.getAddressBookList().remove(index);

	}
	public int countPersonByState(AddressBookList stateList ,String state) {
		for(int i=0;i<stateList.getAddressBookList().size();i++) {
			if(stateList.getAddressBookList().get(i).getName().equals(state)){
				return i;
			}
		}
		return -1;
	}
	public int countPersonByCity(AddressBookList cityList ,String city) {
		for(int i=0;i<cityList.getAddressBookList().size();i++) {
			if(cityList.getAddressBookList().get(i).getName().equals(city)){
				return i;
			}
		}
		return -1;
	}
}
