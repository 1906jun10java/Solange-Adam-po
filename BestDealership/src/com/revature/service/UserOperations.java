package com.revature.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.data.*;

public class UserOperations {
	static Scanner userOps = new Scanner(System.in);
	public static ArrayList<String> currentUserList = new ArrayList<>();

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
						employeeMainMenu();
						logInSwitch = 1;
					} else if (currentUser.getAccessLevel() == 1) {
						currentUserList.add(testUserName);
						customerMainMenu();
						logInSwitch = 1;
					}
				} else {
					System.out.println("Log in information is incorrect");
					systemLogIn();
				}
			}
		}
	}

	private static void customerMainMenu() {
		// TODO
		int stayLoggedIn = 1;
		while (stayLoggedIn == 1) {
			System.out.println("Please enter: \n\"1\" to view our current inventory and place an offer, "
					+ "\n\"2\" to view your current owned vehicles and offers" + "\n\"3\" to exit\n--------\n ");
			// TODO Remove problem solve
//			String logInMenuInput = "2";
			String logInMenuInput = ScannerOperations.generalStringInput();
			String possibleEntry = "1,2,3";
			if (logInMenuInput.length() > 1 || logInMenuInput.charAt(0) != possibleEntry.charAt(0)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(2)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(4)) {
				System.out.println("Invalid entry ...\n");
				// TODO put in a one second sleep here
				
			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(0)) {
				// place offer menu
				CustomerOffers.placeOffer(0, 1);

			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(2)) {
				System.out.println("Viewing your cars");
				OffersData.showOffers();
				// view owned cars and offers
			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(4)) {
				System.out.println("Logging you out");
				stayLoggedIn = 0;
				//exit the menus and program
			}
		}
	}

	private static void employeeMainMenu() {
		System.out.println("Employee Menu... actions taken... logged out");
	}

}
