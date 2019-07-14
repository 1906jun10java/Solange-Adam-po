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
		ProgramOperations.endProgram();
		//sc.close();
	}


	public static void testMethod() {
		try {
			throw new NullPointerException("go!");
		}
		catch(NullPointerException e) {
			System.out.println("ARMS for data structure");
			log.error("attempt to enter error log go!" + e.getStackTrace());
		}
	}
}
