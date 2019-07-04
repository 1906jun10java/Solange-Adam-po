package com.revature.service;

import java.util.Scanner;

import com.revature.data.FirstStructure;

public interface CustomerActions {
	ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	Scanner scannerActual = scannerRomeo.runScanner();

	public static void placeOffer(int indexMover, int pageMover) // first call of this needs to be 0, 0
	{
		int currentIndex = 0 + indexMover;
		int indexLimit = 5 + indexMover;
		int offerMenu = 0;
		int pageNumber = 1 + pageMover;
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Please select a vehicle you wish to place an offer on:");
		System.out.println("Current number of cars in inventory is:  " + FirstStructure.lotInventory.size());
		System.out.println("Page " + pageNumber);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Please select the number of the car you wish to place an offer on:  \n");

		while (offerMenu != 1) {
			// TODO Fix this statement
			FirstStructure.carViewer(currentIndex, FirstStructure.lotInventory.size() - (currentIndex + 1));
			System.out.println("6:  For The Next Page\n");
			System.out.println("7:  To Exit");
			String carMenu = scannerActual.next();
			int menuChoice = sevenChoiceMenu(carMenu);
			switch (menuChoice) {
			case 1:
				System.out.println("Making an offer on Car:\n" + "A CAR!!" + "\nPlease an offer amount:");

			case 2:

			case 3:

			case 4:

			case 5:

			case 6:
				indexMover = indexMover + 5;
				pageMover = pageMover + 1;
				placeOffer(indexMover, pageMover);

			case 7:

			}
			offerMenu = 1;
		}
	}

	public static int sevenChoiceMenu(String carMenu) {
		int menuChoice = 0;
		String possibleEntry = ("1,2,3,4,5,6,7");
		if (carMenu.length() > 1 || carMenu.charAt(0) != possibleEntry.charAt(0)
				& carMenu.charAt(0) != possibleEntry.charAt(2) & carMenu.charAt(0) != possibleEntry.charAt(4)
				& carMenu.charAt(0) != possibleEntry.charAt(6) & carMenu.charAt(0) != possibleEntry.charAt(8)
				& carMenu.charAt(0) != possibleEntry.charAt(10) & carMenu.charAt(0) != possibleEntry.charAt(12)) {
			System.out.println("Please enter 1 - 7");
			sevenChoiceMenu(scannerActual.next());
		} else {
			switch (carMenu) {
			case "1":
				menuChoice = 1;
			case "2":
				menuChoice = 2;
			case "3":
				menuChoice = 3;
			case "4":
				menuChoice = 4;
			case "5":
				menuChoice = 5;
			case "6":
				menuChoice = 6;
			case "7":
				menuChoice = 7;
			}

		}
		return menuChoice;
	}
}
