package com.revature.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.data.FirstStructure;


public class EmployeeOperations {
	static ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	static Scanner scannerActual = scannerRomeo.runScanner();
	public static Logger log = Logger.getRootLogger();
	
	public static void findInventory(int indexMover, int pageMover) // first call of this needs to be 0, 1
	{
		int currentIndex = 0 + indexMover;
		int indexLimit = 5 + indexMover;
		int offerMenuBreak = 0;
		int pageNumber = 0 + pageMover;
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Please select a vehicle you wish to place an offer on:");
		System.out.println("Current number of cars in inventory is:  " + FirstStructure.lotInventory.size());
		System.out.println("Page " + pageNumber);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Please select the number of the car you wish to place an offer on:  \n");

		while (offerMenuBreak != 1) {
			// TODO Fix this statement
			FirstStructure.carViewer(currentIndex, FirstStructure.lotInventory.size() - (currentIndex));
			System.out.println("6:  For The Next Page\n");
			System.out.println("7:  To Exit");
			String carMenu = scannerActual.next();
			inventoryMenu(carMenu, currentIndex, pageNumber);
			offerMenuBreak = 1;
		}
	}
	
	
	public static int inventoryMenu(String carMenu, int currentIndex, int pageNumber) {
		int menuChoice = 0;
		String possibleEntry = ("1,2,3,4,5,6,7");
		if (carMenu.length() > 1 || carMenu.charAt(0) != possibleEntry.charAt(0)
				& carMenu.charAt(0) != possibleEntry.charAt(2) & carMenu.charAt(0) != possibleEntry.charAt(4)
				& carMenu.charAt(0) != possibleEntry.charAt(6) & carMenu.charAt(0) != possibleEntry.charAt(8)
				& carMenu.charAt(0) != possibleEntry.charAt(10) & carMenu.charAt(0) != possibleEntry.charAt(12)) {
			System.out.println("Please enter 1 - 7");
			inventoryMenu(scannerActual.next(), currentIndex, pageNumber);
		} else {
			switch (carMenu) {
			case "1":
				System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 0));
				System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
//				OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 0), getOffer());
				menuChoice = 1;
				break;
			case "2":
				try {
					System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 1));
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
//					OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 1), getOffer());
				} catch (Exception e) {
					System.out.println("Invaid selection, but congratulatios.  "
							+ "This invalid excption only happens in super special situations");
					log.info(e);
				}
				menuChoice = 2;
				break;
			case "3":
				try {
					System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 2));
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
//					OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 2), getOffer());
				} catch (Exception e) {
					System.out.println("Invaid selection, but congratulatios.  "
							+ "This invalid excption only happens in super special situations");
					log.info(e);
				}
				break;
			case "4":
				try {
					System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 3));
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
//					OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 3), getOffer());
				} catch (Exception e) {
					System.out.println("Invaid selection, but congratulatios.  "
							+ "This invalid excption only happens in super special situations");
					log.info(e);
				}
				break;
			case "5":
				try {
					System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 4));
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
//					OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 4), getOffer());
				} catch (Exception e) {
					System.out.println("Invaid selection, but congratulatios.  "
							+ "This invalid excption only happens in super special situations");
					log.info(e);
				}
				break;
			case "6":
				int indexMover = currentIndex + 5;
				int pageMover = pageNumber + 1;
				findInventory(indexMover, pageMover);
				menuChoice = 6;
				break;
			case "7":
				menuChoice = 7;
				break;
			}

		}
		return menuChoice;
	}

}
