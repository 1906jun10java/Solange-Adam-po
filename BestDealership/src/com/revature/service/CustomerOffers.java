package com.revature.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.data.FirstStructure;
import com.revature.data.OffersData;

public interface CustomerOffers {
	ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	Scanner scannerActual = scannerRomeo.runScanner();
	public static Logger log = Logger.getRootLogger();

	public static void placeOffer(int indexMover, int pageMover, User currentUser) // first call of this needs to be 0, 1
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
			offerMenu(carMenu, currentIndex, pageNumber, currentUser);
			offerMenuBreak = 1;
		}
	}

	public static int offerMenu(String carMenu, int currentIndex, int pageNumber, User currentUser) {
		int menuChoice = 0;
		String possibleEntry = ("1,2,3,4,5,6,7");
		if (carMenu.length() > 1 || carMenu.charAt(0) != possibleEntry.charAt(0)
				& carMenu.charAt(0) != possibleEntry.charAt(2) & carMenu.charAt(0) != possibleEntry.charAt(4)
				& carMenu.charAt(0) != possibleEntry.charAt(6) & carMenu.charAt(0) != possibleEntry.charAt(8)
				& carMenu.charAt(0) != possibleEntry.charAt(10) & carMenu.charAt(0) != possibleEntry.charAt(12)) {
			System.out.println("Please enter 1 - 7");
			offerMenu(scannerActual.next(), currentIndex, pageNumber, currentUser);
		} else {
			switch (carMenu) {
			case "1":
				System.out.println("Creating Offer for:  " + FirstStructure.usedSKU.get(currentIndex + 0));
				OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 0), getOffer(currentUser), currentUser);
				menuChoice = 1;
				break;
			case "2":
				try {
					System.out.println("Creating Offer for:  " + FirstStructure.usedSKU.get(currentIndex + 1));
					OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 1), getOffer(currentUser), currentUser);
				} catch (Exception e) {
					System.out.println("Invaid selection, but congratulatios.  "
							+ "This invalid excption only happens in super special situations");
					log.info(e);
				}
				menuChoice = 2;
				break;
			case "3":
				try {
					System.out.println("Creating Offer for:  " + FirstStructure.usedSKU.get(currentIndex + 2));
					OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 2), getOffer(currentUser), currentUser);
				} catch (Exception e) {
					System.out.println("Invaid selection, but congratulatios.  "
							+ "This invalid excption only happens in super special situations");
					log.info(e);
				}
				break;
			case "4":
				try {
					System.out.println("Creating Offer for:  " + FirstStructure.usedSKU.get(currentIndex + 3));
					OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 3), getOffer(currentUser), currentUser);
				} catch (Exception e) {
					System.out.println("Invaid selection, but congratulatios.  "
							+ "This invalid excption only happens in super special situations");
					log.info(e);
				}
				break;
			case "5":
				try {
					System.out.println("Creating Offer for:  " + FirstStructure.usedSKU.get(currentIndex + 4));
					OffersData.createOffer(FirstStructure.usedSKU.get(currentIndex + 4), getOffer(currentUser), currentUser);
				} catch (Exception e) {
					System.out.println("Invaid selection, but congratulatios.  "
							+ "This invalid excption only happens in super special situations");
					log.info(e);
				}
				break;
			case "6":
				int indexMover = currentIndex + 5;
				int pageMover = pageNumber + 1;
				placeOffer(indexMover, pageMover, currentUser);
				menuChoice = 6;
				break;
			case "7":
				menuChoice = 7;
				break;
			}

		}
		return menuChoice;
	}

	public static double getOffer(User currentUser) {
		System.out.println("Please enter your offer or \"1\" to exit");
		double offerAmount = 0.0;
		String offerAmountInput = scannerActual.next();
		//USING .equals MAKES IT WAY BETTER THEN THE COMPLICATED STRING VERSION
		if (offerAmountInput.equals("1")) {
			return offerAmount;
		} else {
			try {
				offerAmount = Double.parseDouble(offerAmountInput);
			} catch (Exception e) {
				log.info(e);
				getOffer(currentUser);
			}
		}

		return offerAmount;
	}
	
}






















