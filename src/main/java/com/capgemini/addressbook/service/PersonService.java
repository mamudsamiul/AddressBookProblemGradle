package com.capgemini.addressbook.service;

import java.util.Scanner;

import com.capgemini.addressbook.dto.AddressBook;

public interface PersonService {
	public int UpdateUser(AddressBook addressBook, Scanner scan);

	public int DeleteUser(AddressBook addressBook, Scanner scan);

	public boolean DuplicateChecker(AddressBook addressBook, String firstName, String lastName, Scanner scan);
}
