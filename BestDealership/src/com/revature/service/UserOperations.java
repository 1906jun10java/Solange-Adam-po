package com.revature.service;

public class UserOperations {

	public static void systemLogIn() {
//	System.out.println("Logging you in, Shepard");
		int logInSwitch = 0;
		while (logInSwitch != 1) {
			System.out.println("Please enter your Username");
			// TODO get username
			System.out.println("Please enter your password");
			// TODO password check agains login
			if(logIn check true) {
				if(Employee) {
					logInSwitch = 1;
					employeeMainMenu();
				} else {
					logInSwitch = 1;
					customerMainMenu();
				}
			} else {
				System.out.println("Log in information is incorrect");
				systemLogIn();
			}
		}
	}

	private static void customerMainMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void employeeMainMenu() {
		// TODO Auto-generated method stub
		
	}
}
