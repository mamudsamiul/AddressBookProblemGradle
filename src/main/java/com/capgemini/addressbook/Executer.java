package com.capgemini.addressbook;

import java.util.Scanner;

import com.capgemini.addressbook.dto.*;

public class Executer {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Address Book Program");
		ContactDetails contactDetails = new ContactDetails();
		AddressBook addressBook = new AddressBook("first");
		TakeInput takeInput = new TakeInput();
		takeInput.takeInput(contactDetails, scan);
		addressBook.AddContact(contactDetails);
	}
}
