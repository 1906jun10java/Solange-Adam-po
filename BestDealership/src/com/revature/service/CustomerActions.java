package com.revature.service;

import java.util.Scanner;

import com.revature.data.FirstStructure;
import com.revature.data.OffersData;

public interface CustomerActions {
	ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	Scanner scannerActual = scannerRomeo.runScanner();

	public static void placeOffer(int indexMover, int pageMover) // first call of this needs to be 0, 1
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
			offerMenu(carMenu, currentIndex, pageNumber);
			offerMenuBreak = 1;
		}
	}

	public static int offerMenu(String carMenu, int currentIndex, int pageNumber) {
		int menuChoice = 0;
		String possibleEntry = ("1,2,3,4,5,6,7");
		if (carMenu.length() > 1 || carMenu.charAt(0) != possibleEntry.charAt(0)
				& carMenu.charAt(0) != possibleEntry.charAt(2) & carMenu.charAt(0) != possibleEntry.charAt(4)
				& carMenu.charAt(0) != possibleEntry.charAt(6) & carMenu.charAt(0) != possibleEntry.charAt(8)
				& carMenu.charAt(0) != possibleEntry.charAt(10) & carMenu.charAt(0) != possibleEntry.charAt(12)) {
			System.out.println("Please enter 1 - 7");
			offerMenu(scannerActual.next(), currentIndex, pageNumber);
		} else {
			switch (carMenu) {
			case "1":
				System.out.println("Creating Offer for:  " + FirstStructure.usedSKU.get(currentIndex + 0));
				OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 0));
				menuChoice = 1;
				break;
			case "2":
				System.out.println("Creating Offer for:  " + currentIndex + 1);
				OffersData.createOffer(currentIndex + 1);
				menuChoice = 2;
				break;
			case "3":
				System.out.println("Creating Offer for:  " + currentIndex);
				OffersData.createOffer(currentIndex + 0);
				menuChoice = 3;
				break;
			case "4":
				System.out.println("Creating Offer for:  " + currentIndex);
				OffersData.createOffer(currentIndex + 0);
				menuChoice = 4;
				break;
			case "5":
				System.out.println("Creating Offer for:  " + currentIndex);
				OffersData.createOffer(currentIndex + 0);
				menuChoice = 5;
				break;
			case "6":
				int indexMover = currentIndex + 5;
				int pageMover = pageNumber + 1;
				placeOffer(indexMover, pageMover);
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
