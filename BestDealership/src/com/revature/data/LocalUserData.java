package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import com.revature.beans.User;

public class LocalUserData {
	// TODO create a data structure to hold users

	public static HashMap<String, User> userDataBase = new HashMap<>();
	public static ArrayList<String> userDataBaseIndex = new ArrayList<>();

	public static void addNewUser() {
		// TODO get input from user, May want to have different userAccountBuilders at
		// some point
		String newUserID = "Input from User Somehow";
		int accessLevel = 1; // TODO Get user input here say - "please" to get access to employee

		if (userDataBase.containsKey(newUserID)) {
			System.out.println(newUserID + " is already taken.  " + "Please select a different user name:");
			addNewUser();
		} else {
			userDataBase.put(newUserID, userAccountBuilder(newUserID, accessLevel));
			userDataBaseIndex.add(newUserID);
		}
	}

	public static User userAccountBuilder(String newUserID, int accessLevel) {
		User newUser = new User();
		newUser.setUserName(newUserID);
		newUser.setAccessLevel(accessLevel);
		newUser.setPassword("password");
		newUser.setFirstName("firstName");
		newUser.setLastName("lastName");

		return newUser;
	}

	// Method only for initializing
	public static void getUserDataBase() {
		User masterControl = new User("MasterControl", "password", "Master", "Contorl", 2);
		User testCustomer = new User("customer", "password", "Test", "Customer", 1);
		userDataBase.put("MasterControl", masterControl);
		userDataBaseIndex.add("MasterControl");
		userDataBase.put("customer", testCustomer);
		userDataBaseIndex.add("customer");
	}
}
