package com.revature.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.data.*;

public class UserMenu {
	static Scanner userOps = new Scanner(System.in);
	public static String currentUserName = "test";

	public static void systemLogIn() {
		int logInSwitch = 0;
		while (logInSwitch != 1) {
			System.out.println("Please enter your Username or press \"1\" to exit");
			String testUserName = userOps.next();
			String a = "1";
			if (testUserName.charAt(0) == a.charAt(0) & testUserName.length() == 1) {
				logInSwitch = 1;
			} else if (LocalUserData.userDataBase.containsKey(testUserName)) {
				User currentUser = LocalUserData.userDataBase.get(testUserName);
				System.out.println("Please enter your password");
				// TODO password check against login
				String testPassword = userOps.next();
				if (currentUser.getPassword().equals(testPassword)) {
					if (currentUser.getAccessLevel() == 2) {
						employeeMainMenu(currentUser);
						logInSwitch = 1;
					} else if (currentUser.getAccessLevel() == 1) {
						currentUserName = testUserName;
						customerMainMenu(currentUser);
						logInSwitch = 1;
					}
				} else {
					System.out.println("Log in information is incorrect");
					systemLogIn();
				}
			}
		}
	}

	private static void customerMainMenu(User currentUser) {
		System.out.println(
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" 
						+ "--------Customer Menu--------");
		int stayLoggedIn = 1;
		while (stayLoggedIn == 1) {
			System.out.println("Please enter: \n\"1\" to view our current inventory and place an offer, "
					+ "\n\"2\" to view your current offers" 
					+ "\n\"3\" to view your current loans and make payments" 
					+ "\n\"4\" to exit\n--------\n ");
			// TODO Remove problem solve
//			String logInMenuInput = "2";
			String logInMenuInput = ZzFirstTryAtScannerSingleton.generalStringInput();
			String possibleEntry = "1,2,3,4";
			if (logInMenuInput.length() < 2 & logInMenuInput.charAt(0) != possibleEntry.charAt(0)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(2)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(4)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(6)) {
				System.out.println("Invalid entry ...\n");
				// TODO put in a one second sleep here

			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(0)) {
				// place offer menu
				CustomerOffers.placeOffer(0, 1, currentUser);

			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(2)) {
				System.out.println("Viewing your cars");
				OffersData.showMyOffers(currentUser);

			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(4)) {
				System.out.println("Viewing Loans");
				CustomerOffers.findMyLoans(0, 1, currentUser);

			}	else if (logInMenuInput.charAt(0) == possibleEntry.charAt(6)) {
				System.out.println("Logging you out");
				stayLoggedIn = 0;
			}
			
		}
	}

	private static void employeeMainMenu(User currentUser) {
		System.out.println(
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" 
						+ "--------Employee Menu--------");
		int stayLoggedIn = 1;
		while (stayLoggedIn == 1) {
			System.out.println("Please enter: \n\"1\" to add a vehicle to the lot "
					+ "\n\"2\" to remove a vehicle from the lot" + "\n\"3\" to review current offers"
					+ "\n\"4\" see current loans" + "\n\"5\" see loan payments made by name"
					+ "\n\"6\" to exit\n--------\n ");
			// TODO Remove problem solve
//			String logInMenuInput = "2";
			String logInMenuInput = ZzFirstTryAtScannerSingleton.generalStringInput();
			String possibleEntry = "1,2,3,4,5,6";
			if (logInMenuInput.length() < 2 & logInMenuInput.charAt(0) != possibleEntry.charAt(0)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(2)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(4)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(6)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(8)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(10)) {
				System.out.println("Invalid entry ...\n");
				// TODO put in a one second sleep here

			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(0)) {
				System.out.println("Adding car to lot");
				ProgramOperations.vehicleAdder(1, 1);

			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(2)) {
				// TODO car select menu to Remove
				EmployeeOperations.findInventory(0, 1);

			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(4)) {
				// TODO See offers and review
				EmployeeOperations.findCurrentOffers(0, 1, currentUser);

			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(6)) {
				// TODO See Payments
				EmployeeOperations.findCurrentSoldCars(0, 1, currentUser);
			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(8)) {
				// TODO See Payments
				EmployeeOperations.findPayments();
			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(10)) {
				System.out.println("Logging you out");
				stayLoggedIn = 0;
			}
		}
	}
}
