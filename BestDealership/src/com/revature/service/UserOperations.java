package com.revature.service;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.data.*;

public class UserOperations {
	static Scanner userOps = new Scanner(System.in);

	public static void systemLogIn() {
//	System.out.println("Logging you in, Shepard");
		int logInSwitch = 0;
		while (logInSwitch != 1) {
			System.out.println("Please enter your Username or press \"1\" to exit");
			String testUserName = userOps.next();
			char exitInput = 1;
			if(testUserName.length() <= 1 && testUserName.charAt(0) == exitInput) {
				logInSwitch = 1;
			} else if (LocalUserData.userDataBase.containsKey(testUserName)) {
				User currentUser = LocalUserData.userDataBase.get(testUserName);
				System.out.println("Please enter your password");
				// TODO password check against login
				String testPassword = userOps.next();
				if(currentUser.getPassword().equals(testPassword)) {
					if(currentUser.getAccessLevel() == 2) {
						employeeMainMenu();
						logInSwitch = 1;
					} else if(currentUser.getAccessLevel() == 1){
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
		System.out.println("Employee Menu... actions taken... logged out");
		
	}

	private static void employeeMainMenu() {
		System.out.println("Customer Menu... actions taken... logged out");	
	}
}
