package com.capgemini.addressbook;

import java.util.Scanner;

import com.capgemini.addressbook.dto.*;
import com.capgemini.addressbook.service.implementation.PersonServiceImplementation;

public class Executer {
	public static void main(String args[]) {
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Address Book Program");
		Executer executer = new Executer();
		AddressBook addressBook = new AddressBook("first");
		TakeInput takeInput = new TakeInput();
		PersonServiceImplementation personService = new PersonServiceImplementation();
		while (true) {
			choice = executer.ChoiceInput(scan);
			switch (choice) {
			case 1:
				ContactDetails contactDetails = new ContactDetails();
				takeInput.takeInput(contactDetails, scan);
				addressBook.AddContact(contactDetails);
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

	private int ChoiceInput(Scanner scan) {
		System.out.println("Enter '1' for Add Contact");
		System.out.println("Enter '2' for Update Contact");
		System.out.println("Enter '3' for Delete Contact");
		System.out.println("Enter '4' for View Contact");
		System.out.println("Enter '5' for Exit");
		return scan.nextInt();
	}
}
