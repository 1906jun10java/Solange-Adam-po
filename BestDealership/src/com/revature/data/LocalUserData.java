package com.revature.data;

import java.util.HashMap;
import java.util.Random;
import com.revature.beans.User;

public class LocalUserData {
	// TODO create a data structure to hold users


	public static HashMap<String, User> userDataBase = new HashMap<>();

	
	//TODO Change this to get the database from the server, for now - non-persistent
	public static void getUserDataBase() {
		User masterControl = new User("MasterControl", "password", "Master", "Contorl", 2);
		User testCustomer = new User("customer", "password", "Test", "Customer", 1);
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
}


