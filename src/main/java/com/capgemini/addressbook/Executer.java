package com.capgemini.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.capgemini.addressbook.dto.*;
import com.capgemini.addressbook.service.implementation.AddressBookServiceImplementation;
import com.capgemini.addressbook.service.implementation.PersonServiceImplementation;

import jdk.internal.misc.FileSystemOption;

public class Executer {
	private int choice = 0;
	static Scanner scan = new Scanner(System.in);
	TakeInput takeInput = new TakeInput();
	PersonServiceImplementation personService = new PersonServiceImplementation();
	AddressBookServiceImplementation addressBookService = new AddressBookServiceImplementation();
	AddressBook addressBook;
	AddressBookList addressBookList = new AddressBookList();
	AddressBook personByState;
	AddressBook personByCity;
	AddressBookList stateList = new AddressBookList();
	AddressBookList cityList = new AddressBookList();

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
				int counter=0;
				System.out.println("Please enter the city name:");
				String inputState=scan.next();
				executer.addressBookService.SearchByCity(executer.addressBookList, inputState);
				int indexPerson=executer.addressBookService.countPersonByState(executer.cityList, inputState);
				ArrayList<ContactDetails> list=executer.cityList.getAddressBookList().get(indexPerson).getAddressBook();
				counter+= list.stream().filter(obj->obj.getCity().equals(inputState)).count();
				
				break;
			case 6:
				int counter1=0;
				System.out.println("Please enter the State name:");
				String inputCity=scan.next();
				executer.addressBookService.SearchByState(executer.addressBookList, inputCity);
				int indexPerson1=executer.addressBookService.countPersonByState(executer.stateList, inputState);
				ArrayList<ContactDetails> list1=executer.stateList.getAddressBookList().get(indexPerson1).getAddressBook();
				counter1+= list1.stream().filter(obj->obj.getState().equals(inputState)).count();
				break;
			case 7:
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
		System.out.println("Enter '5' to Find person by city");
		System.out.println("Enter '6' to Find person by State");
		System.out.println("Enter '7' for EXIT");
		return scan.nextInt();
	}

	private void SecondaryMenu() {
		while (true) {
			choice = ChoiceInput(scan);
			switch (choice) {
			case 1:
				ContactDetails contactDetails = new ContactDetails();
				if (takeInput.takeInput(contactDetails, addressBook, scan)) {
					addressBook.AddContact(contactDetails);
					addressBookService.AddStateToDictionary(stateList, contactDetails);
					addressBookService.AddCityToDictionary(stateList, contactDetails);
				} else
					System.out.println("Duplicate Entry!");

				break;
			case 2:
				int index = personService.UpdateUser(addressBook, scan);
				addressBookService.deleteStateFromDictionary(stateList, index, addressBook);
				addressBookService.convertState(stateList, index, addressBook);
				addressBookService.convertCity(cityList, index, addressBook);
				System.out.println("Updated!");
				break;
			case 3:
				int indexAdd = personService.DeleteUser(addressBook, scan);
				addressBookService.deleteStateFromDictionary(stateList, indexAdd, addressBook);
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
