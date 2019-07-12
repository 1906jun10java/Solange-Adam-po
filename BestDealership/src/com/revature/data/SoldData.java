package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Offer;
import com.revature.service.ScannerFinder;

public class SoldData {
	ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	Scanner scannerActual = scannerRomeo.runScanner();
	public static Logger log = Logger.getRootLogger();
	public static HashMap<Integer, Offer> soldCars = new HashMap<>();
	// All offer objects
	public static ArrayList<Integer> soldCarsIndex = new ArrayList<>();
	
	public static void acceptOffer() {
		//TODO create loan object
		//TODO add lone id to Array
		//TODO add loan to Map(id, loan)
		//TODO remove offer from offer map/array
		//TODO remove car from lot
	}
	
	public static loan buildLoan(all the stuff for a constructor) {
		return loan;
	}
	
	
	
	
}
