package com.capgemini.addressbook.dto;

import java.util.Scanner;

public class ChoiceForEdit {
	private Scanner scan;
	public ChoiceForEdit(Scanner scan) {
		this.scan=scan;
	}
	public int TakeChoice() {
		System.out.println("Enter '1' to edit First Name");
		System.out.println("Enter '2' to edit Last Name");
		System.out.println("Enter '3' to edit Address");
		System.out.println("Enter '4' to edit city");
		System.out.println("Enter '5' to edit state");
		System.out.println("Enter '6' to edit zip");
		System.out.println("Enter '7' to edit Phone Number");
		System.out.println("Enter '8' to edit Email Address");
		System.out.println("Enter '9' to exit");
		return scan.nextInt();
	}
}
