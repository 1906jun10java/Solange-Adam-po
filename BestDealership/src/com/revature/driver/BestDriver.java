package com.revature.driver;

import com.revature.data.FirstStructure;
import com.revature.data.LocalUserData;
import com.revature.service.ProgramOperations;

public class BestDriver {

	public static void main(String[] args) {
		ProgramOperations.startProgram();
		ProgramOperations.logInMenu();
		
		LocalUserData.getUserDataBase();
//		FirstStructure.lotInventoryPrint();
		//TODO add more methods of the program
		ProgramOperations.endProgram();

	}
	
	
	//TODO REMOVE - Git Hub setup test for feature-driver
	//D:\005_Java\Solange-Adam-po\BestDealership\src\com\revature\driver

}
