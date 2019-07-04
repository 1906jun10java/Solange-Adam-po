package com.revature.driver;

import com.revature.data.FirstStructure;
import com.revature.data.LocalUserData;
import com.revature.service.ProgramOperations;
import org.apache.log4j.*;

public class BestDriver {
	private static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		ProgramOperations.startProgram();
		ProgramOperations.logInMenu();

//		testMethod();
//		FirstStructure.lotInventoryPrint();
		//TODO add more methods of the program
		ProgramOperations.endProgram();
		
		
		//sc.close();

	}
	 //did something

	public static void testMethod() {
		// TODO Auto-generated method stub
		try {
			throw new NullPointerException("go!");
		}
		catch(NullPointerException e) {
			System.out.println("ARMS for data structure");
			log.error("attempt to enter error log go!" + e.getStackTrace());
			// rethrowing the exception
		}
		
	}
	
	//TODO REMOVE - Git Hub setup test for feature-driver
	//D:\005_Java\Solange-Adam-po\BestDealership\src\com\revature\driver

}
