package com.capgemini.addressbook.service.implementation;

import java.util.Scanner;

import com.capgemini.addressbook.dto.AddressBook;
import com.capgemini.addressbook.dto.ChoiceForEdit;
import com.capgemini.addressbook.dto.DetailsChecking;
import com.capgemini.addressbook.service.PersonService;

public class PersonServiceImplementation implements PersonService {
	private int choice;

	public PersonServiceImplementation() {
	}

	@Override
	public int UpdateUser(AddressBook addressBook, Scanner scan) {
		DetailsChecking detailsChecking = new DetailsChecking(addressBook, scan);
		ChoiceForEdit choiceForEdit = new ChoiceForEdit(scan);
		int addressBookIndex = detailsChecking.validate();
		if (addressBookIndex != -1) {
			while (true) {
				choice = choiceForEdit.TakeChoice();
				switch (choice) {
				case 1:
					System.out.println("Enter new first Name: ");
					String firstName = scan.next();
					addressBook.getAddressBook().get(addressBookIndex).setFirstName(firstName);
					break;
				case 2:
					System.out.println("Enter new Last Name: ");
					String lastName = scan.next();
					addressBook.getAddressBook().get(addressBookIndex).setLastName(lastName);
					break;
				case 3:
					System.out.println("Enter new Address: ");
					String address = scan.next();
					addressBook.getAddressBook().get(addressBookIndex).setAddress(address);
					break;
				case 4:
					System.out.println("Enter new city: ");
					String city = scan.next();
					addressBook.getAddressBook().get(addressBookIndex).setCity(city);
					break;
				case 5:
					System.out.println("Enter new state: ");
					String state = scan.next();
					addressBook.getAddressBook().get(addressBookIndex).setState(state);
					break;
				case 6:
					System.out.println("Enter new Zip: ");
					String zip = scan.next();
					addressBook.getAddressBook().get(addressBookIndex).setZip(zip);
					break;
				case 7:
					System.out.println("Enter new Phone Number: ");
					String phoneNo = scan.next();
					addressBook.getAddressBook().get(addressBookIndex).setPhoneNo(phoneNo);
					break;
				case 8:
					System.out.println("Enter new Email: ");
					String email = scan.next();
					addressBook.getAddressBook().get(addressBookIndex).setEmailAddress(email);
					break;
				case 9:
					System.out.println("Going Back to main menu");
					return addressBookIndex;
				default:
					System.out.println("Invalid Input");
					break;
				}
			}
		}
		return addressBookIndex;
	}

	@Override
	public int DeleteUser(AddressBook addressBook, Scanner scan) {
		DetailsChecking detailsChecking = new DetailsChecking(addressBook, scan);
		int addressBookIndex = detailsChecking.validate();
		addressBook.getAddressBook().remove(addressBookIndex);
		return addressBookIndex;
	}

	@Override
	public boolean DuplicateChecker(AddressBook addressBook, String firstName, String lastName, Scanner scan) {
		for (int i = 0; i < addressBook.getAddressBook().size(); i++) {
			if (addressBook.getAddressBook().get(i).getFirstName().equals(firstName)
					&& addressBook.getAddressBook().get(i).getLastName().equals(lastName))
				return false;
		}
		return true;
	}
}
