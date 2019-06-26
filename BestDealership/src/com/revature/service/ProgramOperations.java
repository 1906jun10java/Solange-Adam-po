package com.revature.service;

public class ProgramOperations {
	
	public static void startProgram() {
		System.out.println("--------------------------------"
				+ "\nStarting Best Dealership Interface"
				+ "\n--------------------------------\n");
		//TODO add sleep function
		//TODO add car database generator (for testing reasons)
		//TODO add user database generator (for testing reasons)
	}
	
	public static void endProgram() {
		//sign off message
		System.out.println("--------------------------------"
				+ "\nThank you for using Best Dealership Interface"
				+ "\n--------------------------------\n");
		//TODO add any networking data transfer needed
	}

	public static void logInMenu() {
		// NOTE This is the first menu the user will see.  
		// Here the user will log in or create a new account
		// evenutally an employee will be able to create an 
		//		employee account using a 'supervisor' passcode
		//		'passcode'
		
		System.out.println("Please enter: \n\"1\" to log in to an existing account, "
				+ "\n\"2\" to create a new account"
				+ "\n\"3\" to exit\n--------\n ");		
		//TODO Remove problem solve
//		String logInMenuInput = "2";
		String logInMenuInput = ScannerOperations.generalStringInput();
		String possibleEntry = "1,2,3";
		if(logInMenuInput.length() > 1 || 
				logInMenuInput.charAt(0) != possibleEntry.charAt(0) & 
				logInMenuInput.charAt(0) != possibleEntry.charAt(2) &
				logInMenuInput.charAt(0) != possibleEntry.charAt(4)) {
			System.out.println("Invalid entry ...\n");
			//TODO put in a one second sleep here
			logInMenu();
		} else if(logInMenuInput.charAt(0) == possibleEntry.charAt(0)) {
			System.out.println("Logging you in, Shepard");
		} else if(logInMenuInput.charAt(0) == possibleEntry.charAt(2)) {
			System.out.println("Creating a new account...somehow");
		}
	}
}
