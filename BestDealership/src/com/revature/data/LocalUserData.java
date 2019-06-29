package com.revature.data;

import java.util.HashMap;
import java.util.Random;
import com.revature.beans.User;

public class LocalUserData {
	// TODO create a data structure to hold users


	static HashMap<String, User> userDataBase = new HashMap<>();

	
	//TODO Change this to get the database from the server, for now - non-persistent
	public static void getUserDataBase() {
		User masterControl = new User("MasterControl", "password", "Master", "Contorl", 1, 0);
		User testCustomer = new User("customer", "password", "Test", "Customer", 0, 0);
		userDataBase.put("MasterControl", masterControl);
		userDataBase.put("customer", testCustomer);
		System.out.println(userDataBase.values());
	}

	public static void addNewUser() {
		//TODO get input from user, May want to have different userAccountBuilders at some point 
		String newUserID = "Input from User Somehow";
		int accessLevel = 1;  //TODO Get user input here say - "please" to get access to employee
		
		if (userDataBase.containsKey(newUserID)) {
			System.out.println(newUserID + " is already taken.  "
					+ "Please select a different user name:");
			addNewUser();
		} else {
			userDataBase.put(newUserID, userAccountBuilder(newUserID, accessLevel));
		}
	}

	public static User userAccountBuilder(String newUserID, int accessLevel) {
		User newUser = new User();
		newUser.setUserName(newUserID);
		newUser.setAccessLevel(accessLevel);
		newUser.setPassword("password"); //TODO Get User Input for all of these
		newUser.setFirstName("firstName");
		newUser.setLastName("lastName");
		
		
		
		return newUser;
	}

	private static int randomYear() {
		Random randInt = new Random();
		int yearDecider = randInt.nextInt((1959 - 1955) + 1) + 1955;
		return yearDecider;
	}

	private static int randomMiles() {
		Random randInt = new Random();
		int milesDecider = randInt.nextInt((25000 - 500) + 1) + 500;
		return milesDecider;
	}

	private static String randomColor() {
		Random randInt = new Random();
		int colorDecider = randInt.nextInt(6) + 1;
		String nextColor = "nextColor";
		switch (colorDecider) {
		case 1:
			nextColor = "Teal";
			break;
		case 2:
			nextColor = "Seafoam Green";
			break;
		case 3:
			nextColor = "Indigo";
			break;
		case 4:
			nextColor = "Coral";
			break;
		case 5:
			nextColor = "Salmon";
			break;
		case 6:
			nextColor = "Magnolia";
			break;
		}
		return nextColor;
	}

	private static String randomModel(String nextMake) {
		Random randInt = new Random();
		int modelDecider = randInt.nextInt(3) + 1;
		String nextModel = "nextModel";
		switch (nextMake) {
		case "Dodge":
			switch (modelDecider) {
			case 1:
				nextModel = "Royal Lancer";
				break;
			case 2:
				nextModel = "Coronet";
				break;
			case 3:
				nextModel = "C-Series Truck";
				break;
			}
			break;
		case "Chrysler":
			switch (modelDecider) {
			case 1:
				nextModel = "300";
				break;
			case 2:
				nextModel = "Imperial";
				break;
			case 3:
				nextModel = "New Yorker";
				break;
			}
			break;
		case "DeSoto":
			switch (modelDecider) {
			case 1:
				nextModel = "FireDome";
				break;
			case 2:
				nextModel = "Adventurer";
				break;
			case 3:
				nextModel = "FireFlite";
				break;
			}
			break;
		}		
		return nextModel;
	}

	public static String randomMake() {
		Random randInt = new Random();
		int makeDecider = randInt.nextInt(3) + 1;
		String nextMake = "nextMake";
		switch (makeDecider) {
		case 1:
			nextMake = "Dodge";
			break;
		case 2:
			nextMake = "Chrysler";
			break;
		case 3:
			nextMake = "DeSoto";
			break;
		}
		return nextMake;
	}

}


