package com.revature.service;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.connection.AllDataDAOImpl;
import com.revature.data.FirstStructure;
import com.revature.data.LocalUserData;
import com.revature.driver.CustomExceptions;

public class ProgramOperations {

	// TODO Replace limited scope Scanner with this Scanner
	static ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	static Scanner scannerActual = scannerRomeo.runScanner();

	public static Logger log = Logger.getRootLogger();
	static CustomExceptions e = new CustomExceptions(
			"WARN:  Invalid password entry for new " + "employee account creation");

	public static boolean startProgram() {
		System.out.println("--------------------------------" + "\nStarting Best Dealership Interface"
				+ "\n--------------------------------\n");
		try {
			TimeUnit.MILLISECONDS.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("...");
//		vehicleAdder(4, 0);
		AllDataDAOImpl aDDI = new AllDataDAOImpl();
		try {
			aDDI.syncCarsDown(FirstStructure.lotInventory, FirstStructure.usedSKU);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			log.error(e1);
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(400);
		} catch (InterruptedException e) {
			log.warn(e);
		}
		LocalUserData.getUserDataBase();
//		FirstStructure.lotInventoryPrint();
		// TODO add user database generator (for testing reasons)
		return true;
	}

	public static void endProgram() {
		// sign off message
		System.out.println("--------------------------------" + "\nThank you for using Best Dealership Interface"
				+ "\n--------------------------------\n");
		AllDataDAOImpl aDDI = new AllDataDAOImpl();
		try {
			aDDI.syncCarsUp(FirstStructure.lotInventory, FirstStructure.usedSKU);
		} catch (SQLException e1) {

//			e1.printStackTrace();
			log.error(e1);
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			log.warn(e);
		}
		System.out.println("End of Line");
		// TODO add any networking data transfer needed
	}

	public static void logInMenu() {
		// NOTE This is the first menu the user will see.
		// Here the user will log in or create a new account
		// Eventually an employee will be able to create an
		// employee account using a 'supervisor' passcode
		// 'passcode'

		int stayOn = 1;
		while (stayOn == 1) {
			System.out.println("\nPlease enter: \n\"1\" to log in to an existing account, "
					+ "\n\"2\" to create a new account" + "\n\"3\" to exit\n--------\n ");
			// TODO Remove problem solve
//		String logInMenuInput = "2";
			String logInMenuInput = ZzFirstTryAtScannerSingleton.generalStringInput();
			String possibleEntry = "1,2,3";
			if (logInMenuInput.length() > 1 || logInMenuInput.charAt(0) != possibleEntry.charAt(0)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(2)
					& logInMenuInput.charAt(0) != possibleEntry.charAt(4)) {
				System.out.println("Invalid entry ...\n");
				// TODO put in a one second sleep here
				logInMenu();
			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(0)) {
				UserMenu.systemLogIn();
			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(2)) {
				createNewAccount();
			} else if (logInMenuInput.charAt(0) == possibleEntry.charAt(4)) {
				stayOn = 0;
			}
		}
	}

	private static boolean createNewAccount() {
		int accessLevel = employeeQuestionGo();
		if (accessLevel != 0) {
			String testUserName = createUserName();
			System.out.println("Please enter your password - write it down as you will have to contact \n"
					+ "your system administrator to retrieve lost passwords.");
			String password = scannerActual.next();
			System.out.println("Please enter your first name.");
			String firstName = scannerActual.next();
			System.out.println("Please enter your last name.");
			String lastName = scannerActual.next();

			User newUser = new User(testUserName, password, firstName, lastName, accessLevel);
			LocalUserData.userDataBase.put(testUserName, newUser);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Creating your account...");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	public static String createUserName() {
		System.out.println("Please enter a new user name.  User names must be more than two letters long");
		String testUserName = scannerActual.next();
		if (LocalUserData.userDataBase.containsKey(testUserName)) {
			System.out.println("That name has already been taken.\n");
			createUserName();
		}
		if (testUserName.length() == 0 || testUserName.length() == 1) {
			System.out.println("Invalid entry");
			createUserName();
		}
		return testUserName;
	}

	public static int employeeQuestionGo() {
		System.out.println("Are you an employee?  Press \"1\" for 'Yes'    Press \"2\" for 'No'  Press\"3\" to Cancel");
		String employeeQuestion = scannerActual.next();
		int accessLevel = 0;
		String possibleEntry = "1,2,3";
		if (employeeQuestion.length() > 1 || employeeQuestion.charAt(0) != possibleEntry.charAt(0)
				& employeeQuestion.charAt(0) != possibleEntry.charAt(2)
				& employeeQuestion.charAt(0) != possibleEntry.charAt(4)) {
			System.out.println("Invalid entry...");
			employeeQuestionGo();
		}
		if (employeeQuestion.equals("1")) {
			System.out.println("Please enter supervisor password");
			String password = scannerActual.next();
			if (password.equals(LocalUserData.userDataBase.get("MasterControl").getPassword())) {
				accessLevel = 2;
				System.out.println("Hello Employee");
			} else {
				System.out.println("Incorrect password, please start again...");
				log.info(e);
				accessLevel = 0;

			}
		}
		if (employeeQuestion.equals("2")) {
			accessLevel = 1;
		}
		if (employeeQuestion.equals("3")) {
			accessLevel = 0;
		}

		return accessLevel;
	}

	public static void vehicleAdder(int newCarNumber, int loudOn) {
		while (newCarNumber > 0) {
			FirstStructure.buildTestLot(loudOn);
			newCarNumber--;
		}
	}

}
