package com.revature.service;

import java.util.Scanner;

import com.revature.data.FirstStructure;
import com.revature.data.LocalUserData;

public class ProgramOperations {
	
	//TODO Replace limited scope Scanner with this Scanner
	ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	Scanner scannerActual = scannerRomeo.runScanner();

	public static void startProgram() {
		System.out.println("--------------------------------" + "\nStarting Best Dealership Interface"
				+ "\n--------------------------------\n");
		// TODO add sleep function
		vehicleAdder(3);
		LocalUserData.getUserDataBase();
//		FirstStructure.lotInventoryPrint();
		// TODO add user database generator (for testing reasons)
	}

	public static void endProgram() {
		// sign off message
		System.out.println("--------------------------------" + "\nThank you for using Best Dealership Interface"
				+ "\n--------------------------------\n");
		// TODO add any networking data transfer needed
	}

	public static void logInMenu() {
		// NOTE This is the first menu the user will see.
		// Here the user will log in or create a new account
		// Eventually an employee will be able to create an
		// employee account using a 'supervisor' passcode
		// 'passcode'

		System.out.println("Please enter: \n\"1\" to log in to an existing account, "
				+ "\n\"2\" to create a new account" + "\n\"3\" to exit\n--------\n ");
		// TODO Remove problem solve
//		String logInMenuInput = "2";
		String logInMenuInput = ScannerOperations.generalStringInput();
		String possibleEntry = "1,2,3";
		if (logInMenuInput.length() > 1 || logInMenuInput.charAt(0) != possibleEntry.charAt(0)
				& logInMenuInput.charAt(0) != possibleEntry.charAt(2)
				& logInMenuInput.charAt(0) != possibleEntry.charAt(4)) {
			System.out.println("Invalid entry ...\n");
			// TODO put in a one second sleep here
			logInMenu();
		} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(0)) {
			UserOperations.systemLogIn();

		} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(2)) {
			System.out.println("Creating a new account...somehow");
		}
	}

	public static void vehicleAdder(int newCarNumber) {
		while (newCarNumber > 0) {
			FirstStructure.buildTestLot();
			newCarNumber--;
		}
	}
}
