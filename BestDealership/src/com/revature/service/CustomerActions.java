package com.revature.service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import com.revature.data.FirstStructure;


public interface CustomerActions {
	ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	Scanner scannerActual = scannerRomeo.runScanner();
	
	
	public static void placeOffer() {
		System.out.println("Please select a vehicle you wish to place an offer on:");
		System.out.println("Current number of cars in inventory is:  " 
				+ FirstStructure.lotInventory.size());
		System.out.println("Please select the number of the car you wish to place an offer on: ");
		int menuPage = 0;
		int menuLimit = 5;
		int offerMenu = 1;
		while(offerMenu !=1) {
			while(menuPage <= menuLimit) {
				int c = 0;
				
				System.out.println((c+1) + ":  " 
				+ FirstStructure.lotInventory.getValue(currentCars[c]));
			}
			String carMenu = scannerActual.next();
			
		}
			
			
			
			

		
		
	}
}
