package com.capgemini.addressbook;

import java.util.Scanner;
import com.capgemini.addressbook.dto.*;
import com.capgemini.addressbook.service.implementation.AddressBookServiceImplementation;
import com.capgemini.addressbook.service.implementation.PersonServiceImplementation;

public class Executer {
	private int choice = 0;
	static Scanner scan = new Scanner(System.in);
	TakeInput takeInput = new TakeInput();
	PersonServiceImplementation personService = new PersonServiceImplementation();
	AddressBookServiceImplementation addressBookService = new AddressBookServiceImplementation();
	AddressBook addressBook;
	AddressBookList addressBookList = new AddressBookList();

	public static void main(String args[]) {
		Executer executer = new Executer();
		System.out.println("Welcome to Address Book Program");
		while (true) {
			int input;
			input = executer.MainMenu(scan);
			switch (input) {
			case 1:
				System.out.println("List of All address Book");
				executer.addressBookService.showList(executer.addressBookList);
				break;
			case 2:
				System.out.println("Enter the name of the Address Book");
				int index = executer.addressBookService.FindAddressBook(scan.next(), executer.addressBookList);
				if (index >= 0) {
					executer.addressBook = executer.addressBookList.getAddressBookList().get(index);
					executer.SecondaryMenu();
				} else
					System.out.println("Record not found!");
				break;
			case 3:
				System.out.println("Enter the name of the address Book for creation");
				executer.addressBook = new AddressBook(scan.next());
				executer.addressBookList.CreateAddressBook(executer.addressBook);
				executer.SecondaryMenu();
				break;

			case 4:
				System.out.println("Enter the name of the address Book for Delete");
				int indexAddress = executer.addressBookService.FindAddressBook(scan.next(), executer.addressBookList);
				if (indexAddress >= 0) {
					executer.addressBookList.getAddressBookList().remove(indexAddress);
					System.out.println("Entry deleted!!");
				} else
					System.out.println("Record not found!");
				break;
			case 5:
				System.out.println("Bye");
				return;
			default:
				System.out.println("Invalid Input!");
			}
		}
	}

	private int ChoiceInput(Scanner scan) {
		System.out.println("Enter '1' for Add Contact");
		System.out.println("Enter '2' for Update Contact");
		System.out.println("Enter '3' for Delete Contact");
		System.out.println("Enter '4' for View Contact");
		System.out.println("Enter '5' for Exit");
		return scan.nextInt();
	}

	private int MainMenu(Scanner scan) {
		System.out.println("Enter '1' To Get the Address Book List");
		System.out.println("Enter '2' To enter into an address book");
		System.out.println("Enter '3' to add new address book");
		System.out.println("Enter '4' to delete an address Book");
		System.out.println("Enter '5' for EXIT");
		return scan.nextInt();
	}

	private void SecondaryMenu() {
		while (true) {
			choice = ChoiceInput(scan);
			switch (choice) {
			case 1:
				ContactDetails contactDetails = new ContactDetails();
				if (takeInput.takeInput(contactDetails, addressBook, scan))
					addressBook.AddContact(contactDetails);
				else
					System.out.println("Duplicate Entry!");
				break;
			case 2:
				personService.UpdateUser(addressBook, scan);
				System.out.println("Updated!");
				break;
			case 3:
				personService.DeleteUser(addressBook, scan);
				System.out.println("Data Deleted!");
				break;
			case 4:
				addressBook.ShowContact();
				break;
			case 5:
				System.out.println("Exiting from Address Book Program");
				return;
			default:
				System.out.println("Enter valid input");
				break;
			}
		}
	}
}
